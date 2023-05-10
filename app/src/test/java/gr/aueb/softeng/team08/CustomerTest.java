package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class CustomerTest {
    Customer customer;
    @Before
    public void setUp(){
      customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
    }
    @After
    public void tearDown(){
        customer=null;
    }
    @Test
    public void getUserId() {
        assertEquals(customer.getUserId(),1);
    }

    @Test
    public void getUsername() {
        assertEquals(customer.getUsername(),"john123");
    }

    @Test
    public void getName() {
        assertEquals(customer.getName(),"john");
    }
    @Test
    public void getSurname() {
        assertEquals(customer.getSurname(),"pappas");
    }
    @Test
    public void getTelephone() {
        assertEquals(customer.getTelephone(),"696949");
    }
    @Test
    public void getEmail() {
        assertEquals(customer.getEmail(),"pappas@gmail.com");
    }
    @Test
    public void getPassword() {
        assertEquals(customer.getPassword(),"12345123");
    }
    @Test
    public void changePersonalDetails() {// we decide to change only the username
        customer.changePersonalDetails("john322","john", "pappas", "696949", "pappas@gmail.com");
        assertEquals(customer.getUsername(),"john322");
    }
    @Test
    public void changePassword() {
        customer.changePassword("123454321");
        assertEquals(customer.getPassword(),"123454321");
    }
    @Test
    public void changeBankDetails(){ // we decide to change the cardNumber and keep everything else the same
        customer.changeBankDetails("12345","john","322"); // might need to call GETTERS to show that these stay the same
        assertEquals(customer.getCardNumber(),"12345");
    }
    @Test
    public void getCardNumber() {
        assertEquals(customer.getCardNumber(),"12222");
    }

    @Test
    public void getCVV() {
    assertEquals(customer.getCVV(), "322");
    }

    @Test
    public void getCardHolderName() {
        assertEquals(customer.getCardHolderName(), "john");
    }

    @Test
    public void getBalance() {
        assertEquals(customer.getBalance(), 0.00,0.00);
    }

    @Test
    public void transactionInsuffBalance() {
        assertThrows(IllegalStateException.class, ()-> customer.transaction(10));
    }
    @Test
    public void topUp() {
        customer.topUp(10.00);
        assertEquals(customer.getBalance(), 10.00,0.00);
    }
    @Test
    public void topUpNegativeMoney(){
        assertThrows(IllegalArgumentException.class,()->customer.topUp(-10));
    }
    @Test
    public void transaction() {
        customer.topUp(10);
        customer.transaction(5.00);
        assertEquals(customer.getBalance(), 5.00,0.00);
    }
}