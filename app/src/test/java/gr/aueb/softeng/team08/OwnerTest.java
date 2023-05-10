package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class OwnerTest {

    Owner owner;
    Restaurant rest1;
    Restaurant rest2;
    @Before
    public void setUp(){
        owner=new Owner("PaulM", "Paul", "Morrison", "6970", "Paulm@gmail.com", "priv8573", 324, "GR96081000", "1646");
        rest1 = new Restaurant("Los Pollos Ermanos","694959",15,new Address(6,"kiafa",159,"ioannina"));
        rest2= new Restaurant("Paprika","6950",10,new Address(2,"kalari",526,"patra"));
    }

    @After
    public void tearDown()  {
        this.owner=null;
        this.rest1=null;
        this.rest2=null;
    }

    @Test
    public void getUserId() {
        assertEquals(owner.getUserId(),324);
    }
    @Test
    public void getUsername() {
        assertEquals(owner.getUsername(),"PaulM");
    }
    @Test
    public void getName() {
        assertEquals(owner.getName(),"Paul");
    }
    @Test
    public void getSurname() {
        assertEquals(owner.getSurname(),"Morrison");
    }
    @Test
    public void getTelephone() {
        assertEquals(owner.getTelephone(),"6970");
    }
    @Test
    public void getEmail() {
        assertEquals(owner.getEmail(),"Paulm@gmail.com");
    }
    @Test
    public void getPassword() {
        assertEquals(owner.getPassword(),"priv8573");
    }
    @Test
    public void changePersonalDetailsFatherMethod() {// we decide to change only the username
        owner.changePersonalDetails("PaulM21", "Paul", "Morrison", "6970", "Paulm@gmail.com");
        assertEquals(owner.getUsername(),"PaulM21");
    }
    @Test
    public void changePassword() {
        owner.changePassword("123454321");
        assertEquals(owner.getPassword(),"123454321");
    }
    @Test
    public void changePersonalDetails() {// we decide to change the username
        owner.changePersonalDetails("PaulM21", "Paul", "Morrison", "6970", "Paulm@gmail.com","1646");
        assertEquals(owner.getUsername(),"PaulM21");
    }
    @Test
    public void getIban() {
        assertEquals(owner.getIban(),"GR96081000");
    }
    @Test
    public void getTin() {
        assertEquals(owner.getTin(), "1646");
    }
    @Test
    public void changeIban() {
        owner.changeIban("GR123456789");
        assertEquals(owner.getIban(), "GR123456789");
    }
    @Test
    public void addRestaurant() {
        owner.addRestaurant(rest1);
        assertEquals(owner.getRestaurants().get(0),rest1);
    }
    @Test
    public void getRestaurants() {
        owner.addRestaurant(rest1);
        owner.addRestaurant(rest2);
        assertEquals(owner.getRestaurants().get(0),rest1);
        assertEquals(owner.getRestaurants().get(1),rest2);
    }
    @Test
    public void getRestaurantWhenEmpty(){
        assertThrows(NoSuchElementException.class,()->owner.getRestaurants());
    }

    @Test
    public void addMoney() {
        owner.addMoney(100.0);
        assertTrue(owner.getIncome()==100.0);
    }
    @Test
    public void addNegativeMoney(){
        assertThrows(IllegalArgumentException.class,()->owner.addMoney(-10));
    }
    @Test
    public void getIncome() {
        owner.addMoney(50.0);
        assertTrue(owner.getIncome()==50.0);
    }
}