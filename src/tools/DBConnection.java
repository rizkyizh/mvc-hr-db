package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exeption.databaseConnectionExeption;

public class DBConnection {
    private Connection connection;
    // private String url =
    // "jdbc:mysql://localhost:3306/db_hr_sbkm?zeroDateTimeBehavior=convertToNull";
    private String url = "jdbc:mysql://localhost:3306/db_hr_sbkm";
    private String user = "root";
    private String pass = "";

    public Connection getConnection() throws databaseConnectionExeption {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Database Connected");
        } catch (Exception e) {
            throw new databaseConnectionExeption("Database is't Connected");
        }
        return connection;
    }
}
