package Models;

public class Products {

    private int productID;
    private int categoryID;
    private String productName;
    private String description;

    public Products() {
    }

    public Products(int productID, int categoryID, String productName, String description) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Products{" + "productID=" + productID + ", categoryID=" + categoryID + ", productName=" + productName + ", description=" + description + '}';
    }

    

    
}
