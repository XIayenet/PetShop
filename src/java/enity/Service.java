/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package enity;

/**
 * @author admin
 */
public class Service {
    private String ServiceName;
    private String Description;
    private int Price;

    public Service() {
    }

    public Service(String ServiceName, String Description, int Price) {
        this.ServiceName = ServiceName;
        this.Description = Description;
        this.Price = Price;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public String getDescription() {
        return Description;
    }

    public int getPrice() {
        return Price;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Service{" + "ServiceName=" + ServiceName + ", Description=" + Description + ", Price=" + Price + '}';
    }
    
    
    
    
}
