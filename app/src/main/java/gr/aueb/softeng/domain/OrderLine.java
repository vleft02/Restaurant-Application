package gr.aueb.softeng.domain;

public class OrderLine {
    private int quantity;
    private final Dish dish;
    public OrderLine(int quantity, Dish dish){
        this.quantity=quantity;
        this.dish=dish;
    }
    //Getters
    public int getQuantity(){
        return this.quantity;
    }
    public Dish getDish(){
        return this.dish;
    }
    public double getSubTotalCost(){
        return quantity*dish.getDishWorth() ;
    }
    @Override
    public boolean equals(Object o){ // Overrriding the equals method so that we can compare two order lines
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderLine)) {
            return false;
        }
        OrderLine c = (OrderLine)o;
        return this.dish.getDishName().equals(c.getDish().getDishName());
    }
    @Override
    public int hashCode() {
        return this.dish.getDishName().hashCode();
    }
    public void setQuantity(int quantity) throws IllegalArgumentException{
        if (quantity > 0) {
            this.quantity = quantity;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    public void IncrementOrderLineQuantity(){
        this.quantity+=1;
    }
    public void decrementOrderLineQuantity() throws ZeroDishQuantityException{
        if(this.quantity==1){ // we cannot have an order line with dish quantity zero, we throw our custom made Exception
            throw new ZeroDishQuantityException();
        }
        else {
           this.quantity-= 1;
        }
    }

}
