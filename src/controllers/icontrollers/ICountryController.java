package controllers.icontrollers;

import java.util.List;
import models.Country;

public interface ICountryController {
    public List<Country> listContries();

    public Country getById(String id);

    public List<Country> searchNameByCharacter(String key);

    public List<Country> searchByName(String name);

    public String create(String id, String name, String region_id);

    public String update(String id, String name, String region_id);

    public String delete(String id);

}
