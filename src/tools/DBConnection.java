package tools;

import java.sql.Connection;
import java.sql.DriverManager;

import exeption.databaseConnectionExeption;

public class DBConnection {
    private Connection connection;

    /*
     * set mysql database
     */
    private String dbname = "db_hr_sbkm";
    private String port = "3306";
    private String user = "root";
    private String pass = "";

    private String url = "jdbc:mysql://localhost:" + port + "/" + dbname + "?zeroDateTimeBehavior=convertToNull";

    public Connection getConnection() throws databaseConnectionExeption {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            throw new databaseConnectionExeption("Database is't Connected");
        }
        return connection;
    }
}
