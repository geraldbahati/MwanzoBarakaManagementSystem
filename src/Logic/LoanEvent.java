package Logic;

import Data.Constants.CustomExceptions.SQLFailedToConnect;
import Data.DBConnections.DBManager;
import Data.Models.MemberLoan;
import Logic.CustomExceptions.InvalidFieldEnteredException;

import java.sql.*;

public class LoanEvent {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;

    public String generateLoanId() {
        String recentId = "";
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(MemberLoan.latestRecordSql());

            while (resultSet.next()){
                recentId = resultSet.getString("loan_id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (recentId.equals("")) return "L-001";
        int newIndex = Integer.parseInt(recentId.split("-")[1]) + 1;
        return "L-" + String.format("%03d",newIndex);

    }

    public void loadDataForDatabase(String sqlQueryStatement) {
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQueryStatement);
            MemberLoan.fromDatabase(resultSet);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void submitLoanToDatabase(MemberLoan loan) {
        try {
            connection = new DBManager().connectToDB();
            sendLoanToDatabase(loan);

        } catch (SQLFailedToConnect sql){
            sql.printStackTrace();
            System.out.println("Sql Failure");
        } catch (InvalidFieldEnteredException e){
            e.printStackTrace();
            System.out.println("Invalid data");
        }

    }

    private void sendLoanToDatabase(MemberLoan loan) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(loan.toSqlStatement());
                preparedStatement.setString (1,loan.getLoanId());
                preparedStatement.setString (2, loan.getMemberId());
                preparedStatement.setDouble(3,loan.getInterestRate());
                preparedStatement.setDouble(4, loan.getAmountBorrowed());
                preparedStatement.setDate(5,loan.getDueDate());
                preparedStatement.setBoolean(6,loan.isPaid());
                preparedStatement.setTimestamp(7,loan.getCreated());
                preparedStatement.setTimestamp(8,loan.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }
}
