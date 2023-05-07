package gr.aueb.softeng.team08;

import java.util.ArrayList;

public class Chef extends User {
    private String iban, tin; //tin=afm , we don't declare them as final because they are being changed if the user initially puts invalid data

    private ArrayList<Order> orders ;

    public Chef(String username, String name, String surname, String telephone, String email, String password, int Id, String iban, String tin)
    {
        super(username, name, surname, telephone, email, password, Id);
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

    public void changeIban(String iban){
        this.iban=iban;
    }
    public void addOrder(Order order){//called by the controller when a new order is being added in the restaurant
        orders.add(order);
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public boolean removeOrder(Order order){ // called by the controller when the order is "COMPLETED"
        return orders.remove(order); // True iff the order is in the list, else False
    }

}

