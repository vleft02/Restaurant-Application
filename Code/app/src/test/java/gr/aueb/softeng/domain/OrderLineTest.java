package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderLineTest {
OrderLine orderLine1;
OrderLine orderLine2;
OrderLine orderLine3;
    @Before
    public void setUp(){
        orderLine1 = new OrderLine(2,new Dish(1,"food1",10.0));
        orderLine2 = new OrderLine(1,new Dish(2,"food2",7.0));
        orderLine3 = new OrderLine(10,new Dish(3,"food1",10.0));
    }

    @After
    public void tearDown(){
        orderLine1 = null;
        orderLine2 = null;
        orderLine3 = null;
    }
    @Test
    public void getQuantity() {
        assertEquals(orderLine1.getQuantity(),2);
    }


    @Test
    public void getDish() {
        assertEquals(orderLine1.getDish().getDishName(),"food1");
    }

    @Test
    public void getSubTotalCost() {
        assertEquals(orderLine1.getSubTotalCost(),20.0,0.00);
    }

    @Test
    public void notEqualOrderLines() {
        assertNotEquals(orderLine1, orderLine2);
        assertNotEquals(orderLine1.hashCode(), orderLine2.hashCode());
    }
    @Test
    public void equalOrderLines() {

        assertEquals(orderLine1, orderLine3);
        assertEquals(orderLine1.hashCode(), orderLine3.hashCode());
    }

    @Test
    public void setQuantity() {
        orderLine1.setQuantity(4);
        assertEquals(orderLine1.getQuantity(),4);
    }

    @Test
    public void IncrementOrderLineQuantity() {
        orderLine1.IncrementOrderLineQuantity();
        assertEquals(orderLine1.getQuantity(),3);
    }

    @Test
    public void decrementOrderLineQuantity(){
        orderLine1.decrementOrderLineQuantity();
        assertEquals(orderLine1.getQuantity(),1);
    }

}