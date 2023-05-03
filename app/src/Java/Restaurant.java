import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String telephone;
    private int totalTables=0;
    private Address address;
    private Owner owner;
    private ArrayList<Chef> chefs;
    private ArrayList<Dish> dishes;
    private ArrayList<Order> orders;

    public Restaurant(String name, String telephone, int totalTables, Address address, Owner owner){
        this.owner = owner;
        this.name=name;
        this.telephone=telephone;
        this.totalTables=totalTables;
        this.address=address;
        this.chefs= new ArrayList<Chef>();
        this.dishes= new ArrayList<Dish>();
        this.orders = new ArrayList<Order>();

    }
    public String getRestaurantName(){
        return this.name;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public int getTotalTables(){
        return this.totalTables;
    }
    public Address getAddress(){
        return this.address;
    }
    public ArrayList<Chef> getChefs(){
        return this.chefs;
    }
    public void addChef(Chef chef){
        this.chefs.add(chef);
    }
    public ArrayList<Dish> getDishes(){
        return this.dishes;
    }
    public void addDish(Dish dish){
        this.dishes.add(dish);
    }
    public void addOrder(Order order)
    {
        this.orders.add(order);
    }
}
