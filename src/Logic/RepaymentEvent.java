package Logic;

import Data.Constants.CustomExceptions.SQLFailedToConnect;
import Data.DBConnections.DBManager;
import Data.Models.LoanRepayment;
import Logic.CustomExceptions.InvalidFieldEnteredException;

import java.sql.*;

public class RepaymentEvent {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;

    public String generateRepayId() {
        String recentId = "";
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(LoanRepayment.latestRecordSql());

            while (resultSet.next()){
                recentId = resultSet.getString("repay_id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (recentId.equals("")) return "R-001";
        int newIndex = Integer.parseInt(recentId.split("-")[1]) + 1;
        return "R-" + String.format("%03d",newIndex);

    }

    public void loadDataForDatabase(String sqlQueryStatement) {
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQueryStatement);
            LoanRepayment.fromDatabase(resultSet);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void submitLoanToDatabase(LoanRepayment repayment) {
        try {
            connection = new DBManager().connectToDB();
            sendLoanToDatabase(repayment);

        } catch (SQLFailedToConnect sql){
            sql.printStackTrace();
            System.out.println("Sql Failure");
        } catch (InvalidFieldEnteredException e){
            e.printStackTrace();
            System.out.println("Invalid data");
        }

    }

    private void sendLoanToDatabase(LoanRepayment repayment) throws InvalidFieldEnteredException {
        try {
            System.out.println(repayment.getLoanId());
            if(connection!=null){
                preparedStatement = connection.prepareStatement(repayment.toSqlStatement());
                preparedStatement.setString (1,repayment.getRepayId());
                preparedStatement.setString (2, repayment.getLoanId());
                preparedStatement.setDouble(3,repayment.getAmountRepaid());
                preparedStatement.setTimestamp(4,repayment.getCreated());
                preparedStatement.setTimestamp(5,repayment.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }
}
