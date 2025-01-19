/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author wongun78
 */
public class OrderItems {
    private int orderItemID;
    private int orderID;
    private int productOptionID;
    private int quantity;
    private int price;

    public OrderItems() {
    }

    public OrderItems(int orderItemID, int orderID, int productOptionID, int quantity, int price) {
        this.orderItemID = orderItemID;
        this.orderID = orderID;
        this.productOptionID = productOptionID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductOptionID() {
        return productOptionID;
    }

    public void setProductOptionID(int productOptionID) {
        this.productOptionID = productOptionID;
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
