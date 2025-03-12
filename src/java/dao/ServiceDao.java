package dao;

import entity.ServiceEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ServiceDAO for managing services in the database.
 */
public class ServiceDao extends DBContext {

    public ServiceDao() {}

    // Insert a new service
    public void insertService(String serviceName, String description, int price) {
        String sql = "INSERT INTO [Service] (ServiceName, Description, Price) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, serviceName.trim());
            ps.setString(2, description.trim());
            ps.setInt(3, price);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Get a service by ID
    public ServiceEntity getServiceByID(int serviceID) {
        String sql = "SELECT * FROM [Service] WHERE ServiceID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, serviceID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ServiceEntity(
                    rs.getString("ServiceName"),
                    rs.getString("Description"),
                    rs.getInt("Price")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // Get all services
    public ArrayList<ServiceEntity> getAllServices() {
        ArrayList<ServiceEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM [Service]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ServiceEntity(
                    rs.getString("ServiceName"),
                    rs.getString("Description"),
                    rs.getInt("Price")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Update a service by ID
    public void updateService(int serviceID, String serviceName, String description, int price) {
        String sql = "UPDATE [Service] SET ServiceName = ?, Description = ?, Price = ? WHERE ServiceID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, serviceName.trim());
            ps.setString(2, description.trim());
            ps.setInt(3, price);
            ps.setInt(4, serviceID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Delete a service by ID
    public void deleteService(int serviceID) {
        String sql = "DELETE FROM [Service] WHERE ServiceID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, serviceID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

  public static void main(String[] args) {
      ServiceDao sdao = new ServiceDao();
    //    sdao.deleteService(2);
//    System.out.println(sdao.getServiceByID(3));
    sdao.updateService(3, "yeu", "cac", 11000);

//    sdao.insertService("bo", "thich", 150000);
  }
}
