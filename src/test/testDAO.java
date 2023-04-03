package test;

import daos.RegionDAO;
import models.Region;

public class testDAO {
    public static void main(String[] args) {
        test_getById();
    }

    public static void test_getById() {
        Region region = new Region(10, "okey", 6);

        RegionDAO regionDAO = new RegionDAO();
        region = regionDAO.save(region);

    }
}
