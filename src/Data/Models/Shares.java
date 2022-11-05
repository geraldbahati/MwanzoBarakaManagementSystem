package Data.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class Shares {
    private static final String tableTitle = "baraka_db.shares_contribution";
    private static ArrayList<Shares> memberShares;
    private static final String tableFields =
            "contribution_id, " +
                    "member_id, " +
                    "amount_contributed, " +
                    "instance_created, " +
                    "instance_updated";

    private String contributionId;
    private String memberId;
    private double amountContributed;
    private Timestamp created;
    private Timestamp updated;


    public Shares(String contributionId, String memberId, double amountContributed) {
        setCreated(Timestamp.from(Instant.now()));
        setContributionId(contributionId);
        setMemberId(memberId);
        setAmountContributed(amountContributed);
    }

    public Shares(String contributionId, String memberId, double amountContributed, Timestamp created, Timestamp updated) {
        this.contributionId = contributionId;
        this.memberId = memberId;
        this.amountContributed = amountContributed;
        this.created = created;
        this.updated = updated;
    }

    public static ArrayList<Shares> getMemberShares() {
        return memberShares;
    }

    public String getContributionId() {
        return contributionId;
    }

    public void setContributionId(String contributionId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.contributionId = contributionId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.memberId = memberId;
    }

    public double getAmountContributed() {
        return amountContributed;
    }

    public void setAmountContributed(double amountContributed) {
        setUpdated(Timestamp.from(Instant.now()));
        this.amountContributed = amountContributed;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public static String latestRecordSql() {
        return String.format("SELECT contribution_id FROM %s ORDER BY contribution_id DESC LIMIT 1;", tableTitle);
    }

    public String toSqlStatement() {
        StringBuilder tableValues = new StringBuilder();
        for(String ignored : tableFields.split(",")){
            tableValues.append("?,");
        }
        tableValues.deleteCharAt(tableValues.length() - 1);

        return String.format("INSERT INTO %s (%s) VALUE (%s)", tableTitle, tableFields, tableValues);
    }

    public static void fromDatabase(ResultSet resultSet) {
        memberShares = new ArrayList<>();
        try {
            while (resultSet.next()) {
                var shares = new Shares(
                        resultSet.getString("contribution_id"),
                        resultSet.getString("member_id"),
                        resultSet.getDouble("amount_contributed"),
                        resultSet.getTimestamp("instance_created"),
                        resultSet.getTimestamp("instance_created")
                );
                memberShares.add(shares);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
