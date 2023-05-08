package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class ChefTest {
Chef chef;
Customer customer;
    @Before
    public void setUp() throws Exception {
        chef = new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
        customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");

    }
    @After
    public void tearDown(){
        chef=null;
        customer=null;
    }

    @Test
    public void getIban() {
        assertEquals(chef.getIban(),"10230910290194");
    }

    @Test
    public void getTin() {
        assertEquals(chef.getTin(),"14323234");
    }

    @Test
    public void getOrders() {
        Order order1=  new Order(10,"13:32:45",new Date(2023-5-6),this.customer);
        Order order2=  new Order(13,"14:45:34",new Date(2023-5-6),this.customer);
        //Order order3= new Order(9, "15:00:01",new Date(2023-10-10),this.customer);
        chef.addOrder(order1);
        chef.addOrder(order2);
        assertTrue(chef.getOrders().contains(order1));
        assertTrue(chef.getOrders().contains(order2));
        //assertFalse(chef.getOrders().contains(order3));

    }
    @Test
    public void addOrder() {
        Order order = new Order(10,"13:32:45",new Date(2023-5-6),this.customer);
        chef.addOrder(order);
        //assertEquals(chef.getOrders().size(),1);
        assertTrue(chef.getOrders().contains(order));
    }

    @Test
    public void removeOrders() {
        Order order = new Order(10,"13:32:45",new Date(2023-5-6),this.customer);
        chef.addOrder(order);
        chef.removeOrder(order);
        assertFalse(chef.getOrders().contains(order));
    }

}