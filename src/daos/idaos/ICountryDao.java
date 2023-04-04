package daos.idaos;

import java.sql.*;
import java.util.List;

import models.Country;

public interface ICountryDao {
    public List<Country> getAll(); // getAll

    public Country getById(String id); // getById

    public List<Country> searchByCharacter(String key); // searchByCharacter

    public Country save(Country country) throws SQLIntegrityConstraintViolationException; // create and update

    public boolean delete(Country country); // delete

}
