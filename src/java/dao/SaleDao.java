/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;
import java.sql.ResultSet;
import entity.SaleEntity;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.lang.model.util.Types;
/**
 * @author admin
 */
public class SaleDao extends DBContext  {
    public void createSale(int customerId, Integer productId, Integer serviceId, int quantity, double totalPrice) {
        String sql = "INSERT INTO Sale (CustomerID, ProductID, ServiceID, SaleDate, Quantity, TotalPrice) VALUES (?, ?, ?, GETDATE(), ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            if (productId != null) {
                ps.setInt(2, productId);
            } else {
                ps.setNull(2, java.sql.Types.NULL);
            }
//            if (serviceId != null) {
                ps.setInt(3, serviceId);
            } else {
                ps.setNull(3, java.sql.Types.NULL);
            }
            ps.setInt(4, quantity);
            ps.setDouble(5, totalPrice);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) {
        SaleDao sdao = new SaleDao();
    sdao.createSale(1, 5, 7, 5, 15000);
  }
}
