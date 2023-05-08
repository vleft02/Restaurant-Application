package gr.aueb.softeng.team08;

import java.util.ArrayList;

public class Owner extends User {
    private String iban, tin; //tin=afm
    private double income=0.0;
    private ArrayList<Restaurant> restaurants;

    public Owner(String username, String name, String surname, String telephone, String email, String password, int Id, String iban, String tin)
    {
        super(username, name, surname, telephone, email, password, Id);
        this.iban=iban;
        this.tin=tin;
        this.restaurants= new ArrayList<Restaurant>();
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
    public ArrayList<Restaurant> getRestaurants(){
        return this.getRestaurants();
    }
    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }
    public void addMoney(double money){
        this.income+=money;
    }
    public double getIncome(){
        return this.income;
    }
    
}
