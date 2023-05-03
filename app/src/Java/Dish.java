public class Dish{
    private int dishId;
    private String dishName;
    private double money;

    public Dish(int dishId, String dishName, double money){
        this.dishId=dishId;
        this.dishName=dishName;
        this.money=money;
    }
    public int getDishId(){
        return this.dishId;
    }
    public String getDishName(){
        return this.dishName;
    }
    public double getDishWorth(){
        return money;
    }
}