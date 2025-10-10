package main;

public class Burger {
    public static final int bgrPrice = 500;
    public static final int CANCEL = 2;
    public static final int PROCESSING = 0;
    public static final int DELIVERED = 1;
    
    private String orderId;
    private String customerId;
    private String customerName;
    private int orderQty;
    private int orderStatus;
    
    public Burger(){}

    public Burger(String orderId, String customerId, String customerName, int orderQty, int orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderQty = orderQty;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
