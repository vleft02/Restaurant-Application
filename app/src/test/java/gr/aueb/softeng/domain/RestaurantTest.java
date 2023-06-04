package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class RestaurantTest {
    Restaurant rest;
    Address address;

    Dish dish1 = new Dish(1,"psari",10.0); //iws mpei se contstuctor ean thelw stin test na min xrisimopoiei ta alla methods
    Dish dish2 = new Dish(2,"patates",8.00);
    @Before
    public void setUp(){
        address = new Address(2,"kalari",526,"patra");
        rest= new Restaurant(3,"Paprika","6950",10,address);
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
    public void getId(){
        assertEquals(rest.getId(),3);
    }
    @Test
    public void getChefs() {
        Chef chef = new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
        rest.addChef(chef);
        assertEquals(rest.getChefs().get(0),chef);
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
        Order order1 = new Order(10,LocalDateTime.of(2023,10,12,10,12),13,customer);
        Order order2 = new Order(13,LocalDateTime.of(2023,11,12,10,12),26,customer);
        rest.addOrder(order1);
        rest.addOrder(order2);
        assertEquals(rest.getOrders().get(0),order1);
        assertEquals(rest.getOrders().get(1),order2);
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
        Order order = new Order(5, LocalDateTime.of(2023,6,12,10,12),7,customer);
        order.addOrderLine(new OrderLine(2,dish1));
        assertFalse(rest.addOrder(order));
    }
    @Test
    public void addOrderWithEnoughMoney() {
        rest.addChef(new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234"));
        Customer customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        customer.topUp(100.00);
        Order order = new Order(5,LocalDateTime.of(2023,8,12,10,12),9,customer);
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
        Order order1 = new Order(5,LocalDateTime.of(2023,3,6,10,12),3,customer);
        order1.addOrderLine(new OrderLine(2,dish1));
        rest.addOrder(order1);
        assertEquals(rest.getChefs().get(0).getOrders().get(0), order1);
        Order order2 = new Order(5,LocalDateTime.of(2023,9,9,10,12),9,customer);
        rest.addOrder(order2);
        assertEquals(rest.getChefs().get(1).getOrders().get(0), order2);
        Order order3 = new Order(5,LocalDateTime.of(2023,1,1,10,3),11,customer);
        rest.addOrder(order3);
        assertEquals(rest.getChefs().get(0).getOrders().get(1), order3);

    }

}