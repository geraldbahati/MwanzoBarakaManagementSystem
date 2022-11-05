package Data.Models;

import Presentation.Widgets.LoanApplicationPanel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class LoanRepayment {
    private static ArrayList<LoanRepayment> repaymentsRecords;
    private static final String tableTitle = "baraka_db.loan_repayment";
    private static final String tableFields =
            "repay_id, " +
            "loan_id, " +
            "amount_paid, " +
            "instance_created, " +
            "instance_updated";


    private String repayId;
    private String loanId;
    private double amountRepaid;
    private Timestamp created;
    private Timestamp updated;

    public LoanRepayment(String repayId, String loanId, double amountRepaid){
        setCreated(Timestamp.from(Instant.now()));
        setRepayId(repayId);
        setLoanId(loanId);
        setAmountRepaid(amountRepaid);
    }

    public LoanRepayment(String repayId, String loanId, double amountRepaid, Timestamp created, Timestamp updated) {
        this.repayId = repayId;
        this.loanId = loanId;
        this.amountRepaid = amountRepaid;
        this.created = created;
        this.updated = updated;
    }

    public String getRepayId() {
        return repayId;
    }

    public void setRepayId(String repayId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.repayId = repayId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.loanId = loanId;
    }

    public double getAmountRepaid() {
        return amountRepaid;
    }

    public void setAmountRepaid(double amountRepaid) {
        setUpdated(Timestamp.from(Instant.now()));
        this.amountRepaid = amountRepaid;
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

    public static ArrayList<LoanRepayment> getRepaymentsRecords() {
        return repaymentsRecords;
    }

    public static String latestRecordSql() {
        return String.format("SELECT repay_id FROM %s ORDER BY repay_id DESC LIMIT 1;", tableTitle);
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
        try {
            repaymentsRecords = new ArrayList<>();
            while (resultSet.next()) {
                var loanRepayment = new LoanRepayment(
                        resultSet.getString("repay_id"),
                        resultSet.getString("loan_id"),
                        resultSet.getDouble("amount_paid"),
                        resultSet.getTimestamp("instance_created"),
                        resultSet.getTimestamp("instance_created")
                );
                repaymentsRecords.add(loanRepayment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
