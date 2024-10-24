package gr.aueb.softeng.domain;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Restaurant {
    private final int id;
    private final String name, telephone;
    private int totalTables = 0;
    private final Address address;
    private ArrayList<Chef> chefs;
    private ArrayList<Dish> dishes;
    private ArrayList<Order> orders;
    private int counter=0; //used later to determine which chef is going to get the new order

    public Restaurant(int id, String name, String telephone, int totalTables, Address address) {
        this.id= id;
        this.name = name;
        this.telephone = telephone;
        this.totalTables = totalTables;
        this.address = address;
        this.chefs= new ArrayList<>();
        this.dishes= new ArrayList<>();
        this.orders= new ArrayList<>();
    }
//Getters
    public int getId()
    {
        return this.id;
    }
    public String getRestaurantName() {
        return this.name;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public int getTotalTables() {
        return this.totalTables;
    }

    public Address getAddress() {
        return this.address;
    }

    public ArrayList<Chef> getChefs(){
            return this.chefs;
    }
    public ArrayList<Order> getOrders(){
            return this.orders;
    }
    public void changeTotalTables(int total) {
        this.totalTables = total;
    }
    public void addChef(Chef chef) {
        this.chefs.add(chef);
    }

    public ArrayList<Dish> getDishes()  {
            return this.dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public boolean addOrder(Order order) { //we give the order to the chefs by round robin
        if (order.getCustomer().getBalance() >= order.getTotalCost()) { //if the customer has the right balance
            if (chefs.isEmpty())
            {
                return false;
            }
            Chef chef = chefs.get(counter); // get the chef that is his turn to get the order
            if(counter==chefs.size()-1){
                counter=0; // if it is the last chef, the next one is the first
            }
            else {
                counter++;
            }
            this.orders.add(order); // goes to the restaurant
            chef.addOrder(order); // goes to the chef
            return true;
        }
        return false;
    }

}
