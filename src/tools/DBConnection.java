package tools;

import java.sql.Connection;
import java.sql.DriverManager;

import exeption.databaseConnectionExeption;

public class DBConnection {
    private Connection connection;

    /*
     * set mysql database
     */
    private final String dbname = "db_hr_sbkm";
    private final String port = "3306";
    private final String user = "root";
    private final String pass = "";

    private final String url = "jdbc:mysql://localhost:" + port + "/" + dbname + "?zeroDateTimeBehavior=convertToNull";

    public Connection getConnection() throws databaseConnectionExeption {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            throw new databaseConnectionExeption("Database is not Connected");
        }
        return connection;
    }
}
