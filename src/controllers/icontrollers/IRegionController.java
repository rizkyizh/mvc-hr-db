package controllers.icontrollers;

import java.util.List;

import models.Region;

public interface IRegionController {

    public List<Region> listRegions();

    public Region getById(String id);

    public List<Region> searchNameByCharacter(String key);

    public List<Region> searchByName(String name);

    public String create(String id, String name, String count);

    public String update(String id, String name, String count);

    public String delete(String id);

}
