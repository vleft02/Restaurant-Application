package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

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
    public void addDish() {
        rest.addDish(dish1);
        rest.addDish(dish2);
        assertEquals(rest.getDishes().get(0),dish1);
        assertEquals(rest.getDishes().get(1),dish2);
    }

    @Test
    public void addOrder() {

    }
}