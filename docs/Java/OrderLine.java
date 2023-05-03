public class OrderLine {
    private int quantity;
    private Dish dish;
    public OrderLine(int quantity, Dish dish){
        this.quantity=quantity;
        this.dish=dish;
    }
    // prtosthiki afairesi
    public int getQuantity(){
        return this.quantity;
    }
    public Dish getDish(){
        return this.dish;
    }
    public double getSubTotalCost(){
        return quantity*dish.getDishWorth() ;
    }
}
