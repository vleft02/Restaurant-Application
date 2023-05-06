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
    @Override
    public boolean equals(Object o){
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

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
    public void IncrementOrderLineQuantity(){
        this.quantity+=1;
    }
    public void DecrementOrderLineQuantity() throws ZeroDishQuantityException{
        if(this.quantity==1){
            throw new ZeroDishQuantityException();
        }
        else {
           this.quantity-= 1;
        }
    }
}
