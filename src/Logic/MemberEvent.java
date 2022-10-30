package Logic;

import Data.Constants.CustomExceptions.SQLFailedToConnect;
import Data.DBConnections.DBManager;
import Data.Models.Member;
import Logic.CustomExceptions.InvalidFieldEnteredException;

import java.sql.*;

public class MemberEvent {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;


    public void loadDataForDatabase(String sqlQueryStatement) {
        try {
            connection = new DBManager().connectToDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQueryStatement);
            Member.fromDatabase(resultSet);

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

    public void submitMemberToDatabase(Member member) {
        try {
            connection = new DBManager().connectToDB();
            sendMemberDataToDatabase(member);

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

    public void submitRegistrationFee(Member member) {
        try {
            connection = new DBManager().connectToDB();
            sendRegistrationFeeToDatabase(member);

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

    private void sendMemberDataToDatabase(Member member) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(member.toSqlStatement());
                preparedStatement.setString (1,member.getMemberID());
                preparedStatement.setString (2, member.getFirstName());
                preparedStatement.setString(3,member.getLastName());
                preparedStatement.setString(4,member.getGender());
                preparedStatement.setDate(5, member.getDateOfBirth());
                preparedStatement.setString(6,member.getMobileNumber());
                preparedStatement.setString(7,member.getEmail());
                preparedStatement.setString(8,(member.getAssociatedGroup() == null)?null : member.getAssociatedGroup().getGroupId());
                preparedStatement.setTimestamp(9,member.getCreated());
                preparedStatement.setTimestamp(10,member.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }

    private void sendRegistrationFeeToDatabase(Member member) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(member.getRegistrationSQL());
                preparedStatement.setString (1,member.getMemberID());
                preparedStatement.setDouble(2, Member.getRegistrationFee());
                preparedStatement.setTimestamp(3,member.getCreated());
                preparedStatement.setTimestamp(4,member.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidFieldEnteredException();
        }
    }
}
