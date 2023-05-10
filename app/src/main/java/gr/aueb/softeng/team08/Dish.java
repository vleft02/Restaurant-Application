package gr.aueb.softeng.team08;

public class Dish{
    private final String dishName;
    private final double price;
    public Dish(String dishName, double price){
        this.dishName=dishName;
        this.price=price;
    }
//Getters
    public String getDishName(){
        return this.dishName;
    }
    public double getDishWorth(){
        return price;
    }
}