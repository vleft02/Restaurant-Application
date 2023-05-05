import java.util.ArrayList;

public class Chef extends User {
    private final String iban, tin; //tin=afm

    private ArrayList<Order> orders ;

    public Chef(String username, String name, String surname, String telephone, String email, String password, int Id, String iban, String tin)
    {
        super(username, name, surname, telephone, email, password, Id);
        this.iban=iban;
        this.tin=tin;
        this.orders = new ArrayList<Order>();
    }

    // Getters
    public String getIban() {
        return iban;
    }

    public String getTin() {
        return tin;
    }

    public void addOrder(Order order){//called by the controller when a new order is being added in the restaurant
        orders.add(order);
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
}

