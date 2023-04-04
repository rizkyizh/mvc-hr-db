package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import daos.idaos.ICountryDao;
import exeption.*;
import models.Country;
import tools.DBConnection;
import tools.Utility;

public class CountryDAO implements ICountryDao {

    private Connection connection;

    public CountryDAO() {
        try {
            this.connection = new DBConnection().getConnection();
        } catch (databaseConnectionExeption e) {
            Utility.clearScreen();
            Utility.displayMessage(e.getMessage());
        }
    }

    @Override
    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM COUNTRY";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion_id(resultSet.getInt(3));
                countries.add(country);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    @Override
    public Country getById(String id) {
        String query = "SELECT * FROM COUNTRY WHERE id= ?";
        Country country = new Country();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            country.setId(resultSet.getString(1));
            country.setName(resultSet.getString(2));
            country.setRegion_id(resultSet.getInt(3));

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            country = null;
        }
        return country;
    }

    @Override
    public List<Country> searchByCharacter(String key) {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM COUNTRY WHERE LOWER(name) LIKE LOWER(?) ORDER BY id";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion_id(resultSet.getInt(3));
                countries.add(country);
            }

            if (countries.isEmpty() || countries == null) {
                throw new NullPointerException("Data is not found!");
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            throw new NullPointerException("Data is not found!");
        }

        return countries;
    }

    @Override
    public Country save(Country c) throws SQLIntegrityConstraintViolationException  {
        Country country = this.getById(c.getId());
        String query = (country == null) ? "INSERT INTO COUNTRY (name, region, id) VALUES(?, ?, ?)"
                : "UPDATE COUNTRY SET name= ?, region= ? WHERE id= ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getName());
            preparedStatement.setInt(2, c.getRegion_id());
            preparedStatement.setString(3, c.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            country = null;
            throw new SQLIntegrityConstraintViolationException("Cannot add or update a child row: a foreign key constraint fails\nPlease enter region id that already registered!");
        }
        return country;
    }

    @Override
    public boolean delete(Country country) {
        boolean success = false;
        String query = "DELETE FROM COUNTRY WHERE id= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getId());
            int rowsUpdate = preparedStatement.executeUpdate();
            
            if (rowsUpdate > 0) {
                success = true;
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
    
}
