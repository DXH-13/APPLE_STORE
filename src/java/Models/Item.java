package Models;

public class Item {

    private ProductOptions productOption;
    private int quantity;
    private int price;

    public Item() {
    }

    public Item(ProductOptions productOption, int quantity, int price) {
        this.productOption = productOption;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductOptions getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOptions productOption) {
        this.productOption = productOption;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
