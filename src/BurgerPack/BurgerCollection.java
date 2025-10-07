package BurgerPack;

public class BurgerCollection {
    private Burger[] customerArray=new Burger[]{
        new Burger("B0001","wasuda1","0123456789",10,0),
        new Burger("B0002","wasuda2","0987654321",8,1),
        new Burger("B0003","wasuda3","0918273645",15,2),
        new Burger("B0004","wasuda1","0123456789",15,2),
        new Burger("B0005","wasuda2","0987654321",5,1),
        new Burger("B0006","wasuda2","0987654321",10,0)
    };
    
    public void extendsCustomerArray() {
        Burger[] tempCustomerArray = new Burger[customerArray.length + 1];
        for (int i = 0; i < customerArray.length; i++) {
            tempCustomerArray[i] = customerArray[i];
        }
        customerArray = tempCustomerArray;
    }
    
    public Burger[] toArray() {
        Burger[] tempCustomerArray = new Burger[customerArray.length];
        for (int i = 0; i < customerArray.length; i++) {
            tempCustomerArray[i] = customerArray[i];
        }
        return tempCustomerArray;
    }
    
    public boolean addCustomer(Burger customer) {
        extendsCustomerArray();
        customerArray[customerArray.length - 1] = customer;
        return true;
    }

    public Burger searchCustomer(String cusId) {
        for (Burger customer : customerArray) {
            if (customer.getCusId().equalsIgnoreCase(cusId)) {
                return customer;
            }
        }
        return null;
    }

    public int indexOf(Burger customer) {
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getCusId().equalsIgnoreCase(customer.getCusId())) {
                return i;
            }
        }
        return -1;
    }
    
    public Burger searchOrder(String oderId){
        for (Burger customer : customerArray) {
            if (customer.getOrderId().equalsIgnoreCase(oderId)) {
                return customer;
            }
        }
        return null;
    }
    
    public boolean searchDuplicateCustomers(Burger[] customerArr,String cusId){
        for (int i = 0; i < customerArr.length; i++) {
            if (customerArr[i].getCusId().equalsIgnoreCase(cusId)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean updateCustomer(Burger customer){
        int index=indexOf(customer);
        customerArray[index]=customer;
        return true;
    }

    public Burger[] getAllCustomers(){
        return customerArray;
    }
    
    public String genOrderId() {
        if (customerArray.length <= 0) {
            return "B0001";
        }
        String lastOrderId = customerArray[customerArray.length - 1].getOrderId();
        int lastOrderIdNumber = Integer.parseInt(lastOrderId.substring(1));
        return String.format("B%04d", lastOrderIdNumber + 1);
    }

    public boolean isDuplicateCustomer(String cusId) {
        for (int i = 0; i < customerArray.length; i++) {
            if (cusId.equals(customerArray[i].getCusId())) {
                return true;
            }
        }
        return false;
    }
}