import java.util.ArrayList;

public class Chef extends User {
    private String iban, tin; //tin=afm

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

    // Setters
//    public void setIban(String Iban) {
//        this.iban = Iban;
//    }

//    public void setTin(String Tin) {
//        this.tin = Tin;
//    }
    public void addOrder(Order order){
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}

