package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {
    Address address;
    @Before
    public void setUp() {
        address = new Address(2,"kalari",526,"patra");
    }

    @After
    public void tearDown() {
        address=null;
    }

    @Test
    public void getStreetNumber() {
        assertEquals(address.getStreetNumber(),2);
    }
    @Test
    public void getStreetName() {
        assertEquals(address.getStreetName(),"kalari");
    }

    @Test
    public void getZipCode() {
        assertEquals(address.getZipCode(),526);
    }

    @Test
    public void getCity() {
        assertEquals(address.getCity(),"patra");
    }
}