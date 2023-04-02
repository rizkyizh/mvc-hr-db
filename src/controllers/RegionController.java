package controllers;

import java.util.List;

import controllers.icontrollers.IRegionController;
import daos.RegionDAO;
import exeption.databaseConnectionExeption;
import models.Region;
import tools.DBConnection;
import tools.Utility;
import views.RegionView;

public class RegionController implements IRegionController {

    private RegionDAO regionDAO;
    private RegionView regionView;

    public RegionController(RegionDAO regionDAO, RegionView regionView) {
        this.regionDAO = regionDAO;
        this.regionView = regionView;
    }

    @Override
    public void createRegion() {
        regionView.displayMessage("==== Add New Data ==============");
        Region newRegion = new Region(
                regionView.readInteger("id"),
                regionView.readString("name"),
                regionView.readInteger("count"));
        boolean success = regionDAO.create(newRegion);
        if (success) {
            regionView.displayMessage("\nData added successfully");

            try {
                DBConnection dbConnection = new DBConnection();
                RegionDAO regionDAO = new RegionDAO(dbConnection.getConnection());
                RegionView regionView = new RegionView();
                RegionController listupdate = new RegionController(regionDAO, regionView);
                listupdate.listRegion();
            } catch (databaseConnectionExeption e) {
                Utility.clearScreen();
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void readRegion() {
        try {
            String inpuString = regionView.readString("enter Id or Name");
            if (inpuString.isEmpty()) {
                regionView.displayMessage("Data is not found! please enter id or name");
            } else if (inpuString.matches("\\d")) {
                int byId = Integer.parseInt(inpuString);
                Region result = regionDAO.getById(byId);
                regionView.displayItem(result);
            } else {
                List<Region> result = regionDAO.searchByName(inpuString);
                regionView.displaySearchItems(result);
            }
        } catch (Exception e) {
            regionView.displayMessage(e.getMessage());
        }
    }

    @Override
    public void updateRegion() {
        try {
            this.listRegion();
            regionView.displayMessage("==== Update Data ==============");
            Region updateRegion = new Region(
                    regionView.readInteger("id (required)"),
                    regionView.readString("new name"),
                    regionView.readInteger("new count"));

            RegionDAO regionDAO = new RegionDAO();

            if (updateRegion.getName().isEmpty()) {
                Region oldRegion = regionDAO.getById(updateRegion.getId());
                updateRegion.setName(oldRegion.getName());
            }

            boolean success = regionDAO.update(updateRegion);
            if (success) {
                regionView.displayMessage("\nData update successfully");
            } else {
                regionView.displayMessage("\nData update failed! please enter correct Id");
            }
        } catch (Exception e) {
            regionView.displayMessage(e.getMessage());
        }
    }

    @Override
    public void deleteRegion() {
        try {
            this.listRegion();
            regionView.displayMessage("==== Delete Data ==============");
            int id = regionView.readInteger("input id which you want to delete");

            Region region = new Region(id);
            RegionDAO regionDAO = new RegionDAO();

            if (regionDAO.getById(id) != null) {
                regionDAO.delete(region);
                regionView.displayMessage("Data id " + id + " has been deleted!");
            }

        } catch (Exception e) {
            regionView.displayMessage(e.getMessage());
        }
    }

    @Override
    public void listRegion() {
        List<Region> regions = regionDAO.getAll();
        regionView.displayList(regions);
    }

}
