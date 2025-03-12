/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import entity.ProductEntity;
import entity.UserEntity;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class ProductDAO extends DBContext {

    public void createProduct(String ProductName, String Description, double Price, int StockQuantity) {
        String sql = "INSERT INTO Product (ProductName, Description, Price, StockQuantity) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ProductName);
            ps.setString(2, Description);
            ps.setDouble(3, Price);
            ps.setInt(4, StockQuantity);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public ProductEntity getProduct(int ProductID) {
        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ProductID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ProductEntity p
                        = new ProductEntity(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getBigDecimal(3),
                                rs.getInt(4));

                return p;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ProductEntity> getAllProducts() throws SQLException {
        List<ProductEntity> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (
                PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                products.add(new ProductEntity(
                        rs.getString("ProductName"),
                        rs.getString("Description"),
                        rs.getBigDecimal("Price"),
                        rs.getInt("StockQuantity")
                ));
            }
        }
        return products;
    }

    public void updateProduct(int productId, String name, String description, BigDecimal price, int stock) {
        String sql = "UPDATE Product SET ProductName = ?, Description = ?, Price = ?, StockQuantity = ? WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setBigDecimal(3, price);
            ps.setInt(4, stock);
            ps.setInt(5, productId);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void deleteProduct(int productId) {
        String sql = "DELETE FROM Product WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        //    pdao.createProduct("cho", "love", 15000, 5);

        //    System.out.println(pdao.getProduct(1));
        //    pdao.updateProduct(1, "cat", "like", 20000, 4);
        pdao.deleteProduct(2);
    }
}
