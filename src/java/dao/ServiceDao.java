package dao;

import entity.ServiceEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao extends DBContext {
    public boolean addService(ServiceEntity service) {
        String sql = "INSERT INTO services (ServiceName, Description, Price) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, service.getServiceName());
            ps.setString(2, service.getDescription());
            ps.setInt(3, service.getPrice());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ServiceEntity> getAllServices() {
        List<ServiceEntity> services = new ArrayList<>();
        String sql = "SELECT * FROM services";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ServiceEntity service = new ServiceEntity(
                        rs.getString("ServiceName"),
                        rs.getString("Description"),
                        rs.getInt("Price")
                );
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public ServiceEntity getServiceByName(String name) {
        String sql = "SELECT * FROM services WHERE ServiceName = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ServiceEntity(
                            rs.getString("ServiceName"),
                            rs.getString("Description"),
                            rs.getInt("Price")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateService(ServiceEntity service) {
        String sql = "UPDATE services SET Description = ?, Price = ? WHERE ServiceName = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, service.getDescription());
            ps.setInt(2, service.getPrice());
            ps.setString(3, service.getServiceName());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteService(String name) {
        String sql = "DELETE FROM services WHERE ServiceName = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

  public static void main(String[] args) {

      ServiceDao sdao = new ServiceDao();
  }
}
