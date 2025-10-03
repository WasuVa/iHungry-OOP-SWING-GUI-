package CustomerPack;

public class CustomerCollection {
    private Customer[] customerArray=new Customer[]{
        new Customer("B0001","wasuda1","0123456789",10,0),
        new Customer("B0002","wasuda2","0987654321",8,1),
        new Customer("B0003","wasuda3","0918273645",15,2),
        new Customer("B0004","wasuda1","0123456789",15,2),
        new Customer("B0005","wasuda2","0987654321",5,1),
        new Customer("B0006","wasuda2","0987654321",10,0)
    };
    
    public void extendsCustomerArray() {
        Customer[] tempCustomerArray = new Customer[customerArray.length + 1];
        for (int i = 0; i < customerArray.length; i++) {
            tempCustomerArray[i] = customerArray[i];
        }
        customerArray = tempCustomerArray;
    }
    
    public Customer[] toArray() {
        Customer[] tempCustomerArray = new Customer[customerArray.length];
        for (int i = 0; i < customerArray.length; i++) {
            tempCustomerArray[i] = customerArray[i];
        }
        return tempCustomerArray;
    }
    
    public boolean addCustomer(Customer customer) {
        extendsCustomerArray();
        customerArray[customerArray.length - 1] = customer;
        return true;
    }

    public Customer searchCustomer(String cusId) {
        for (Customer customer : customerArray) {
            if (customer.getCusId().equalsIgnoreCase(cusId)) {
                return customer;
            }
        }
        return null;
    }

    public int indexOf(Customer customer) {
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getCusId().equalsIgnoreCase(customer.getCusId())) {
                return i;
            }
        }
        return -1;
    }
    
    public Customer searchOrder(String oderId){
        for (Customer customer : customerArray) {
            if (customer.getOrderId().equalsIgnoreCase(oderId)) {
                return customer;
            }
        }
        return null;
    }
    
    public boolean searchDuplicateCustomers(Customer[] customerArr,String cusId){
        for (int i = 0; i < customerArr.length; i++) {
            if (customerArr[i].getCusId().equalsIgnoreCase(cusId)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean updateCustomer(Customer customer){
        int index=indexOf(customer);
        customerArray[index]=customer;
        return true;
    }

    public Customer[] getAllCustomers(){
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