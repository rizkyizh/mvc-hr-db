
package daos.idaos;

import java.util.List;

import models.Region;

public interface IRegionDao {
    public List<Region> getAll(); // getAll

    public Region getById(Integer id); // getById

    public List<Region> searchByCharacter(String key); // searchByCharacter

    // public boolean create(Region region); // create

    // public boolean update(Region region); // update

    public Region save(Region region); // create and update

    public boolean delete(Region region); // delete

}