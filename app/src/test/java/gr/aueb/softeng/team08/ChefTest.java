package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class ChefTest {
Chef chef;
    @Before
    public void setUp() throws Exception {
        chef = new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
    }

    @After
    public void tearDown() throws Exception {
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
    public void addOrder() {
        Order order = new Order(10,"13:32:45",new Date(2023-5-6),new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322"));
        chef.addOrder(order);
        assertEquals(chef.getOrders().size(),1);
    }

    @Test
    public void getOrders() {
        chef.addOrder( new Order(10,"13:32:45",new Date(2023-5-6),new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322")));
        chef.addOrder( new Order(13,"14:45:34",new Date(2023-5-6),new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322")));
        assertEquals(chef.getOrders().get(0).getTableNumber(),10);
        assertEquals(chef.getOrders().get(1).getTableNumber(),13 );

    }
    @Test
    public void removeOrders() {
        Order order = new Order(10,"13:32:45",new Date(2023-5-6),new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322"));
        chef.addOrder(order);
        chef.removeOrder(order);
        assertEquals(chef.getOrders().size(),0);
    }

}