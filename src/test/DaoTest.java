package test;

import daos.RegionDAO;
import daos.idaos.IRegionDao;
import models.Region;
import tools.DBConnection;

public class DaoTest {
    public static void main(String[] args) {
        testGetAll_Region();
    }

    public static void testGetAll_Region() {
        DBConnection dbConnection = new DBConnection();
        IRegionDao regionDao = new RegionDAO(dbConnection.getConnection());
        for (Region region : regionDao.getAll()) {
            System.out.println(region.getId() + region.getName() + region.getCount());
        }
    }

    public static void testCreate_Region() {
        DBConnection dbConnection = new DBConnection();
        IRegionDao regionDao = new RegionDAO(dbConnection.getConnection());

        Region region = new Region(5, "Australia", 2);
        System.out.println(regionDao.create(region));

    }

    public static void testOnly() {
        Region region;
        String region2;

        region = new Region(1, "ok", 3);

        region2 = region.getName();

        System.out.println(region);
    }

}
