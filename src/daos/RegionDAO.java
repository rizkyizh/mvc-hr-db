package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.idaos.IRegionDao;
import exeption.databaseConnectionExeption;
import models.Region;
import tools.DBConnection;
import tools.Utility;

public class RegionDAO implements IRegionDao {

    private Connection connection;

    public RegionDAO() {
        try {
            this.connection = new DBConnection().getConnection();
        } catch (databaseConnectionExeption e) {
            Utility.clearScreen();
            Utility.displayMessage(e.getMessage());
        }
    }

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                region.setCount(resultSet.getInt(3));

                regions.add(region);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return regions;

    }

    @Override
    public boolean delete(Region region) {
        boolean success = false;
        String query = "DELETE FROM REGION WHERE id= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, region.getId());
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

    @Override
    public Region getById(Integer id) {
        String query = "SELECT * FROM REGION WHERE id= ?";
        Region region = new Region();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            region.setId(resultSet.getInt(1));
            region.setName(resultSet.getString(2));
            region.setCount(resultSet.getInt(3));

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            region = null;
        }
        return region;
    }

    @Override
    public List<Region> searchByCharacter(String key) {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION WHERE LOWER(name) LIKE LOWER(?) ORDER BY id";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                region.setCount(resultSet.getInt(3));
                regions.add(region);
            }

            if (regions.isEmpty() || regions == null) {
                throw new NullPointerException("Data is not found!");
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            throw new NullPointerException("Data is not found!");
        }

        return regions;
    }

    @Override
    public Region save(Region r) {
        Region region = this.getById(r.getId());
        System.out.println(region);
        String query = (region == null) ? "INSERT INTO REGION (name, count, id) VALUES(?, ?, ?)"
                : "UPDATE REGION SET name= ?, count= ? WHERE id= ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getName());
            preparedStatement.setInt(2, r.getCount());
            preparedStatement.setInt(3, r.getId());

            int rowsSave = preparedStatement.executeUpdate();

            if (rowsSave > 0) {
                region = r;
            }

            preparedStatement.close();

        } catch (SQLException e) {
            region = null;
        }
        return region;
    }

}
