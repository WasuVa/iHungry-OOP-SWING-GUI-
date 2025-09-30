
package main;

public class Customer {
    private String oderId;
    private String name;
    private String cusId;
    private int bgrQty;
    private int orderStatus;
    
    
    
    public Customer(){}
    
    public Customer(String oderId,String name,String cusId,int bgrQty,int orderStatus){
        this.oderId=oderId;
        this.name=name;
        this.cusId=cusId;
        this.bgrQty=bgrQty;
        this.orderStatus=orderStatus;
    }

    /**
     * @return the oderId
     */
    public String getOrderId() {
        return oderId;
    }

    /**
     * @param oderId the oderId to set
     */
    public void setOderId(String oderId) {
        this.oderId = oderId;
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
