package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class OrderTest {
Order order1, order2;
Customer customer;
OrderLine orderLine1 ,orderLine2;
    @Before
    public void setUp() throws Exception {
        customer= new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        orderLine1 = new OrderLine(2,new Dish("food1",10.0));
        orderLine2 = new OrderLine(1,new Dish("food2",7.0));
        order1 = new Order(10,"13:32:45",new Date(2023-5-6),customer);
        order2 = new Order(13,"14:45:34",new Date(2023-5-6),customer);
        order2.addOrderLine(orderLine2);
        customer.topUp(100);
        order2.setStateCompleted();//No money removed since order2 is empty;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getOrderLines() {
        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);
        assertTrue(order1.getOrderLines().get(0).equals(orderLine1));
        assertTrue(order1.getOrderLines().get(1).equals(orderLine2));

    }
    @Test
    public void getOrderLinesEmpty() {
        assertTrue(order1.getOrderLines().isEmpty());
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
    public void getTime() {
    assertEquals(order1.getTime(),"13:32:45");
    }


    @Test
    public void getDate() {
        //NA DOUME POS DOULEVEI H DATE ISOS XREIAZETAI ALITHINO DATA TYPE ME STUB
        // assertEquals(order1.getDate(),2023-5-6);
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
    public void setStatePreparing() {
        order1.setStatePreparing();
        assertEquals(order1.getOrderState(), Order.State.PREPARING);
    }

    @Test
    public void setStateCompleted() {
        order1.addOrderLine(orderLine1);
        order1.setStateCompleted();
        assertEquals(order1.getOrderState(),Order.State.COMPLETED);
        assertEquals(customer.getBalance(),73.0,0.00);
        //chef prepei na vgei
    }

    @Test
    public void setOrderChef() {
    }//Maybe delete later

    @Test
    public void setStateCancelledCorrect() {
        order1.setStateCancelled();
        assertEquals(order1.getOrderState(), Order.State.CANCELLED);
    }
        @Test
    public void setStateCancelledInvalid() {
        assertThrows(IllegalStateException.class, ()-> order2.setStateCancelled());
    }


    @Test
    public void addOrderLine() {
        OrderLine orderLine1 = new OrderLine(2,new Dish("food1",10.0));
        order1.addOrderLine(orderLine1);
        assertEquals(order1.getOrderLines().size(), 1);
    }
    @Test
    public void addExistingOrderLine() {
        order1.addOrderLine(new OrderLine(2,new Dish("food1",10.0)));
        assertEquals(order1.getOrderLines().size(), 1);
        order1.addOrderLine(new OrderLine(2,new Dish("food1",10.0)));
        assertEquals(order1.getOrderLines().size(), 1);
        assertEquals(order1.getOrderLines().get(0).getQuantity(), 4);
    }

    @Test
    public void removeExistingOrderLine() {
        order1.addOrderLine(new OrderLine(2,new Dish("food1",10.0)));
        order1.addOrderLine(new OrderLine(1,new Dish("food2",7.0)));
        order1.removeOrderLine(order1.getOrderLines().get(0));
        assertEquals(order1.getOrderLines().size(), 1);
        assertEquals(order1.getOrderLines().get(0).getDish().getDishName(), "food2");
    }
}