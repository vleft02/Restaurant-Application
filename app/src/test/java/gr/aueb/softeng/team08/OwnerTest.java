package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class OwnerTest{
    Owner owner;
    ArrayList<Restaurant> restaurants= new ArrayList<Restaurant>();
    Restaurant restaurant1;
    Restaurant restaurant2;

    @Before
    public void setUp() throws Exception {

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        owner = new Owner("PaulM", "Paul", "Morrison", "6970570493", "Paulm@gmail.com", "priv8573", 324, "GR9608100010000001234567890", "164640345", 23345, restaurants);

    }

    @After
    public void tearDown() throws Exception {
        owner = null;
    }

    @Test
    public void getIban() {
        assertEquals(owner.getIban(),"GR9608100010000001234567890");
    }

    @Test
    public void getTin() {
        assertEquals(owner.getTin(),"164640345");
    }

    @Test
    public void getRestaurants() {
        assertSame(owner.getRestaurants().get(0), restaurant1);
        assertSame(owner.getRestaurants().get(1), restaurant2);
    }

    @Test
    public void addRestaurant(Restaurant restaurant) {
        assertSame(owner.getRestaurants().get(2), restaurant);
    }

    @Test
    public void addMoney(double money) {
        double total = owner.getIncome() + money;
        assertSame(owner.getIncome(), total);
    }

    @Test
    public void getIncome() {
        assertSame(owner.getIncome(), 23345);
    }
}