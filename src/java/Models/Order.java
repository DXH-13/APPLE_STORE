package Models;

public class Order {

    private int orderID;
    private int accountID;
    private String orderDate;
    private int totalPrice;
    Accounts acc;

    public Order() {
    }

    public Order(int orderID, int accountID, String orderDate, int totalPrice) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public Order(int orderID, int accountID, String orderDate, int totalPrice, Accounts acc) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.acc = acc;
    }

//    public Order(String username, int soLuongDonHang) {
//        this.acc = new Accounts(username);
//        this.totalPrice = soLuongDonHang;
//    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Accounts getAcc() {
        return acc;
    }

    public void setAcc(Accounts acc) {
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", accountID=" + accountID + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", acc=" + acc + '}';
    }

//    public String getUsername() {
//        return acc.username;
//    }

}
