package Data.DBConnections;

import Data.Constants.CustomExceptions.SQLFailedToConnect;

import java.sql.*;


public class DBManager {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/baraka_db";
    private final String USER = "root";
    private final String PASSWORD = "GBahati@12";

    public Connection connectToDB() throws SQLFailedToConnect {
        try {
            // get a connection to database
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    DATABASE_URL,
                    USER,
                    PASSWORD
            );
        } catch (Exception exception) {
            throw new SQLFailedToConnect();
        }
    }
}