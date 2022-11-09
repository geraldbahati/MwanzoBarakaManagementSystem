package Data.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class GroupShares {
    private static final String tableTitle = "baraka_db.group_shares_contribution";
    private static ArrayList<GroupShares> groupShares;
    private static final String tableFields =
            "group_shares_id, " +
            "group_tied, " +
            "member_id, " +
            "instance_created, " +
            "instance_updated";

    private String contributionId;
    private Group group;
    private String memberId;
    private Timestamp created;
    private Timestamp updated;


    public GroupShares(String contributionId, Group group,String memberId) {
        setCreated(Timestamp.from(Instant.now()));
        setContributionId(contributionId);
        setMemberId(memberId);
        setGroup(group);
    }

    public GroupShares(String contributionId, Group group, String memberId, Timestamp created, Timestamp updated) {
        this.contributionId = contributionId;
        this.group = group;
        this.memberId = memberId;
        this.created = created;
        this.updated = updated;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        setUpdated(Timestamp.from(Instant.now()));
        this.group = group;
    }

    public static ArrayList<GroupShares> getGroupShares() {
        return groupShares;
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
        return String.format("SELECT group_shares_id FROM %s ORDER BY group_shares_id DESC LIMIT 1;", tableTitle);
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
        groupShares = new ArrayList<>();
        try {
            while (resultSet.next()) {
                var shares = new GroupShares(
                        resultSet.getString("group_shares_id"),
                        new Group(resultSet.getString("group_id")),
                        resultSet.getString("member_id"),
                        resultSet.getTimestamp("instance_created"),
                        resultSet.getTimestamp("instance_created")
                );
                groupShares.add(shares);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
