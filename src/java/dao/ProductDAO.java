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

    public void createProduct(String ProductName, String Description, double Price, int StockQuantity, String imageUrl) {
        String sql = "INSERT INTO Product (ProductName, Description, Price, StockQuantity, Image) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ProductName);
            ps.setString(2, Description);
            ps.setDouble(3, Price);
            ps.setInt(4, StockQuantity);
            ps.setString(5, imageUrl);
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
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getBigDecimal(4),
                                rs.getInt(5),
                                rs.getString(6));

                return p;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (
                PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                products.add(new ProductEntity(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Description"),
                        rs.getBigDecimal("Price"),
                        rs.getInt("StockQuantity"),
                        rs.getString("Image")
                ));
            }
        } catch (SQLException e) {

        }
        return products;
    }

    public void updateProduct(int productId, String name, String description, BigDecimal price, String image, int stock) {
        String sql = "UPDATE Product SET ProductName = ?, Description = ?, Price = ?, StockQuantity = ?, Image = ? WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setBigDecimal(3, price);
            ps.setInt(4, stock);
            ps.setString(5, image);
            ps.setInt(6, productId);
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

    public List<ProductEntity> searchProducts(String[] selectedTags, String searchTerm) {
        List<ProductEntity> products = new ArrayList<>();
        TagDao tagDAO = new TagDao();
        List<Integer> expandedTagIDs = new ArrayList<>();

        if (selectedTags != null && selectedTags.length > 0) {
            expandedTagIDs = tagDAO.getExpandedTagIDs(selectedTags);
        }

        StringBuilder query = new StringBuilder("SELECT DISTINCT p.* FROM Product p");
        List<String> params = new ArrayList<>();
        List<String> conditions = new ArrayList<>();

        if (!expandedTagIDs.isEmpty()) {
            query.append(" JOIN ProductTag pt ON p.ProductID = pt.ProductID");
            query.append(" JOIN Tag t ON pt.TagID = t.TagID");
            String placeholders = String.join(",", new String[expandedTagIDs.size()]).replace("\0", "?");
            conditions.add("t.TagID IN (" + placeholders + ")");
            for (Integer tagID : expandedTagIDs) {
                params.add(String.valueOf(tagID));
            }
        }

        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            conditions.add("(p.ProductName LIKE ? OR p.Description LIKE ?)");
            params.add("%" + searchTerm.trim() + "%");
            params.add("%" + searchTerm.trim() + "%");
        }

        if (!conditions.isEmpty()) {
            query.append(" WHERE ").append(String.join(" AND ", conditions));
        }

        try {
            PreparedStatement ps = connection.prepareStatement(query.toString());
            for (int i = 0; i < params.size(); i++) {
                ps.setString(i + 1, params.get(i));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductEntity product = new ProductEntity(
                    rs.getInt("ProductID"),
                    rs.getString("ProductName"),
                    rs.getString("Description"),
                    rs.getBigDecimal("Price"),
                    rs.getInt("StockQuantity"),
                    rs.getString("Image")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }
    
    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        //    pdao.createProduct("cho", "love", 15000, 5);

        //    System.out.println(pdao.getProduct(1));
        //    pdao.updateProduct(1, "cat", "like", 20000, 4);
//        pdao.deleteProduct(2);
        System.out.println(pdao.getAllProducts());
    }
}
