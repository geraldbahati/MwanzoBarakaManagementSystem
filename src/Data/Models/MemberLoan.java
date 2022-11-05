package Data.Models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class MemberLoan {
    private static MemberLoan activeLoan = null;
    private static final String tableTitle = "baraka_db.loan";
    private static final String tableFields =
            "loan_id, " +
            "member_id, " +
            "interest_rate, " +
            "amount_borrowed, " +
            "due_date, " +
            "is_paid, " +
            "instance_created, " +
            "instance_updated";

    private String loanId;
    private String memberId;
    private double interestRate;
    private double amountBorrowed;
    private boolean isPaid = false;
    private Date dueDate;
    private Timestamp created;
    private Timestamp updated;

    public MemberLoan(
            String loanId,
            String memberId,
            double interestRate,
            double amountBorrowed,
            Date dueDate
    ) {
        setCreated(Timestamp.from(Instant.now()));
        setLoanId(loanId);
        setMemberId(memberId);
        setInterestRate(interestRate);
        setAmountBorrowed(amountBorrowed);
        setDueDate(dueDate);
    }

    public MemberLoan(
            String loanId,
            String memberId,
            double interestRate,
            double amountBorrowed,
            boolean isPaid,
            Date dueDate,
            Timestamp created,
            Timestamp updated
    ) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.interestRate = interestRate;
        this.amountBorrowed = amountBorrowed;
        this.isPaid = isPaid;
        this.dueDate = dueDate;
        this.created = created;
        this.updated = updated;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.loanId = loanId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.memberId = memberId;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        setUpdated(Timestamp.from(Instant.now()));
        this.interestRate = interestRate;
    }

    public double getAmountBorrowed() {
        return amountBorrowed;
    }

    public void setAmountBorrowed(double amountBorrowed) {
        setUpdated(Timestamp.from(Instant.now()));
        this.amountBorrowed = amountBorrowed;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        setUpdated(Timestamp.from(Instant.now()));
        isPaid = paid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        setUpdated(Timestamp.from(Instant.now()));
        this.dueDate = dueDate;
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

    public static MemberLoan getActiveLoan() {
        return activeLoan;
    }

    public static String latestRecordSql() {
        return String.format("SELECT loan_id FROM %s ORDER BY loan_id DESC LIMIT 1;", tableTitle);
    }

    public static void setLoanNull(){
        activeLoan = null;
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
            while (resultSet.next()) {
                var loan = new MemberLoan(
                        resultSet.getString("loan_id"),
                        resultSet.getString("member_id"),
                        resultSet.getDouble("interest_rate"),
                        resultSet.getDouble("amount_borrowed"),
                        resultSet.getInt("is_paid") != 0,
                        resultSet.getDate("due_date"),
                        resultSet.getTimestamp("instance_created"),
                        resultSet.getTimestamp("instance_created")
                );
                activeLoan = loan;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
