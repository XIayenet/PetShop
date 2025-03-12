package dao;

import entity.SaleEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDAO extends DBContext {

    public SaleDAO() {}

    public void insertSale(String customerID, String productID, int serviceID, int saleDate, int quantity, int totalPrice) {
        String sql = "INSERT INTO Sale (CustomerID, ProductID, ServiceID, SaleDate, Quantity, TotalPrice) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerID);
            ps.setString(2, productID);
            ps.setInt(3, serviceID);
            ps.setInt(4, saleDate);
            ps.setInt(5, quantity);
            ps.setInt(6, totalPrice);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public SaleEntity getSaleById(int id) {
        String sql = "SELECT * FROM Sale WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SaleEntity(
                        rs.getString("CustomerID"),
                        rs.getString("ProductID"),
                        rs.getInt("ServiceID"),
                        rs.getInt("SaleDate"),
                        rs.getInt("Quantity"),
                        rs.getInt("TotalPrice")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<SaleEntity> getAllSales() {
        ArrayList<SaleEntity> sales = new ArrayList<>();
        String sql = "SELECT * FROM Sale";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sales.add(new SaleEntity(
                        rs.getString("CustomerID"),
                        rs.getString("ProductID"),
                        rs.getInt("ServiceID"),
                        rs.getInt("SaleDate"),
                        rs.getInt("Quantity"),
                        rs.getInt("TotalPrice")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sales;
    }

    public void updateSale(int id, String customerID, String productID, int serviceID, int saleDate, int quantity, int totalPrice) {
        String sql = "UPDATE Sale SET CustomerID = ?, ProductID = ?, ServiceID = ?, SaleDate = ?, Quantity = ?, TotalPrice = ? WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerID);
            ps.setString(2, productID);
            ps.setInt(3, serviceID);
            ps.setInt(4, saleDate);
            ps.setInt(5, quantity);
            ps.setInt(6, totalPrice);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteSale(int id) {
        String sql = "DELETE FROM Sale WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
