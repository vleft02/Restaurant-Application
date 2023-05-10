package gr.aueb.softeng.team08;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Owner extends User {
    private String iban, tin; //tin=afm
    private double income=0.0; // the income of the restaurants from the time the owner uses the application
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
    public double getIncome(){
        return this.income;
    }
    public ArrayList<Restaurant> getRestaurants() throws NoSuchElementException {
        if (!restaurants.isEmpty()){
            return this.restaurants;
        }else{
            throw new NoSuchElementException();
        }
    }
    public void changeIban(String iban){
        this.iban=iban;
    }
    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }
    public void addMoney(double money) throws IllegalArgumentException{
        if(money>0){
            this.income+=money;
        }else{
            throw new IllegalArgumentException();
        }
    }
    
}
