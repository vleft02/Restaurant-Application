package gr.aueb.softeng.team08;

public class Dish{
    private final String dishName;
    private final double money;

    public Dish(String dishName, double money){
        this.dishName=dishName;
        this.money=money;
    }

    public String getDishName(){
        return this.dishName;
    }
    public double getDishWorth(){
        return money;
    }
}