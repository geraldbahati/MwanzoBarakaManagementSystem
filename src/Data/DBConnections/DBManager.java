package Data.DBConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBManager {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/baraka_db";
    private final String USER = "root";
    private final String PASSWORD = "GBahati@12";

    private static Connection connection = null;
    DBManager() {

        try {
            // get a connection to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    DATABASE_URL,
                    USER,
                    PASSWORD
                    );

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from designation");
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
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    private void connectToDB() {
        try {
            // get a connection to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    DATABASE_URL,
                    USER,
                    PASSWORD
            );

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from designation");
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
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void loadData() {

    }

    public void addData() {

    }

    public void updateData() {

    }

    public void deleteData() {

    }
}
