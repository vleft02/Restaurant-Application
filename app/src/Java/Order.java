import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Order {
    public enum State {RECEIVED, PREPARING, CANCELLED, READY, COMPLETED}
    private int tableNumber;
    private double totalCost;
    private Chef chef;
    private final String time;
    private final Date date; // or string
    private boolean paid = false;
    //from correlation
    private Customer customer;
    private State state = State.RECEIVED;

    private HashSet<OrderLine> orderLines;

    public Order(int tableNumber, String time, Date date, Customer customer) {
        this.customer = customer;
        this.tableNumber = tableNumber;
        this.time = time;
        this.date = date;
        this.orderLines = new HashSet<OrderLine>();
    }

    //se periptosi pou prostethei kainoyrio order Line
    //an syxonevontai ta orderlines otan exoun idia proionta opos ekane sto frontistirio
    public void addOrderLine(OrderLine orderLine) {
        if (orderLines.contains(orderLine)){
            for (OrderLine order : orderLines){
                if(order.equals(orderLine)){
                    order.setQuantity(order.getQuantity()+orderLine.getQuantity());
                    totalCost+=orderLine.getSubTotalCost();
                    break;
                }
            }
        }/// kapou isws diagrapsoyme tin orderLine
        else{
            this.orderLines.add(orderLine);
            totalCost += orderLine.getSubTotalCost();
        }
    }

    public HashSet<OrderLine> getOrderLines() {
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

    public double getTotalCost() {
        return this.totalCost;
    }

    public String getTime() {
        return this.time;
    }

    public Date getDate() {
        return this.date;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void setOrderState(State state) {
        this.state = state;
    }

    public void setTableNumber(int tableNum) {
        this.tableNumber = tableNum;
    }

    public void updateState()
    {
        if (this.state == State.RECEIVED)
        {
            this.state = State.PREPARING;

        }
        else if (this.state == State.PREPARING)
        {
            this.state = State.READY;
        }
        else if (this.state == State.READY)
        {
           // boolean customer.transaction();
            this.state = State.COMPLETED;
            chef.getOrders().remove(this);
        }

    }

    public void setCancelled()
    {
        this.state = State.CANCELLED;
        chef.getOrders().remove(this);
    }
    //    public void setTotalCost(double total){
//        this.totalCost=total;
//    }
//    public void setTime(String time){
//        this.time=time;
//    }
///    public void setDate(Date date){
//        this.date=date;
//    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public boolean sufficientBalance(){
        return (this.customer.getBalance() >= this.totalCost);
    }

}

