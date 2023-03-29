package tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/db_hr_sbkm?zeroDateTimeBehavior=convertToNull";
    private String user = "root";
    private String pass = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println("Error Message = " + e.getMessage());
        }
        return connection;
    }
}
