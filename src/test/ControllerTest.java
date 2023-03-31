package test;

import controllers.RegionController;
import daos.RegionDAO;
import exeption.databaseConnectionExeption;
import tools.DBConnection;
import views.RegionView;

public class ControllerTest {
    public static void main(String[] args) {
        test_createItem();
    }

    public static void test_createItem() {
        try {
            DBConnection dbConnection = new DBConnection();
            RegionDAO regionDAO;
            regionDAO = new RegionDAO(dbConnection.getConnection());
            RegionView regionView = new RegionView();
            RegionController regionController = new RegionController(regionDAO, regionView);
            regionController.createRegion();
        } catch (databaseConnectionExeption e) {
            e.printStackTrace();
        }

    }
}
