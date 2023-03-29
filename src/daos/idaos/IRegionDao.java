
package daos.idaos;

import java.util.List;

import models.Region;

public interface IRegionDao {
    public List<Region> getAll(); // getAll

    // getById
    // searchByName

    public boolean create(Region region); // create

    public boolean update(Region region); // update

    public boolean delete(Region region); // delete

}