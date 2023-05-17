package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.NoSuchElementException;

public class ChefTest {
Chef chef;
Customer customer;
Order order1;
    @Before
    public void setUp(){
        chef = new Chef("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "10230910290194", "14323234");
        customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
        order1 = new Order(10,"13:32:45",new Date(2023-5-6),this.customer);
    }
    @After
    public void tearDown(){
        chef=null;
        customer=null;
        order1=null;
    }
    @Test
    public void getUserId() {
        assertEquals(chef.getUserId(),1);
    }
    @Test
    public void getUsername() {
        assertEquals(customer.getUsername(),"john123");
    }
    @Test
    public void getName() {
        assertEquals(chef.getName(),"john");
    }
    @Test
    public void getSurname() {
        assertEquals(chef.getSurname(),"pappas");
    }
    @Test
    public void getTelephone() {
        assertEquals(chef.getTelephone(),"696949");
    }
    @Test
    public void getEmail() {
        assertEquals(chef.getEmail(),"pappas@gmail.com");
    }
    @Test
    public void getPassword() {
        assertEquals(chef.getPassword(),"12345123");
    }
    @Test
    public void changePersonalDetailsFatherMethod() {// we decide to change only the username , so we use the getters for the other arguments
        chef.changePersonalDetails("john322",chef.getName(), chef.getSurname(), chef.getTelephone(), chef.getEmail());
        assertEquals(chef.getUsername(),"john322");
    }
    @Test
    public void changePassword() {
        chef.changePassword("123454321");
        assertEquals(chef.getPassword(),"123454321");
    }

    @Test
    public void changePersonalDetails(){ // we decide to change only the username, so we use the getters for the other arguments
        chef.changePersonalDetails("john321",chef.getName(), chef.getSurname(), chef.getTelephone(), chef.getEmail(),  chef.getTin());
        assertEquals(chef.getUsername(),"john321");
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
    public void changeIban(){
        chef.changeIban("123456789");
        assertEquals(chef.getIban(),"123456789");
    }
    @Test
    public void getOrders() {
        Order order2=  new Order(13,"14:45:34",new Date(2023-5-6),this.customer);
        chef.addOrder(order1);
        chef.addOrder(order2);
        assertTrue(chef.getOrders().contains(order1));
        assertTrue(chef.getOrders().contains(order2));
    }
    @Test
    public void getOrdersWhenEmpty(){
        assertThrows(NoSuchElementException.class,()-> chef.getOrders());
    }
    @Test
    public void addOrder() {
        chef.addOrder(order1);
        //assertEquals(chef.getOrders().size(),1);
        assertTrue(chef.getOrders().contains(order1));
    }
    @Test
    public void removeOrder() {
        chef.addOrder(order1);
        assertTrue(chef.removeOrder(order1));
    }
    @Test
    public void removeOrderWhenNotInList() {
        chef.addOrder(order1);
        Order order = new Order(4, "12:10:09", new Date(2023 - 5 - 6), customer);
        assertFalse(chef.removeOrder(order));
    }
}