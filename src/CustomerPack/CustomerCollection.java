package CustomerPack;

public class CustomerCollection {
    private static Customer[] customerArray = new Customer[0];

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
    
    public boolean updateCustomer(Customer customer){
        int index=indexOf(customer);
        customerArray[index]=customer;
        return true;
    }

    public static Customer[] getAllCustomers(){
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