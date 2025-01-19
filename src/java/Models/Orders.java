/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author wongun78
 */
public class Orders {
   private int orderId;
   private int promotionId;
   private int customerId;
   private String orderDate;
   private String shippedDate;
   private String shippedAddress;
   private String shippedCountry;
   private String shippedCity;
   private String shippedPostalCode;

    public Orders() {
    }

    public Orders(int orderId, int promotionId, int customerId, String orderDate, String shippedDate, String shippedAddress, String shippedCountry, String shippedCity, String shippedPostalCode) {
        this.orderId = orderId;
        this.promotionId = promotionId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shippedAddress = shippedAddress;
        this.shippedCountry = shippedCountry;
        this.shippedCity = shippedCity;
        this.shippedPostalCode = shippedPostalCode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShippedAddress() {
        return shippedAddress;
    }

    public void setShippedAddress(String shippedAddress) {
        this.shippedAddress = shippedAddress;
    }

    public String getShippedCountry() {
        return shippedCountry;
    }

    public void setShippedCountry(String shippedCountry) {
        this.shippedCountry = shippedCountry;
    }

    public String getShippedCity() {
        return shippedCity;
    }

    public void setShippedCity(String shippedCity) {
        this.shippedCity = shippedCity;
    }

    public String getShippedPostalCode() {
        return shippedPostalCode;
    }

    public void setShippedPostalCode(String shippedPostalCode) {
        this.shippedPostalCode = shippedPostalCode;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", promotionId=" + promotionId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", shippedDate=" + shippedDate + ", shippedAddress=" + shippedAddress + ", shippedCountry=" + shippedCountry + ", shippedCity=" + shippedCity + ", shippedPostalCode=" + shippedPostalCode + '}';
    }
   
}
