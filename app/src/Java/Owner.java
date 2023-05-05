import java.util.ArrayList;

public class Owner extends User {
    private final String iban, tin; //tin=afm
    private double income;
    private ArrayList<Restaurant> restaurants;

    public Owner(String username, String name, String surname, String telephone, String email, String password, int Id, String iban, String tin)
    {
        super(username, name, surname, telephone, email, password, Id);
        this.iban=iban;
        this.tin=tin;
        this.restaurants= new ArrayList<Restaurant>();
    }
    // Getters
    public String getIban() {
        return iban;
    }
    public String getTin() {
        return tin;
    }
    public ArrayList<Restaurant> getRestaurants(){
        return this.getRestaurants();
    }
    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }
    public void addMoney(int money){
        this.income+=money;
    }
    public double getIncome(){
        return this.income;
    }
    
}
