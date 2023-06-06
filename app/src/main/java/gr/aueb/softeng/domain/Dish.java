package gr.aueb.softeng.domain;

import java.io.Serializable;

public class Dish implements Serializable {
    private final int id;
    private final String dishName;
    private final double price;
    public Dish(int id, String dishName, double price){
        this.id = id;
        this.dishName=dishName;
        this.price=price;
    }
//Getters
    public int getId()
    {
        return this.id;
    }
    public String getDishName(){
        return this.dishName;
    }
    public double getDishWorth(){
        return price;
    }
}