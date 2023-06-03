package gr.aueb.softeng.domain;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Chef extends User {
    private String iban, tin; //tin=afm
    private ArrayList<Order> orders ; // ArrayList with the orders that the Chef is working on currently

    public Chef(String username, String name, String surname, String telephone, String email, String password, int Id, String iban, String tin)
    {
        super(username, name, surname, telephone, email, password, Id); // calling the constructor of the father class(User)
        this.iban=iban;
        this.tin=tin;
        this.orders = new ArrayList<Order>();
    }
    public void changePersonalDetails(String username, String name, String surname, String telephone, String email,String tin){
        super.changePersonalDetails(username, name, surname, telephone, email); // calling the father class method
        this.tin=tin;
    }
    // Getters
    public String getIban() {
        return iban;
    }
    public String getTin() {
        return tin;
    }
    public ArrayList<Order> getOrders(){
            return orders;
    }

    public void changeIban(String iban){
        this.iban=iban;
    }
    public void addOrder(Order order){//called by the controller when a new order is being added in the restaurant
        orders.add(order);
    }
    public boolean removeOrder(Order order){ // called by the controller when the order state is "COMPLETED"
        return orders.remove(order); // returns True iff the order is in the list, else returns False
    }

}

