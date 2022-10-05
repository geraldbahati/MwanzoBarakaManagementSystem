package Logic;

import Data.Constants.CustomExceptions.SQLFailedToConnect;
import Data.DBConnections.DBManager;
import Data.Models.Enums.Gender;
import Data.Models.Group;
import Data.Models.Member;
import Logic.CustomExceptions.InvalidFieldEnteredException;

import java.sql.*;

public class MemberEvent {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;


    public void loadDataForDatabase(String sqlQueryStatement)  {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQueryStatement);
            Member.fromDatabase(resultSet);
            resultSet.close();
            statement.close();
        } catch (Exception exception){

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

    public void getCurrentMember() {

    }

    private void sendMemberDataToDatabase(Member member) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(member.toSqlStatement());
                preparedStatement.setString (1, Member.generateMemberId());
                preparedStatement.setString (2, member.getFirstName());
                preparedStatement.setString(3,member.getLastName());
                preparedStatement.setString(4,member.getGender());
                preparedStatement.setDate(5, member.getDateOfBirth());
                preparedStatement.setString(6,member.getMobileNumber());
                preparedStatement.setString(7,member.getEmail());
                preparedStatement.setTimestamp(8,member.getCreated());
                preparedStatement.setTimestamp(9,member.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            throw new InvalidFieldEnteredException();
        }
    }
}
