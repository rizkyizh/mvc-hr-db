import tools.DBConnection;

public class App {
    public static void main(String[] args) throws Exception {
        DBConnection dbConnection = new DBConnection();
        System.out.println(dbConnection.getConnection());

    }
}
