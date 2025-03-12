/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;/**
 * @author admin
 */
public class UserDao extends DBContext  {
  public void createUser(String username, String password, String role) throws SQLException {
        String sql = "INSERT INTO [User] (Username, Pass, Role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = DBConnection.getConnection();
            PreparedStatement stmt = ps.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.executeUpdate();
        }
    }
    
    public ResultSet getUser(int userId) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE UserID = ?";
        PreparedStatement conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        return stmt.executeQuery();
    }
    
    public void updateUser(int userId, String username, String password, String role) throws SQLException {
        String sql = "UPDATE [User] SET Username = ?, Pass = ?, Role = ? WHERE UserID = ?";
        try (PreparedStatement conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.setInt(4, userId);
            stmt.executeUpdate();
        }
    }
    
    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM [User] WHERE UserID = ?";
        try (PreparedStatement conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }


}
