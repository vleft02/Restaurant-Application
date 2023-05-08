package gr.aueb.softeng.team08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;

public class RestaurantTest {
    Restaurant restaurant;
    ArrayList<Chef> chefs = new ArrayList<>();
    ArrayList<Dish> dishes = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    Customer customer= new Customer("john123", "john", "pappas", "696949", "pappas@gmail.com", "12345123", 1, "12222", "john", "322");
    Chef chef1 = new Chef("MCaroll", "Mary", "Caroll", "2483906789", "MCaroll@gmail.com", "fwiljhtx", 2456, "123456345097654", "3547690");
    Chef chef2 = new Chef("JessMartin", "Jess", "Martin", "2235117689", "jmartin@gmail.com", "sjftyocs", 4567, "235709816528903426", "125790456");
    Dish dish1 = new Dish("Chicken Wings", 8);
    Dish dish2 = new Dish("Fish fillet", 7);
    Order order1 = new Order(10,"13:32:45",new Date(2023-5-6), customer);
    Order order2 = new Order(13,"14:45:34",new Date(2023-5-6),customer);

    @Before
    public void setUp() throws Exception {
        restaurant = new Restaurant("Los Pollos Hermanos", "6980580493", 15, "Evelpidon", chefs, dishes, orders);

    }

    @After
    public void tearDown() throws Exception {
        restaurant = null;
    }

    @Test
    public void getRestaurantName() {
        assertEquals(restaurant.getRestaurantName(), "Los Pollos Hermanos");
    }

    @Test
    public void getTelephone() {
        assertEquals(restaurant.getTelephone(), "6980580493");
    }

    @Test
    public void getTotalTables() {
        assertEquals(restaurant.getTotalTables(), 15);
    }

    @Test
    public void getAddress() {
        assertEquals(restaurant.getAddress(), "Evelpidon");
    }

    @Test
    public void getChefs() {
        chefs.add(chef1);
        chefs.add(chef2);
        assertEquals(restaurant.getChefs(), chefs);
    }

    @Test
    public void changeTotalTables(int number) {
        assertEquals(restaurant.getTotalTables(), number);
    }

    @Test
    public void addChef(Chef chef) {

        assertEquals(restaurant.getChefs().get(3), chef);
    }

    @Test
    public void getDishes() {
        dishes.add(dish1);
        dishes.add(dish2);
        assertEquals(restaurant.getDishes(), dishes);
    }

    @Test
    public void addDish(Dish dish) {
        restaurant.addDish(dish);
        assertEquals(restaurant.getDishes().get(2), dish);
    }

    @Test
    public void addOrder(Order order) {
        orders.add(order1);
        orders.add(order2);
        assertEquals(orders.get(2), order);
    }
}