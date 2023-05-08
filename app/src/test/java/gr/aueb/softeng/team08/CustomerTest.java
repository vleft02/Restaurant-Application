package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    Customer customer;
    @Before
    public void setUp() throws Exception {
      customer = new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
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
    public void topUp() {
        customer.topUp(10);
        assertEquals(customer.getBalance(), 10.00,0.00);
    }
     @Test
    public void transaction() {
        customer.topUp(10);
        customer.transaction(5.00);
        assertEquals(customer.getBalance(), 5.00,0.00);
    }
}