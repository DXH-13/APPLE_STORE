package Models;

public class ProductOptions {

    private int productOptionID;
    private int productID;
    private int colorID;
    private int storageID;
    private double price;
    private int promotionID;
    private String photo1;
    private String photo2;
    Products p;
    Color cl;
    Storage s;

    public ProductOptions(int productOptionID, int productID, int colorID, int storageID, double price, int promotionID, String photo1, String photo2) {
        this.productOptionID = productOptionID;
        this.productID = productID;
        this.colorID = colorID;
        this.storageID = storageID;
        this.price = price;
        this.promotionID = promotionID;
        this.photo1 = photo1;
        this.photo2 = photo2;
    }
    
    

    public ProductOptions() {
    }

    public ProductOptions(int productOptionID, int productID, int colorID, int storageID, double price, int promotionID, String photo1, String photo2, Products p, Color cl, Storage s) {
        this.productOptionID = productOptionID;
        this.productID = productID;
        this.colorID = colorID;
        this.storageID = storageID;
        this.price = price;
        this.promotionID = promotionID;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.p = p;
        this.cl = cl;
        this.s = s;
    }

    public int getProductOptionID() {
        return productOptionID;
    }

    public void setProductOptionID(int productOptionID) {
        this.productOptionID = productOptionID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getStorageID() {
        return storageID;
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public Products getP() {
        return p;
    }

    public void setP(Products p) {
        this.p = p;
    }

    public Color getCl() {
        return cl;
    }

    public void setCl(Color cl) {
        this.cl = cl;
    }

    public Storage getS() {
        return s;
    }

    public void setS(Storage s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "ProductOptions{" + "productOptionID=" + productOptionID + ", productID=" + productID + ", colorID=" + colorID + ", storageID=" + storageID + ", price=" + price + ", promotionID=" + promotionID + ", photo1=" + photo1 + ", photo2=" + photo2 + ", p=" + p + ", cl=" + cl + ", s=" + s + '}';
    }

}
