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

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCardNumber() {
        assertEquals(customer.getCardNumber(),"12222");
    }

    @Test
    public void getCVV() {
    }

    @Test
    public void getCardHolderName() {
    }

    @Test
    public void getBalance() {
    }

    @Test
    public void transaction() {
    }

    @Test
    public void topUp() {
    }
}