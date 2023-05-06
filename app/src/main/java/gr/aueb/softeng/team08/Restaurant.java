package gr.aueb.softeng.team08;

import java.util.ArrayList;

public class Restaurant {
    private final String name, telephone;
    private int totalTables = 0;
    private final Address address;
    private ArrayList<Chef> chefs;
    private ArrayList<Dish> dishes;
    private ArrayList<Order> orders;
    private int counter=0;

    public Restaurant(String name, String telephone, int totalTables, Address address) {
        this.name = name;
        this.telephone = telephone;
        this.totalTables = totalTables;
        this.address = address;
        this.chefs = new ArrayList<Chef>();
        this.dishes = new ArrayList<Dish>();
        this.orders = new ArrayList<Order>();

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

    public ArrayList<Chef> getChefs() {
        return this.chefs;
    }

    public void changeTotalTables(int total) {
        this.totalTables = total;
    }
    public void addChef(Chef chef) {
        this.chefs.add(chef);
    }

    public ArrayList<Dish> getDishes() {
        return this.dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public boolean addOrder(Order order) { // do we need to give the chef as a parameter, or we see who is free and give it to him???? like a round robin !!! SOSS
        if (order.getCustomer().getBalance() >= order.getTotalCost()) { // SOS WATCH THIS
            Chef chef = chefs.get(counter);
            if(counter==chefs.size()-1){
                counter=0;
            }
            else {
                counter++;
            }
            order.setOrderChef(chef);
            this.orders.add(order); // goes to the restaurant
            chef.addOrder(order); // goes to the chef

            return true;
        }
        return false;
    }
}
