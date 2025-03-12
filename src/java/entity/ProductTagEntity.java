/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 * @author admin
 */
public class ProductTagEntity {
        private int ProductID;
        private int TagID;

    public ProductTagEntity() {
    }

    public ProductTagEntity(int ProductID, int TagID) {
        this.ProductID = ProductID;
        this.TagID = TagID;
    }

    public int getProductID() {
        return ProductID;
    }

    public int getTagID() {
        return TagID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setTagID(int TagID) {
        this.TagID = TagID;
    }

    @Override
    public String toString() {
        return "ProductTagEntity{" + "ProductID=" + ProductID + ", TagID=" + TagID + '}';
    }
        
}
