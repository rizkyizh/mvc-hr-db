package controllers;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import controllers.icontrollers.ICountryController;
import daos.CountryDAO;
import exeption.ValidationProperty;
import models.*;
import tools.Utility;

public class CountryController implements ICountryController {

    private CountryDAO countryDAO;

    public CountryController() {
        this.countryDAO = new CountryDAO();
    }
    

    public CountryController(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    public List<Country> listContries() {
        return this.countryDAO.getAll();
    }

    @Override
    public Country getById(String id) {
        return this.countryDAO.getById(id);
    }

    @Override
    public List<Country> searchNameByCharacter(String key) {
        return this.countryDAO.searchByCharacter(key);
    }

    @Override
    public List<Country> searchByName(String name) {
        List<Country> countries = this.countryDAO
                .getAll()
                .stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return countries;
    }

    @Override
    public String create(String id, String name, String region_id) {
        String result = "";
        try {
            this.validationPropertyRegion(id, name, region_id);           
            Country country = new Country(id, name, Integer.parseInt(region_id));
            if (countryDAO.getById(country.getId()) == null) {
                country = countryDAO.save(country);
                if (country == null) result = "Create country data successfully";
            }else{
                result = "Country with id " + country.getId() + " already registered!\nplease input another id!"; 
            }
        } catch (Exception e) {
            result = e.getMessage();
        } catch (ValidationProperty e) {
            result = e.getMessage();
        } 
        return result;
    }

    @Override
    public String update(String id, String name, String region_id) {
        String result = "";
        try {
            this.validationPropertyRegion(id, name, region_id);           
            Country country = new Country(id, name, Integer.parseInt(region_id));
            if (countryDAO.getById(country.getId()) != null) {
                country = this.countryDAO.save(country);
                if (country != null) result = "Update country data successfully";
            }else{
                result = "Country with id " + country.getId() + " have not registered!\nplease input another id!";
            }
        } catch (Exception e) {
            result = e.getMessage();
        } catch (ValidationProperty e) {
            result = e.getMessage();
        } 
        return result;
    }

    @Override
    public String delete(String id) {
        if (!predicateisLetter.test(id)) return "input invalid! please enter a Letter";
        try {
            Country country = countryDAO.getById(id);
            if (country == null) {
                return "Data is not found!";
            }else{
                countryDAO.delete(country);
                return "Delete country data successfully";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    private void validationPropertyRegion(String id, String name, String region_id) throws ValidationProperty {
        if (!predicateisLetter.test(id)) {
            throw new ValidationProperty( "input id invalid! please enter a Letter");
        } else if (!predicateisLetter.test(name)) {
            throw new ValidationProperty( "input name invalid! please enter a Letter");
        }else if (!predicateisNumber.test(region_id)) {
            throw new ValidationProperty("input region id invalid! please enter an Integer") ;
        }
    }


    Predicate<String> predicateisNumber = Utility::isNumber;
    Predicate<String> predicateisLetter = Utility::isLetter;


    
    
}
