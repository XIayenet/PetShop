/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

import java.math.BigDecimal;

/**
 * @author admin
 */
public class ProductEntity {
    private int ProductID;
    private String ProductName;
    private String Description;
    private BigDecimal Price;
    private int StockQuantity;
    private String Image;

    public ProductEntity() {
    }

    public ProductEntity(int ProductID, String ProductName, String Description, BigDecimal Price, int StockQuantity, String Image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Description = Description;
        this.Price = Price;
        this.StockQuantity = StockQuantity;
        this.Image = Image;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int StockQuantity) {
        this.StockQuantity = StockQuantity;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

   

    @Override
    public String toString() {
        return "ProductEntity{" + "ProductName=" + ProductName + ", Description=" + Description + ", Price=" + Price + ", StockQuantity=" + StockQuantity + ", image=" + Image + '}';
    }

    
    
    
    
}
