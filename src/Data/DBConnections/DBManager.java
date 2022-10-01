package Data.DBConnections;

import java.sql.*;


public class DBManager {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/baraka_db";
    private final String USER = "root";
    private final String PASSWORD = "GBahati@12";

    private static Connection connection = null;


    private Connection connectToDB() {
        try {
            // get a connection to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    DATABASE_URL,
                    USER,
                    PASSWORD
            );

            return connection;
//            resultSet.close();
//            statement.close();
//            connection.close();
        }
        catch (Exception exception) {
            return null;
        }
    }

    public void loadData(String sqlQueryStatement)  {
       try {
           Statement statement;
           statement = connection.createStatement();
           ResultSet resultSet;
           resultSet = statement.executeQuery(sqlQueryStatement);
           int code;
           String title;
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

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
