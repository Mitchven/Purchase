
package purchase;

public class Medicine {
    private int iD;
    private String brandName;
    private String genericName;
    private String description;
    private double price;
    private int quantity;

    public Medicine() {
    }

    public Medicine(int iD,String genericName,String brandName, String description, double price,int quantity) {
        this.iD = iD;
        this.genericName = genericName;
        this.brandName = brandName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    @Override
    public String toString() {
        return  "genericName=" + genericName + ", brandName=" + brandName + ", description=" + description + ", price=" + price +",quantity=" + quantity ;
    }
    
    
}
