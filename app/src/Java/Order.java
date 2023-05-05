import java.sql.Date;
import java.util.ArrayList;

public class Order {
    public enum State {RECEIVED, PREPARING, COMPLETED, CANCELLED, }
    private final int tableNumber;
    private double totalCost;
    private Chef chef;
    private final String time;
    private final Date date; // or string
    private boolean isPaid = false;
    //from correlation
    private final Customer customer;
    private State state = State.RECEIVED;

    private ArrayList<OrderLine> orderLines;

    public Order(int tableNumber,String time, Date date, Customer customer) {
        this.customer = customer;
        this.tableNumber = tableNumber;
        this.time = time;
        this.date = date;
        this.orderLines = new ArrayList<OrderLine>();
    }

    public ArrayList<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public State getOrderState() {
        return this.state;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public double getTotalCost() {return this.totalCost;}

    public String getTime() {return this.time;}

    public Date getDate() {return this.date;}

    public boolean isPaid() {return this.isPaid;}
    public void setStatePreparing(){this.state=State.PREPARING;}//this is being called by the chef
    public void setStateCompleted(){//this is being called by the chef
        this.state=State.COMPLETED;
        this.isPaid=true;/////////
        this.customer.transaction(totalCost); // subtract the customers money
        chef.getOrders().remove(this);
    }
    public void setOrderChef(Chef chef){
        this.chef=chef;
    }
    public void setStateCancelled()//this is being called by the chef
    {
        this.state = State.CANCELLED;
        chef.getOrders().remove(this);
    }
    public void addOrderLine(OrderLine orderLine) {
        if (orderLines.contains(orderLine)) {//if we already have the orderLine for the same dish, we get the object and add the quantities
            OrderLine o = orderLines.get(orderLines.indexOf(orderLine));
            o.setQuantity(o.getQuantity() + orderLine.getQuantity());
            totalCost += orderLine.getSubTotalCost();
        }
        else {//else it is not in the list, and we add it
            this.orderLines.add(orderLine);
            totalCost += orderLine.getSubTotalCost();
        }
    }
    public void IncrementOrderLineQuantity(OrderLine o){
        o.setQuantity(o.getQuantity()+1);
        totalCost+=o.getDish().getDishWorth();
    }
    public void DecrementOrderLineQuantity(OrderLine o){
        if(o.getQuantity()==1){
            orderLines.remove(o);
            totalCost-=o.getDish().getDishWorth();
        }
        else {
            o.setQuantity(o.getQuantity() - 1);
            totalCost += o.getDish().getDishWorth();
        }
    }

}

