package test;

import daos.RegionDAO;
import daos.idaos.IRegionDao;
import models.Region;
import tools.DBConnection;

public class DaoTest {
    public static void main(String[] args) {
        testUpdate_Region();
    }

    public static void testGetAll_Region() {
        DBConnection dbConnection = new DBConnection();
        IRegionDao regionDao = new RegionDAO(dbConnection.getConnection());
        for (Region region : regionDao.getAll()) {
            System.out.println(region.getId() + region.getName() + region.getCount());
        }
    }

    public static void testGetById_Region() {
        DBConnection connection = new DBConnection();
        IRegionDao regionDao = new RegionDAO(connection.getConnection());
        Region region = regionDao.getById(2);
        System.out.println(region.getId());
        System.out.println(region.getName());
        System.out.println(region.getCount());
    }

    public static void testCreate_Region() {
        DBConnection dbConnection = new DBConnection();
        IRegionDao regionDao = new RegionDAO(dbConnection.getConnection());

        Region region = new Region(5, "Australia", 2);
        System.out.println(regionDao.create(region));

    }

    public static void testUpdate_Region() {
        DBConnection dbConnection = new DBConnection();
        IRegionDao regionDao = new RegionDAO(dbConnection.getConnection());

        Region regionUpdate = new Region(5, "Australia");

        System.out.println(regionDao.update(regionUpdate));

    }

    public static void testOnly() {
        Region region;
        boolean region2;

        // region = new Region();
        // region.setCount(2);

        // region2 = region.getCount() == null;

        // System.out.println(region2);
        // int indexParams = 1;
        // System.out.println(++indexParams);
        // System.out.println("setelah di incre : " + indexParams);
        // System.out.println(indexParams++);
        // System.out.println(indexParams++);

    }

}
