package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.NoSuchElementException;

public class RestaurantTest {
    Restaurant rest;
    Address address;

    Dish dish1 = new Dish("psari",10.0); //iws mpei se contstuctor ean thelw stin test na min xrisimopoiei ta alla methods
    Dish dish2 = new Dish("patates",8.00);
    @Before
    public void setUp(){
        address = new Address(2,"kalari",526,"patra");
        rest= new Restaurant("Paprika","6950",10,address);
    }
    @After
    public void tearDown(){
        rest=null;
        address=null;
        dish1=null;
        dish2=null;
    }

    @Test
    public void getRestaurantName() {
        assertEquals(rest.getRestaurantName(),"Paprika");
    }
    @Test
    public void getTelephone() {
        assertEquals(rest.getTelephone(),"6950");
    }
    @Test
    public void getTotalTables() {
        assertEquals(rest.getTotalTables(),10);
    }
    @Test
    public void getAddress() {
        assertEquals(rest.getAddress(),this.address);
    }

    @Test
    public void getChefs() {
        Chef chef = new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
        rest.addChef(chef);
        assertEquals(rest.getChefs().get(0),chef);
    }
    @Test
    public void getEmptyListChefs(){
        assertThrows(NoSuchElementException.class,()->rest.getChefs());
    }
    @Test
    public void changeTotalTables() {
        rest.changeTotalTables(15);
        assertEquals(rest.getTotalTables(),15);
    }

    @Test
    public void addChef() {
        Chef chef = new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
        rest.addChef(chef);
        assertEquals(rest.getChefs().get(0),chef);
    }
    @Test
    public void getDishes(){
        rest.addDish(dish1);
        rest.addDish(dish2);
        assertEquals(rest.getDishes().get(0),dish1);
        assertEquals(rest.getDishes().get(1),dish2);
    }
    @Test
    public void getOrders(){
        rest.addChef(new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234"));
        Customer customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        customer.topUp(100.0);
        Order order1 = new Order(10,"13:32:45",new Date(1672518456),customer);
        Order order2 = new Order(13,"14:45:34",new Date(1672618456),customer);
        rest.addOrder(order1);
        rest.addOrder(order2);
        assertEquals(rest.getOrders().get(0),order1);
        assertEquals(rest.getOrders().get(1),order2);
    }

    @Test
    public void getEmptyDishes(){
        assertThrows(NoSuchElementException.class,()->rest.getDishes());
    }

    @Test
    public void addDish() {
        rest.addDish(dish1);
        rest.addDish(dish2);
        assertEquals(rest.getDishes().get(0),dish1);
        assertEquals(rest.getDishes().get(1),dish2);
    }

    @Test
    public void addOrderWithoutEnoughMoney() {
        Customer customer =new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        customer.topUp(5.00);
        Order order = new Order(5,"13:32:45",new Date(1672518456),customer);
        order.addOrderLine(new OrderLine(2,dish1));
        assertFalse(rest.addOrder(order));
    }
    @Test
    public void addOrderWithEnoughMoney() {
        rest.addChef(new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234"));
        Customer customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        customer.topUp(100.00);
        Order order = new Order(5,"13:32:45",new Date(1672518456),customer);
        order.addOrderLine(new OrderLine(2,dish1));
        assertTrue(rest.addOrder(order));
    }
    @Test
    public void addOrderChefsCorrectDistributions() {
        Chef chef1 = new Chef("john123", "john", "pappas", "696949", "jpappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
        Chef chef2 = new Chef("geo124", "Giorgos", "pappas", "69694909", "gpappas@gmail.com", "12345423423", 1, "14356780290194", "14345234");
        rest.addChef(chef1);
        rest.addChef(chef2);
        Customer customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        customer.topUp(100.00);
        Order order1 = new Order(5,"13:32:45",new Date(1672518456),customer);
        order1.addOrderLine(new OrderLine(2,dish1));
        rest.addOrder(order1);
        assertEquals(rest.getChefs().get(0).getOrders().get(0), order1);
        Order order2 = new Order(5,"13:32:45",new Date(1672673456),customer);
        rest.addOrder(order2);
        assertEquals(rest.getChefs().get(1).getOrders().get(0), order2);
        Order order3 = new Order(5,"13:32:45",new Date(1678918456),customer);
        rest.addOrder(order3);
        assertEquals(rest.getChefs().get(0).getOrders().get(1), order3);

    }

}