/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author wongun78
 */
public class OrderDetails {
    private int orderDetailId;
    private int orderId;
    private int ProductOptionId;
    private int quantity;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailId, int orderId, int ProductOptionId, int quantity) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.ProductOptionId = ProductOptionId;
        this.quantity = quantity;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductOptionId() {
        return ProductOptionId;
    }

    public void setProductOptionId(int ProductOptionId) {
        this.ProductOptionId = ProductOptionId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", ProductOptionId=" + ProductOptionId + ", quantity=" + quantity + '}';
    }
    
    
}
