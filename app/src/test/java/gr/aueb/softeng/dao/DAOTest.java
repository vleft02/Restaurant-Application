package gr.aueb.softeng.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.domain.Address;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.domain.User;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.DishDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

/**
 * Κλάση ελέγχου για τις βασικές πράξεις των αντικειμένων πρόσβασης δεδομένων
 */

public class DAOTest {
    private ChefDAO chefDao;
    private CustomerDAO customerDao;
    private DishDAO dishDao;
    private OrderDAO orderDAO;
    private OwnerDAO ownerDao;
    private RestaurantDAO restaurantDao;
    private UserDAO userDao;

    private static final int INITIAL_CHEF_COUNT =2;
    private static final int INITIAL_CUSTOMER_COUNT =4;
    private static final int INITIAL_DISH_COUNT =6;
    private static final int INITIAL_ORDER_COUNT =7;
    private static final int INITIAL_OWNER_COUNT =3;
    private static final int INITIAL_RESTAURANT_COUNT =2;
    private static final int INITIAL_USER_COUNT =9;





    @Before
    public void setUp(){
        Initializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        chefDao=new ChefDAOmemory();
        customerDao=new CustomerDAOmemory();
        dishDao = new DishDAOmemory();
        orderDAO = new OrderDAOmemory();
        ownerDao = new OwnerDAOmemory();
        restaurantDao = new RestaurantDAOmemory();
        userDao= new UserDAOmemory();

    }
    @After
    public void tearDown(){
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }
    @Test
    public void chefsSizeCheck(){
        assertEquals(2, chefDao.findAll().size());
    }
    @Test
    public void customersSizeCheck(){
        assertEquals(4,customerDao.findAll().size());
    }
    @Test
    public void dishesSizeCheck(){
        assertEquals(6,dishDao.findAll().size());
    }
    @Test
    public void ordersSizeCheck(){
        assertEquals(7,orderDAO.findAll().size());
    }
    @Test
    public void ownersSizeCheck(){
        assertEquals(3,ownerDao.findAll().size());
    }
    @Test
    public void restaurantsSizeCheck(){
        assertEquals(2,restaurantDao.findAll().size());
    }

    @Test
    public void usersSizeCheck(){
        assertEquals(9,userDao.findAll().size());
    }
////////////////////////////////////////////////////////////////
    @Test
    public void findExistingChef(){
        assertNotNull(chefDao.find("platias"));
    }
    @Test
    public void findExistingCustomer(){
        Customer cust = customerDao.find(6);
        assertEquals("adreas:)",cust.getUsername());
    }
    @Test
    public void findExistingDish(){
        assertNotNull(dishDao.find(1));
    }
    @Test
    public void findExistingOrder(){
        assertNotNull(orderDAO.find(2));
    }
    @Test
    public void findExistingOwner(){
        Owner owner = ownerDao.find(7);
        assertEquals("owner1",owner.getUsername());
    }
    @Test
    public void findExistingRestaurant(){
        assertNotNull(restaurantDao.find("Kafeteria"));
    }
    @Test
    public void findExistingUser(){
        assertNotNull(userDao.find("platias"));
    }
    /////////////////////////////////////////////////////////////////
    @Test
    public void getNonExistantChef(){
        assertNull(chefDao.find(10));
    }

    @Test
    public void getNonExistantCustomer(){
        assertNull(customerDao.find("papadakis"));
    }

    @Test
    public void getNonExistantDish(){
        assertNull(dishDao.find(15));
    }
    @Test
    public void getNonExistantOrder(){
        Order order = orderDAO.find(19);
        assertNull(order);
    }
    @Test
    public void getNonExistantOwner(){
        Owner owner = ownerDao.find("papagewrgiou");
        assertNull(owner);
    }
    @Test
    public void getNonExistantRestaurant(){
        assertNull(restaurantDao.find(20));
    }
    @Test
    public void getNonExistantUser(){
        assertNull(userDao.find("xristou"));
    }
/////////////////////////////////////////////////////////////////////
    @Test
    public void listAllChefs() {
        List<Chef> allChefs = chefDao.findAll();
        assertEquals(INITIAL_CHEF_COUNT,allChefs.size());
    }
    @Test
    public void listAllCustomers(){
        List<Customer> allCustomeras = customerDao.findAll();
        assertEquals(INITIAL_CUSTOMER_COUNT,allCustomeras.size());
    }

    @Test
    public void listAllDishes(){
        List<Dish> allDishes = dishDao.findAll();
        assertEquals(INITIAL_DISH_COUNT,allDishes.size());
    }

    @Test
    public void listAllOrders(){
        List<Order> allOrders = orderDAO.findAll();
        assertEquals(INITIAL_ORDER_COUNT , allOrders.size());
    }

    @Test
    public void listAllOwners(){
        List<Owner> allOwners = ownerDao.findAll();
        assertEquals(INITIAL_OWNER_COUNT,allOwners.size());
    }

    @Test
    public void listAllRestaurants(){
        List<Restaurant> allRests = restaurantDao.findAll();
        assertEquals(INITIAL_RESTAURANT_COUNT,allRests.size());
    }

    @Test
    public void listAllUsers(){
        List<User> allUsers = userDao.findAll();
        assertEquals(INITIAL_USER_COUNT,allUsers.size());
    }

    @Test
    public void saveChef(){
        Chef chef = new Chef("papachris123","christos","papachristos","1234567890","@","123456789", chefDao.nextId(),"12345678","1234567");
        chefDao.save(chef);
        List<Chef> chefs = chefDao.findAll();
        assertEquals(INITIAL_CHEF_COUNT+1,chefs.size());
        assertNotNull(chefDao.find(chef.getUserId()));
        assertTrue(chefs.contains(chef));
    }

    @Test
    public void deleteChef(){
        Chef chef = chefDao.find("platias");
        chefDao.delete(chef);
        List<Chef> chefs = chefDao.findAll();
        assertEquals(INITIAL_CHEF_COUNT-1,chefs.size());
        assertNull(chefDao.find(chef.getUserId()));
        assertFalse(chefs.contains(chef));
    }

    @Test
    public void saveCustomer(){
        Customer cust = new Customer("papachris123","christos","papachristos","1234567890","@","123456789",customerDao.nextId(),"12345678910","papachristoschris","11222");
        customerDao.save(cust);
        List<Customer> customers = customerDao.findAll();
        assertEquals(INITIAL_CUSTOMER_COUNT+1,customers.size());
        assertNotNull(customerDao.find(cust.getUserId()));
        assertTrue(customers.contains(cust));
    }
    @Test
    public void deleteCustomer(){
        Customer cust = customerDao.find("adreas:)");
        customerDao.delete(cust);
        List<Customer> customers = customerDao.findAll();
        assertEquals(INITIAL_CUSTOMER_COUNT-1,customers.size());
        assertNull(customerDao.find(cust.getUserId()));
        assertFalse(customers.contains(cust));
    }

    @Test
    public void saveDish(){
        Dish dish = new Dish(dishDao.nextId(), "tirokafteri",15);
        dishDao.save(dish);
        List<Dish> dishes = dishDao.findAll();
        assertEquals(INITIAL_DISH_COUNT+1,dishes.size());
        assertNotNull(dishDao.find(dish.getId()));
        assertTrue(dishes.contains(dish));
    }
    @Test
    public void deleteDish(){
        Dish dish = dishDao.find(1);
        dishDao.delete(dish);
        List<Dish> dishes = dishDao.findAll();
        assertEquals(INITIAL_DISH_COUNT-1,dishes.size());
        assertNull(dishDao.find(dish.getId()));
        assertFalse(dishes.contains(dish));}

    @Test
    public void saveOrder(){
        Order order = new Order(10, LocalDateTime.now(), orderDAO.nextId(),customerDao.find("kostas123"));
        orderDAO.save(order);
        List<Order>orders = orderDAO.findAll();
        assertEquals(INITIAL_ORDER_COUNT+1,orders.size());
        assertNotNull(orderDAO.find(order.getId()));
        assertTrue(orders.contains(order));
    }
    @Test
    public void deleteOrder(){
        Order order = orderDAO.find(3);
        orderDAO.delete(order);
        List<Order>orders = orderDAO.findAll();
        assertEquals(INITIAL_ORDER_COUNT+-1,orders.size());
        assertNull(orderDAO.find(order.getId()));
        assertFalse(orders.contains(order));
    }

    @Test
    public void saveOwner(){
        Owner owner = new Owner("papachris123","christos","papachristos","1234567890","@","123456789",ownerDao.nextId(),"12345678910","1234566788");
        ownerDao.save(owner);
        List<Owner> owners = ownerDao.findAll();
        assertEquals(INITIAL_OWNER_COUNT+1,owners.size());
        assertNotNull(ownerDao.find(owner.getUserId()));
        assertTrue(owners.contains(owner));
    }
    @Test
    public void deleteOwner(){
        Owner owner = ownerDao.find("owner1");
        ownerDao.delete(owner);
        List<Owner> owners = ownerDao.findAll();
        assertEquals(INITIAL_OWNER_COUNT-1,owners.size());
        assertNull(ownerDao.find(owner.getUserId()));
        assertFalse(owners.contains(owner));
    }

    @Test
    public void saveRestaurant(){
        Restaurant rest = new Restaurant(restaurantDao.nextId(), "pitatoupappou","1234567890",15,new Address(15,"likovrisi",12334,"athinaa"));
        restaurantDao.save(rest);
        List<Restaurant> rests = restaurantDao.findAll();
        assertEquals(INITIAL_RESTAURANT_COUNT+1,rests.size());
        assertNotNull(restaurantDao.find(rest.getId()));
        assertTrue(rests.contains(rest));
    }
    @Test
    public void deleteRestaurant(){
        Restaurant rest = restaurantDao.find("Taverna");
        restaurantDao.delete(rest);
        List<Restaurant> rests = restaurantDao.findAll();
        assertEquals(INITIAL_RESTAURANT_COUNT-1,rests.size());
        assertNull(restaurantDao.find(rest.getId()));
        assertFalse(rests.contains(rest));
    }

    @Test
    public void saveUser(){
        User user = new Owner("papachris123","christos","papachristos","1234567890","@","123456789",ownerDao.nextId(),"12345678910","1234566788");
        userDao.save(user);
        List<User> users = userDao.findAll();
        assertEquals(INITIAL_USER_COUNT+1,users.size());
        assertNotNull(userDao.find(user.getUserId()));
        assertTrue(users.contains(user));
    }
    @Test
    public void deleteUser(){
        User user = userDao.find("platias");
        userDao.delete(user);
        List<User> users = userDao.findAll();
        assertEquals(INITIAL_USER_COUNT-1,users.size());
        assertNull(userDao.find(user.getUserId()));
        assertFalse(users.contains(user));}

}
