package dao;

import entity.SaleEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDao extends DBContext {

    public SaleDao() {}

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

    public SaleEntity getSaleByCustomerID(String customerID) {
        String sql = "SELECT * FROM Sale WHERE CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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

    public void updateSale(String customerID, String productID, int serviceID, int saleDate, int quantity, int totalPrice) {
        String sql = "UPDATE Sale SET ProductID = ?, ServiceID = ?, SaleDate = ?, Quantity = ?, TotalPrice = ? WHERE CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, productID);
            ps.setInt(2, serviceID);
            ps.setInt(3, saleDate);
            ps.setInt(4, quantity);
            ps.setInt(5, totalPrice);
            ps.setString(6, customerID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

  public static void main(String[] args) {
      SaleDao sdao = new SaleDao();
    sdao.insertSale("5", "10", 2, 4, 10, 200000);
  }
}
