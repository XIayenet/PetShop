/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 * @author admin
 */
public class SaleEntity {
    private String CustomerID;
    private String ProductID;
    private int ServiceID;
    private int SaleDate;
    private int Quantity;
    private int TotalPrice;

    public SaleEntity() {
    }

    public SaleEntity(String CustomerID, String ProductID, int ServiceID, int SaleDate, int Quantity, int TotalPrice) {
        this.CustomerID = CustomerID;
        this.ProductID = ProductID;
        this.ServiceID = ServiceID;
        this.SaleDate = SaleDate;
        this.Quantity = Quantity;
        this.TotalPrice = TotalPrice;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getProductID() {
        return ProductID;
    }

    public int getServiceID() {
        return ServiceID;
    }

    public int getSaleDate() {
        return SaleDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public void setSaleDate(int SaleDate) {
        this.SaleDate = SaleDate;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    @Override
    public String toString() {
        return "Sale{" + "CustomerID=" + CustomerID + ", ProductID=" + ProductID + ", ServiceID=" + ServiceID + ", SaleDate=" + SaleDate + ", Quantity=" + Quantity + ", TotalPrice=" + TotalPrice + '}';
    }
    
    
}
