/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.sql.ResultSet;
import entity.UserEntity;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends DBContext  {
    
     public UserDao() {}
     
  public void createUser(String username, String password, String role) throws SQLException {
        String sql = "INSERT INTO [User] (Username, Pass, Role) VALUES (?, ?, ?)";
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.executeUpdate();
        }catch (SQLException e) {
    }
    }
    
    public ResultSet getUser(int userId) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE UserID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, userId);
        return ps.executeQuery();
    }
    
    public void updateUser(int userId, String username, String password, String role) throws SQLException {
        String sql = "UPDATE [User] SET Username = ?, Pass = ?, Role = ? WHERE UserID = ?";
        try 
             
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setInt(4, userId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
            
    }
    
    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM [User] WHERE UserID = ?";
        try  {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }


}
