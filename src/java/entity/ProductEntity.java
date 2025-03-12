/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 * @author admin
 */
public class ProductEntity {
    private String ProductName;
    private String Description;
    private int Price;
    private int StockQuantity;

    public ProductEntity() {
    }

    public ProductEntity(String ProductName, String Description, int Price, int StockQuantity) {
        this.ProductName = ProductName;
        this.Description = Description;
        this.Price = Price;
        this.StockQuantity = StockQuantity;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public int getPrice() {
        return Price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setStockQuantity(int StockQuantity) {
        this.StockQuantity = StockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductName=" + ProductName + ", Description=" + Description + ", Price=" + Price + ", StockQuantity=" + StockQuantity + '}';
    }
    
    
    
    
}
