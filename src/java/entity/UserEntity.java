/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 * @author admin
 */
public class UserEntity {
    private String email;
    private String pass;
    private String role;
    

    public UserEntity() {
    }

    public UserEntity(String email, String pass, String role) {
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "email=" + email + ", pass=" + pass + ", role=" + role + '}';
    }

   
    
}
