package controllers;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import controllers.icontrollers.IRegionController;
import daos.RegionDAO;
import exeption.ValidationProperty;
import models.Region;
import tools.Utility;

public class RegionController implements IRegionController {

    private RegionDAO regionDAO;

    public RegionController(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    @Override
    public List<Region> listRegions() {
        return regionDAO.getAll();
    }

    @Override
    public String create(String id, String name, String count) {
        String result = "";
        try {
            this.validationPropertyRegion(id, name, count);
            Region region = new Region(Integer.parseInt(id), name, Integer.parseInt(count));
            region = regionDAO.save(region);
            if (region != null) result = "Create region data successfully";
        } catch (Exception e) {
            result = e.getMessage();
        } catch (ValidationProperty e) {
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Region getById(String id) {
        return regionDAO.getById(Integer.parseInt(id));
    }

    @Override
    public List<Region> searchNameByCharacter(String key) {
        return regionDAO.searchByCharacter(key);
    }

    @Override
    public List<Region> searchByName(String name) {
        List<Region> regions = regionDAO
                        .getAll()
                        .stream()
                        .filter(region -> region.getName().contains(name))
                        .collect(Collectors.toList());
        return regions;
    }

    @Override
    public String update(String id, String name, String count) {
        String result = "";
        try {
            this.validationPropertyRegion(id, name, count);
            Region region = new Region(Integer.parseInt(id), name, Integer.parseInt(count));
            region = this.regionDAO.save(region);
            if (region != null) result = "Update region data successfully";
        } catch (Exception e) {
            result = e.getMessage();
        } catch (ValidationProperty e) {
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(String id) {
        if (!predicateisNumber.test(id)) return "input invalid! please enter an Interger";
        try {
            int id_region = Integer.parseInt(id);
            Region region = regionDAO.getById(id_region);
            if (region == null) {
                return "Data is not found!";
            }else{
                regionDAO.delete(region);
                return "Delete region data successfully";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void validationPropertyRegion(String id, String name, String count) throws ValidationProperty {
        if (!predicateisNumber.test(id) || !predicateisNumber.test(count)) {
            throw new ValidationProperty("input invalid! please enter an Integer") ;
        } else if (!predicateisLetter.test(name)) {
            throw new ValidationProperty( "input invalid! please enter a Letter");
        }
    }

    Predicate<String> predicateisNumber = Utility::isNumber;
    Predicate<String> predicateisLetter = Utility::isLetter;

}
