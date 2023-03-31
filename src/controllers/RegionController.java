package controllers;

import java.util.List;

import controllers.icontrollers.IRegionController;
import daos.RegionDAO;
import models.Region;
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
            regionView.displayMessage("Data added successfully");
        }
    }

    @Override
    public void readRegion() {
        try {
            String inpuString = regionView.readString("enter Id or Name");
            if (inpuString.matches("\\d")) {
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

    }

    @Override
    public void deleteRegion() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteRegion'");
    }

    @Override
    public void listRegion() {
        List<Region> regions = regionDAO.getAll();
        regionView.displayList(regions);
    }

}
