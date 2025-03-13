/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 * @author admin
 */
public class UserEntity {
    private String Email;
    private String Pass;
    private String Role;
    private String State;
    

    public UserEntity() {
    }

    public UserEntity(String email, String pass, String role, String state) {
        this.Email = email;
        this.Pass = pass;
        this.Role = role;
        this.State = state;
    }

    public String getEmail() {
        return Email;
    }

    public String getPass() {
        return Pass;
    }

    public String getRole() {
        return Role;
    }

    public String getState() {
        return State;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPass(String pass) {
        this.Pass = pass;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public void setState(String state) {
        this.State = state;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "email=" + Email + ", pass=" + Pass + ", role=" + Role + ", state=" + State + '}';
    }

   
   
    
}
