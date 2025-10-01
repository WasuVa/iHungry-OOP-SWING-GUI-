package CustomerPack;

public class Customer {
    private String orderId;
    private String name;
    private String cusId;
    private int bgrQty;
    private int orderStatus;

    public static final int PREPARING = 0;
    public static final int CANCELED = 1; 
    public static final int DELIVERED = 2;

    public Customer() {
    }

    public Customer(String orderId, String name, String cusId, int bgrQty, int orderStatus) {
        this.orderId = orderId;
        this.name = name;
        this.cusId = cusId;
        this.bgrQty = bgrQty;
        this.orderStatus = orderStatus;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cusId
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * @param cusId the cusId to set
     */
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    /**
     * @return the bgrQty
     */
    public int getBgrQty() {
        return bgrQty;
    }

    /**
     * @param bgrQty the bgrQty to set
     */
    public void setBgrQty(int bgrQty) {
        this.bgrQty = bgrQty;
    }

    /**
     * @return the orderStatus
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}