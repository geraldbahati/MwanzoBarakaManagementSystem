package Logic;

import Data.Constants.CustomExceptions.SQLFailedToConnect;
import Data.DBConnections.DBManager;
import Data.Models.Group;
import Data.Models.GroupMember;
import Logic.CustomExceptions.InvalidFieldEnteredException;

import java.sql.*;

public class GroupEvent {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;

    public void loadGroupMembers(Group groupSelected) {
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(groupSelected.getGroupMembersSql());
            GroupMember.fromDatabase(resultSet);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception){
            System.out.println(exception.getMessage());
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
            Group.fromDatabase(resultSet);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void submitGroupToDatabase(Group group) {
        try {
            connection = new DBManager().connectToDB();
            sendGroupDataToDatabase(group);

        } catch (SQLFailedToConnect sql){
            sql.printStackTrace();
            System.out.println("Sql Failure");
        } catch (InvalidFieldEnteredException e){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("Invalid data");
        }

    }

    private void sendGroupDataToDatabase(Group group) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(group.toSqlStatement());
                preparedStatement.setString (1,group.getGroupId());
                preparedStatement.setString (2, group.getGroupName());
                preparedStatement.setTimestamp(3,group.getCreated());
                preparedStatement.setTimestamp(4,group.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }
}
