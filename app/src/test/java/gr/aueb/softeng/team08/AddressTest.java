package gr.aueb.softeng.team08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class AddressTest {
    Address address1;


    @Before
    public void setUp() throws Exception {
        address1 = new Address(32, "Naxou",11362,"Athens");


    }

    @After
    public void tearDown() throws Exception {
        address1 = null;

    }


    @Test
    public void sameAddresses(Address address1, Address address2){
        assertSame(address1, address2);
    }

    @Test
    public void getStreetNumber() {
        assertSame(address1.getStreetNumber(),32);

    }

    @Test
    public void getStreetName() {
        assertSame(address1.getStreetName(),"Naxou");

    }


    @Test
    public void getZipCode() {
        assertEquals(address1.getZipCode(),11362);

    }


    @Test
    public void getCity() {
        assertSame(address1.getZipCode(),"Athens");

    }
}
