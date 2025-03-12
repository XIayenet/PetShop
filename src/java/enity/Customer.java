/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package enity;

/**
 * @author admin
 */
public class Customer {
    private int userID;
    private String firstName;
    private String LastName;
    private int PhoneNumber;
    private String Email;
    private String Address;

    public Customer() {
    }

    public Customer(int userID, String firstName, String LastName, int PhoneNumber, String Email, String Address) {
        this.userID = userID;
        this.firstName = firstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Address = Address;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "Customer{" + "userID=" + userID + ", firstName=" + firstName + ", LastName=" + LastName + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email + ", Address=" + Address + '}';
    }
    
}
