/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CustomerEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CustomerDAO extends DBContext {

    public CustomerDAO() {
    }

    public void insertCustomer(int userID, String firstName, String lastName, int phoneNumber, String email, String address) {
        String sql = "INSERT INTO Customer (UserID, FirstName, LastName, PhoneNumber, Email, Address) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setString(2, firstName.trim());
            ps.setString(3, lastName.trim());
            ps.setInt(4, phoneNumber);
            ps.setString(5, email.trim());
            ps.setString(6, address.trim());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public CustomerEntity getCustomerByCustomerId(int customerId) {
        String sql = "SELECT * FROM Customer WHERE CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new CustomerEntity(
                        rs.getInt("UserID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        Integer.parseInt(rs.getString("PhoneNumber")),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public CustomerEntity getCustomerByUserId(int userId) {
        String sql = "SELECT * FROM Customer WHERE UserID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new CustomerEntity(
                        rs.getInt("UserID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        Integer.parseInt(rs.getString("PhoneNumber")),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<CustomerEntity> getAllCustomers() {
        ArrayList<CustomerEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CustomerEntity(
                        rs.getInt("UserID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        Integer.parseInt(rs.getString("PhoneNumber")),
                        rs.getString("Email"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateCustomer(int customerId, String firstName, String lastName, int phoneNumber, String email, String address) {
        String sql = "UPDATE Customer SET FirstName = ?, LastName = ?, PhoneNumber = ?, Email = ?, Address = ? WHERE CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName.trim());
            ps.setString(2, lastName.trim());
            ps.setString(3, String.valueOf(phoneNumber));
            ps.setString(4, email.trim());
            ps.setString(5, address.trim());
            ps.setInt(6, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

  public static void main(String[] args) {
      CustomerDAO cdao = new CustomerDAO();
    cdao.insertCustomer(2, "Canh", "Nguyen",966784820, "hp", "vietnam");
  }
}
   
