package Logic;


import Data.Constants.CustomExceptions.SQLFailedToConnect;
import Data.DBConnections.DBManager;
import Data.Models.Group;
import Data.Models.GroupShares;
import Data.Models.Shares;
import Logic.CustomExceptions.InvalidFieldEnteredException;

import java.sql.*;

public class SharesEvent {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;

    public String generateGroupSharesId() {
        String recentId = "";
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GroupShares.latestRecordSql());

            while (resultSet.next()){
                recentId = resultSet.getString("group_shares_id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (recentId.equals("")) return "GC-001";
        int newIndex = Integer.parseInt(recentId.split("-")[1]) + 1;
        return "GC-" + String.format("%03d",newIndex);

    }

    public String generateSharesId() {
        String recentId = "";
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Shares.latestRecordSql());

            while (resultSet.next()){
                recentId = resultSet.getString("contribution_id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (recentId.equals("")) return "C-001";
        int newIndex = Integer.parseInt(recentId.split("-")[1]) + 1;
        return "C-" + String.format("%03d",newIndex);

    }

    public void loadGroupShares(Group group) {
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    String.format(
                            "SELCET * FROM baraka_db.group_shares_contribution WHERE group_id = \"%s\"",
                            group.getGroupId()
                    )
            );
            GroupShares.fromDatabase(resultSet);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception){
            exception.printStackTrace();
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void loadDataForDatabase(String sqlQueryStatement) {
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQueryStatement);
            Shares.fromDatabase(resultSet);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception){
            exception.printStackTrace();
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void submitGroupContributionToDatabase(GroupShares shares) {
        try {
            connection = new DBManager().connectToDB();
            sendGroupContributionToDatabase(shares);

        } catch (SQLFailedToConnect sql){
            sql.printStackTrace();
            System.out.println("Sql Failure");
        } catch (InvalidFieldEnteredException e){
            e.printStackTrace();
            System.out.println("Invalid data");
        }

    }

    public void submitContributionToDatabase(Shares shares) {
        try {
            connection = new DBManager().connectToDB();
            sendContributionToDatabase(shares);

        } catch (SQLFailedToConnect sql){
            sql.printStackTrace();
            System.out.println("Sql Failure");
        } catch (InvalidFieldEnteredException e){
            e.printStackTrace();
            System.out.println("Invalid data");
        }

    }

    private void sendContributionToDatabase(Shares shares) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(shares.toSqlStatement());
                preparedStatement.setString (1,shares.getContributionId());
                preparedStatement.setString (2, shares.getMemberId());
                preparedStatement.setDouble(3,shares.getAmountContributed());
                preparedStatement.setTimestamp(4,shares.getCreated());
                preparedStatement.setTimestamp(5,shares.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }

    private void sendGroupContributionToDatabase(GroupShares shares) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(shares.toSqlStatement());
                preparedStatement.setString (1,shares.getContributionId());
                preparedStatement.setString (2, shares.getGroup().getGroupId());
                preparedStatement.setString(3,shares.getMemberId());
                preparedStatement.setTimestamp(4,shares.getCreated());
                preparedStatement.setTimestamp(5,shares.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }


}
