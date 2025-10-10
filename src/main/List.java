package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class List {

    private Burger[] list;
    private int nextIndex;
    private double loadFact;

    public List() {
    }

    public List(int initSize, double loadFact) {
        list = new Burger[initSize];
        this.nextIndex = 0;
        this.loadFact = loadFact;
    }

    public String generateOrderId() {
        if (nextIndex == 0) {
            return "B0001";
        }
        String lastOrderId = list[nextIndex - 1].getOrderId();
        int lastOrderIdNum = Integer.parseInt(lastOrderId.substring(1));
        return String.format("B%04d", lastOrderIdNum + 1);
    }

    public Burger[] toArray() {
        Burger[] temp = new Burger[nextIndex];
        for (int i = 0; i < nextIndex; i++) {
            temp[i] = list[i];
        }
        return temp;
    }

    public String getStatusNameById(int statusId) {
        return statusId == Burger.CANCEL ? "Cancelled"
                : statusId == Burger.PROCESSING ? "Processing"
                        : statusId == Burger.DELIVERED ? "Delivered" : "";

    }

    public boolean isEmpty() {
        return nextIndex == 0;
    }

    private boolean isFull() {
        return nextIndex >= list.length;
    }

    public boolean isDuplicateCustomer(String id) {
        for (int i = 0; i < nextIndex; i++) {
            if (id.equals(list[i].getCustomerId())) {
                return true;
            }
        }
        return false;
    }

    public String getDuplicateCustomerName(String id) {
        for (int i = 0; i < nextIndex; i++) {
            if (id.equals(list[i].getCustomerId())) {
                return list[i].getCustomerName();
            }
        }
        return "";
    }

    public boolean searchDuplicateCustomers(Burger[] burgerArr, String customerId) {
        for (int i = 0; i < burgerArr.length; i++) {
            if (burgerArr[i].getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidPhoneNumber(String id) {
        if (id.length() != 10) {
            return false;
        }
        if (id.charAt(0) != '0') {
            return false;
        }
        for (int i = 0; i < id.length(); i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public void addBurger(Burger burger) {
        if (isFull()) {
            extendsArray();
        }
        list[nextIndex++] = burger;
    }

    public Burger searchOrder(String orderId) {
        for (Burger burgers : list) {
            if (burgers != null && orderId.equalsIgnoreCase(burgers.getOrderId())) {
                return burgers;
            }
        }
        return null;
    }

    public boolean placeOrder(Burger burger) {
        addBurger(burger);
        return true;
    }

    private void extendsArray() {
        Burger[] temp = new Burger[(int) (nextIndex * (1 + loadFact))];
        for (int i = 0; i < nextIndex; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    public void loadDataFromFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line!=null) {
                String[] rowData = line.split(",");
                Burger burger = new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), Integer.parseInt(rowData[4]));
                addBurger(burger);
                line = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
