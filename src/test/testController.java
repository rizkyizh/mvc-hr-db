package test;

import controllers.RegionController;
import daos.RegionDAO;
import models.Region;

public class testController {
    public static void main(String[] args) {
        test_delete();
    }

    public static void test_create() {
        RegionDAO regionDAO = new RegionDAO();
        RegionController regionController = new RegionController(regionDAO);
        // regionController.create("sdf", "surakat", "sdf");

        System.out.println(regionController.create("7", "coba", "dfgdfg"));
    }

    public static void test_getById() {
        RegionDAO regionDAO = new RegionDAO();
        RegionController regionController = new RegionController(regionDAO);
        System.out.println(
                regionController.getById("10"));
    }

    public static void test_update() {
        RegionDAO regionDAO = new RegionDAO();
        RegionController regionController = new RegionController(regionDAO);
        // regionController.create("sdf", "surakat", "sdf");

        System.out.println(regionController.update("7", "2425", "33"));
    }

    public static void test_delete() {
        RegionDAO regionDAO = new RegionDAO();
        RegionController regionController = new RegionController(regionDAO);
        // regionController.create("sdf", "surakat", "sdf");

        System.out.println(regionController.delete("dfggf"));
    }
}
