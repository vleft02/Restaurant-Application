package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class OrderTest {
Order order1, order2;
Customer customer;
OrderLine orderLine1 ,orderLine2;
    @Before
    public void setUp() throws Exception {
        customer= new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        orderLine1 = new OrderLine(2,new Dish(1,"food1",10.0));
        orderLine2 = new OrderLine(1,new Dish(2,"food2",7.0));
        order1 = new Order(10, LocalDateTime.of(2023,10,10,9,30,10),1,customer);
        order2 = new Order(13,LocalDateTime.of(2023,10,10,9,30,10),2,customer);
        order2.addOrderLine(orderLine2);
        customer.topUp(100);
        order2.setStateCompleted();//No money removed since order2 is empty;
    }

    @After
    public void tearDown(){
        this.order1=null;
        this.order2=null;
        this.customer=null;
        this.orderLine1=null;
        this.orderLine2=null;
    }

    @Test
    public void getOrderLines() {
        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);
        assertEquals(order1.getOrderLines().get(0), orderLine1);
        assertEquals(order1.getOrderLines().get(1), orderLine2);

    }
    @Test
    public void getId() {
        assertEquals(order1.getId(),1);
    }
    @Test
    public void getCustomer() {
        assertSame(order1.getCustomer(),customer);
    }

    @Test
    public void getOrderState() {
        assertEquals(order1.getOrderState(), Order.State.RECEIVED);
        assertEquals(order2.getOrderState(), Order.State.COMPLETED);
    }

    @Test
    public void getTableNumber() {
        assertEquals(order1.getTableNumber(), 10);
    }

    @Test
    public void getTotalCost() {
        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);
        assertEquals(order1.getTotalCost(), 27.0,0.00);
    }
     @Test
    public void getTotalCostEmpty() {
        assertEquals(order1.getTotalCost(),0.00,0.00);
    }

    @Test
    public void getDate() {
        LocalDateTime date = LocalDateTime.of(2023,10,10,9,30,10);
        assertEquals(order1.getDate(),date);////////////
    }
    @Test
    public void isPaidFalse() {
        assertFalse(order1.isPaid());
    }
     @Test
    public void isPaidTrue() {
        assertTrue(order2.isPaid());
    }

    @Test
    public void setStateCompleted() {
        order1.addOrderLine(orderLine1);
        order1.setStateCompleted();
        assertEquals(order1.getOrderState(),Order.State.COMPLETED);
    }

    @Test
    public void setStateCancelledCorrect() {
        order1.setStateCancelled();
        assertEquals(order1.getOrderState(), Order.State.CANCELLED);
    }


    @Test
    public void addOrderLine() {
        order1.addOrderLine(orderLine1);
        assertTrue(order1.getOrderLines().contains(orderLine1));
    }
    @Test
    public void addExistingOrderLine() {
        order1.addOrderLine(orderLine1);
        assertTrue(order1.getOrderLines().contains(orderLine1));
        order1.addOrderLine(orderLine1);
        assertTrue(order1.getOrderLines().contains(orderLine1));
        assertEquals(order1.getOrderLines().size(), 1);
        assertEquals(order1.getOrderLines().get(0).getQuantity(), 4);
    }

    @Test
    public void removeExistingOrderLine() {
        order1.addOrderLine(orderLine1);
        order1.removeOrderLine(orderLine1);
        assertFalse(order1.getOrderLines().contains(orderLine1));
    }
}