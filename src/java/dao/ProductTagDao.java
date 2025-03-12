/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ProductTagEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductTagDao extends DBContext {

    public ProductTagDao() {
    }

    public void insert(ProductTagEntity productTag) {
        String sql = "INSERT INTO ProductTag (ProductID, TagID) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productTag.getProductID());
            ps.setInt(2, productTag.getTagID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    public void delete(int productId, int tagId) {
        String sql = "DELETE FROM ProductTag WHERE ProductID = ? AND TagID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setInt(2, tagId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    public List<ProductTagEntity> getByProductId(int productId) {
        List<ProductTagEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductTag WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductTagEntity(
                        rs.getInt("ProductID"),
                        rs.getInt("TagID")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Get by ProductID failed: " + e.getMessage());
        }
        return list;
    }

    public List<ProductTagEntity> getByTagId(int tagId) {
        List<ProductTagEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductTag WHERE TagID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, tagId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductTagEntity(
                        rs.getInt("ProductID"),
                        rs.getInt("TagID")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Get by TagID failed: " + e.getMessage());
        }
        return list;
    }

    public List<ProductTagEntity> getAll() {
        List<ProductTagEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductTag";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductTagEntity(
                        rs.getInt("ProductID"),
                        rs.getInt("TagID")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Get all failed: " + e.getMessage());
        }
        return list;
    }

    public boolean exists(int productId, int tagId) {
        String sql = "SELECT COUNT(*) FROM ProductTag WHERE ProductID = ? AND TagID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setInt(2, tagId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Existence check failed: " + e.getMessage());
        }
        return false;
    }

   
   
}