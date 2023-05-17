package gr.aueb.softeng.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DishTest {
Dish dish;
    @Before
    public void setUp() throws Exception {
    dish = new Dish("food1",10.0);
    }

    @After
    public void tearDown() throws Exception {
        dish = null;
    }
    @Test
    public void getDishName() {
        assertEquals(dish.getDishName(),"food1");
    }

    @Test
    public void getDishWorth() {
        assertEquals(dish.getDishWorth(),10.0,0.00);
    }
}