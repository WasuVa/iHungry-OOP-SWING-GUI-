package BurgerPack;

public class BurgerArray{
    private static int bgrPrice=500;
    private String orderId;
    private String customerName;
    private String customerId;
    private int orderQty;
    private int orderStatus;

    private static int PREPARING = 0;
    private static int CANCELED = 1; 
    private static int DELIVERED = 2;
    
    public BurgerArray(){
    }
    
    public BurgerArray(String oderId,String customerId,String customerName,int orderQty){
        this.orderId=oderId;
        this.customerId=customerId;
        this.customerName=customerName;
        this.orderQty=orderQty;
        this.orderStatus=0;
    }

    /**
     * @return the bgrPrice
     */
    public static int getBgrPrice() {
        return bgrPrice;
    }

    /**
     * @param aBgrPrice the bgrPrice to set
     */
    public static void setBgrPrice(int aBgrPrice) {
        bgrPrice = aBgrPrice;
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
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the orderQty
     */
    public int getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
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

    /**
     * @return the PREPARING
     */
    public static int getPREPARING() {
        return PREPARING;
    }

    /**
     * @param aPREPARING the PREPARING to set
     */
    public static void setPREPARING(int aPREPARING) {
        PREPARING = aPREPARING;
    }

    /**
     * @return the CANCELED
     */
    public static int getCANCELED() {
        return CANCELED;
    }

    /**
     * @param aCANCELED the CANCELED to set
     */
    public static void setCANCELED(int aCANCELED) {
        CANCELED = aCANCELED;
    }

    /**
     * @return the DELIVERED
     */
    public static int getDELIVERED() {
        return DELIVERED;
    }

    /**
     * @param aDELIVERED the DELIVERED to set
     */
    public static void setDELIVERED(int aDELIVERED) {
        DELIVERED = aDELIVERED;
    }
}

class List{
    private BurgerArray[] burgerArray;
    private int nextIndex;
    private final double loadFact;
    private final int initSize;
    
    public List(int initSize, double loadFact){
        burgerArray=new BurgerArray[initSize];
        nextIndex=0;
        this.loadFact=loadFact;
        this.initSize=initSize;  
    }
    
    public boolean isEmpty(){
        return nextIndex==0;
    }
    private boolean isFull(){
        return nextIndex>=burgerArray.length;
    }
    public void add(BurgerArray burger){ //Insertion order
        addLast(burger);
    }
    public boolean addFirst(BurgerArray burger){
        return add(nextIndex,burger);
    }
    public boolean addLast(BurgerArray burger){
        return add(0, burger);
    }
    public boolean add(int index, BurgerArray burger){
        if(index>=0 && index<=nextIndex){
            if(isFull()){
                extendsArray();
            }
            for (int i = nextIndex-1; i >=index; i--) {
                burgerArray[i+1]=burgerArray[i];
            }
            burgerArray[index]=burger;
            nextIndex++;
            return true;
        }
        return false;
    }
    private void extendsArray(){
        BurgerArray[] tempBurgerArray=new BurgerArray[(int)(burgerArray.length*(1+loadFact))];
        for (int i = 0; i < burgerArray.length; i++) {
            tempBurgerArray[i]=burgerArray[i];
        }
        burgerArray=tempBurgerArray;
    }
    public boolean removeFirst(){
        return remove(0);
    }
    public boolean removeLast(){
        return remove(nextIndex-1);
    }
    public boolean remove(int index){
        if(index>=0 && index<nextIndex){
            for (int i = index; i < nextIndex-1; i++) {
                burgerArray[i]=burgerArray[i+1];
            }
            nextIndex--;
        }
        return false;
    }
    public int indexOf(Burger burger){
        for (int i = 0; i < nextIndex; i++) {
            if(burgerArray[i].getOrderId().equals(burger.getOrderId())){
                return i;
            }
        }
        return -1;
    }
    public BurgerArray[] toArray(){
        BurgerArray[] tempBurgerArray=new BurgerArray[nextIndex];
        for(int i=0; i<nextIndex; i++){
            tempBurgerArray[i]=burgerArray[i];
        }
        return tempBurgerArray;
    }
    
}

