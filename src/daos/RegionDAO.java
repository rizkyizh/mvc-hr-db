package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.idaos.IRegionDao;
import models.Region;

public class RegionDAO implements IRegionDao {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                region.setCount(resultSet.getInt(3));

                // Region region2 = new Region(
                // resultSet.getInt(1),
                // resultSet.getString(2),
                // resultSet.getInt(3)
                // );

                regions.add(region);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public boolean create(Region region) {
        boolean result = false;
        String query = "INSERT INTO REGION(id, name, count) VALUES(?, ?, ?)"; // is Parameterized Query

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, region.getId());
            preparedStatement.setString(2, region.getName());
            preparedStatement.setInt(3, region.getCount());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Message = " + e.getMessage());
        }

        return result;
    }

    @Override
    public boolean update(Region region) {
        boolean success = false;
        String query = "UPDATE REGION SET ";

        if (region.getName() != null && region.getCount() != null) {
            query += "name= ?, count= ? WHERE id= ?";
        } else if (region.getName() != null) {
            query += "name= ? WHERE id= ?";
        } else if (region.getCount() != null) {
            query += "count= ? WHERE id= ?";
        } else {
            throw new IllegalArgumentException("At least one column to update must be specified.");
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int indexParams = 1;
            if (region.getName() != null) {
                preparedStatement.setString(indexParams++, region.getName());
            }
            if (region.getCount() != null) {
                preparedStatement.setInt(indexParams++, region.getCount());
            }
            preparedStatement.setInt(indexParams++, region.getId());

            int rowsUpdate = preparedStatement.executeUpdate();

            if (rowsUpdate > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    @Override
    public boolean delete(Region region) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }

}
