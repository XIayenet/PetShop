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
     
  public void insertUser(String username, String password, String role)  {
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
    
   public UserEntity getUserById(int userid) {
    String sql = "SELECT * FROM [User] WHERE UserID = ?";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, userid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {

        UserEntity u =
                new UserEntity(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3));
        
        return u;
        
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
    
    public void updateUser(int userId, String username, String password, String role)  {
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
    
    public void deleteUser(int userId)  {
        String sql = "DELETE FROM [User] WHERE UserID = ?";
        try  {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
     public UserEntity getUserByEmail(String email) {
    String sql = " SELECT * FROM [User] WHERE [email] = ? ";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, email);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {

        UserEntity u =
            new UserEntity(
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));
                
        return u;
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
      public void insertUserWithEmailPassword(String email, String password) {
    String sql =
        "  Insert into [User]( [email],[password])\n" + "                       values (?,?)  ";

    try {

      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, password);
      ps.executeUpdate();
    } catch (SQLException e) {
    }
  }

  public static void main(String[] args)  {
      UserDao udao = new UserDao();
    //        udao.insertUser("Canh1111111", "1232222", "Customer");
    System.out.println(udao.getUserById(2));

    //    udao.deleteUser(1);
    //    udao.updateUser(2, "Canh123", "123", "Custormer");
    udao.updateUser(2, "Canh2710", "789456", "Customer");
  }
  
}
