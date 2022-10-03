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
            int code;
            String title;

            String memberID;
            String firstName;
            String lastName;
            Gender gender;
            Date dateOfBirth;
            String mobileNumber;
            String email;
            Group associatedGroup;
            boolean isAdmin;
            Timestamp created;
            Timestamp updated;

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQueryStatement);

            while (resultSet.next()) {
                code = resultSet.getInt("code");
                title = resultSet.getString("title").trim();
                System.out.println("Code : " + code
                        + " Title : " + title);
            }
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

    private void sendMemberDataToDatabase(Member member) throws InvalidFieldEnteredException {
        try {
            if(connection!=null){
                preparedStatement = connection.prepareStatement(member.toSqlStatement());
//                preparedStatement.setString (1, member.getMemberID());
                preparedStatement.setString (1, member.getFirstName());
                preparedStatement.setString(2,member.getLastName());
                preparedStatement.setString(3,member.getGender());
                preparedStatement.setDate(4, member.getDateOfBirth());
                preparedStatement.setString(5,member.getMobileNumber());
                preparedStatement.setString(6,member.getEmail());
                preparedStatement.setTimestamp(7,member.getCreated());
                preparedStatement.setTimestamp(8,member.getUpdated());

                preparedStatement.execute();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            throw new InvalidFieldEnteredException();
        }
    }
}
