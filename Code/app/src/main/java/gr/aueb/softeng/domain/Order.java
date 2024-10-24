package gr.aueb.softeng.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Order implements Serializable {

    public enum State {RECEIVED, COMPLETED, CANCELLED} // Enum for the number of states an order might have
    private final int tableNumber;

    private int id;
    private final LocalDateTime date;
    private boolean isPaid = false; // is True when the order has been paid
    private final Customer customer; // final because no matter what the customer of the order cannot change
    private State state = State.RECEIVED;

    private ArrayList<OrderLine> orderLines; // The total number of order Lines that consist the order

    public Order(int tableNumber, LocalDateTime date,int id, Customer customer) {
        this.customer = customer;
        this.tableNumber = tableNumber;
        this.date = date;
        this.id=id;
        this.orderLines = new ArrayList<OrderLine>();
    }
//Getters
    public ArrayList<OrderLine> getOrderLines()  {
            return this.orderLines;
    }
    public Customer getCustomer() {
        return this.customer;
    }

    public int getId() {
        return this.id;
    }

    public State getOrderState() {
        return this.state;
    }
    public int getTableNumber() {
        return this.tableNumber;
    }
    public double getTotalCost() {
        double total=0.0;
        if (!orderLines.isEmpty())
        {
            for(OrderLine o:orderLines){
                total+=o.getSubTotalCost();
            }
        }
        return total;
    }
    public LocalDateTime getDate() {return this.date;}
    public boolean isPaid() {return this.isPaid;}

    public void setOrderLines(ArrayList<OrderLine> modifiedOrderLines) {
        this.orderLines = modifiedOrderLines;
    }

    //Setters for the state of the order
    public void setStateCompleted(){//this is being called by the chef in the controller class
        this.state=State.COMPLETED;
        this.isPaid=true;
        this.customer.transaction(getTotalCost()); // subtract the customers money , at this stage it has already been made sure that the customer has enough money
    }
    public void setStateCancelled(){

        if (this.state != State.COMPLETED){
            this.state = State.CANCELLED;
        }
    }
    public void addOrderLine(OrderLine orderLine) {
        if (orderLines.contains(orderLine)) {//if we already have an orderLine for the same dish, we get the object and add the quantities
            OrderLine o = orderLines.get(orderLines.indexOf(orderLine));
            o.setQuantity(o.getQuantity() + orderLine.getQuantity());
        }
        else {//else it is not on the list, and we add it
            this.orderLines.add(orderLine);
        }
    }
    public void removeOrderLine(OrderLine orderLine) throws NoSuchElementException {
        if (!orderLines.isEmpty()) {
            orderLines.remove(orderLine);
        }
    }


}

