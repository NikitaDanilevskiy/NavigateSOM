package entities;

import java.util.Date;

public class Order {
    private String id;
    private String orderDate;
    private String customerId;
    private String customerName;
    private int zipCode;
    private String trade;
    private String ndc;
    private int quantity;
    private float lineTotal;

//    public Order(int id, String orderDate, String customerId, String customerName,
//                 int zipCode, String trade, String ndc,int quantity, float lineTotal){
//        this.id = id;
//        this.orderDate = orderDate;
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.zipCode = zipCode;
//        this.trade = trade;
//        this.ndc = ndc;
//        this.quantity = quantity;
//        this.lineTotal = lineTotal;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(float lineTotal) {
        this.lineTotal = lineTotal;
    }

    public String toString(){
        return (this.id+", "+this.orderDate+", "+this.customerId+", "+this.customerName+", "
                +this.zipCode+", "+this.trade+", "+this.ndc+", "+this.quantity+", "+this.lineTotal).toString();
    }
}
