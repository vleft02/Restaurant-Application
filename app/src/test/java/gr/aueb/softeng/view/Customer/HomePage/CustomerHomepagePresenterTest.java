package gr.aueb.softeng.view.Customer.HomePage;

import static org.junit.Assert.*;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class CustomerHomepagePresenterTest {

    CustomerHomepagePresenter presenter;

    CustomerHomepageViewStub view;

    CustomerDAO customerDAO;
    OrderDAO orderDAO;
    ChefDAO chefDAO;
    RestaurantDAO restaurantDAO;

    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new CustomerHomepageViewStub();

        customerDAO = new CustomerDAOmemory();
        orderDAO = new OrderDAOmemory();
        chefDAO = new ChefDAOmemory();
        restaurantDAO = new RestaurantDAOmemory();


        presenter = new CustomerHomepagePresenter(customerDAO, orderDAO, chefDAO, restaurantDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }

    @Test
    public void setRestaurant() {
        presenter.setRestaurant(restaurantDAO.find(1).getId());
        assertEquals(restaurantDAO.find(1),presenter.getRestaurant());
    }
    @Test
    public void setRestaurantNull() {
        presenter.setRestaurant(-1);
        assertNull(presenter.getRestaurant());
    }

    @Test
    public void setCustomer() {
        presenter.setCustomer(customerDAO.find(3).getUserId());
        assertEquals(customerDAO.find(3),presenter.getCustomer());
    }
    @Test
    public void setCustomerNull() {
        presenter.setCustomer(-1);
        assertNull(presenter.getCustomer());
    }

    @Test
    public void getCustomer() {
        presenter.setCustomer(customerDAO.find(3).getUserId());
        assertEquals(customerDAO.find(3),presenter.getCustomer());
    }

    @Test
    public void setOrderHistory() {
        presenter.setCustomer(customerDAO.find(3).getUserId());
        presenter.setOrderHistory();
        assertEquals(orderDAO.findByCustomer(customerDAO.find(3)),presenter.getOrderHistory());
    }

    @Test
    public void setOrderHistoryNullCustomer() {
        presenter.setOrderHistory();
        assertTrue(presenter.getOrderHistory().isEmpty());
    }

    @Test
    public void getOrderHistory() {
        presenter.setCustomer(customerDAO.find(3).getUserId());
        presenter.setOrderHistory();
        assertEquals(orderDAO.findByCustomer(customerDAO.find(3)),presenter.getOrderHistory());
    }

    @Test
    public void setCurrentOrder() {
        //kostas123 has a live order with id 3
        presenter.setCustomer(customerDAO.find(4).getUserId());
        presenter.setCurrentOrder();
        assertEquals(orderDAO.find(3),presenter.getCurrentOrder());
    }
    @Test
    public void setCurrentOrderCustomerNull() {
        presenter.setCurrentOrder();
        assertNull(presenter.getCurrentOrder());
    }

    @Test
    public void getCurrentOrder() {
        //kostas123 has a live order with id 3
        presenter.setCustomer(customerDAO.find(4).getUserId());
        presenter.setCurrentOrder();
        assertEquals(orderDAO.find(3),presenter.getCurrentOrder());
    }

    @Test
    public void setView() {
        CustomerHomepageView testView = new CustomerHomepageViewStub();
        presenter.setView(testView);
        assertEquals(testView, presenter.getView());
    }

    @Test
    public void getView(){
        assertEquals(view, presenter.getView());
    }

    @Test
    public void getCurrentOrderDetails() {
        //kostas123 has a live order with id 3
        presenter.setCustomer(customerDAO.find(4).getUserId());
        presenter.setCurrentOrder();
        assertEquals("#3\nRECEIVED\n8 OCTOBER 2023\n3:12\n119.00 €",presenter.getCurrentOrderDetails ());
    }

    @Test
    public void onCancel() {
        presenter.onCancel();
        assertEquals("Canceling order",view.getMessage());
    }
    @Test
    public void chooseLayoutCustomerHasCurrentOrder() {
        //kostas123 has one live order with id 3
        presenter.setCustomer(customerDAO.find(4).getUserId());
        presenter.setCurrentOrder();
        presenter.chooseLayout();
        assertEquals(1,view.getOrderIsShown());
        assertEquals(0,view.getNoOrderIsShown());
    }
    @Test
    public void chooseLayoutCustomerNoCurrentOrder() {
        //testCustomer has no orders
        presenter.setCustomer(customerDAO.find(3).getUserId());
        presenter.setCurrentOrder();
        presenter.chooseLayout();
        assertEquals(0,view.getOrderIsShown());
        assertEquals(1,view.getNoOrderIsShown());
    }

    @Test
    public void cancel() {
        presenter.setCustomer(customerDAO.find(4).getUserId());
        presenter.setCurrentOrder();
        presenter.cancel();
        assertEquals(3,presenter.getOrderHistory().size());
        //The order that was cancelled and added to the orderHistory has id 3
        assertEquals(orderDAO.find(3),presenter.getOrderHistory().get(2));
    }


    @Test
    public void onTopUp() {
        presenter.onTopUp();
        assertEquals("Redirecting to top up page",view.getMessage());
    }

    @Test
    public void getRestaurantCapacity() {
        presenter.setRestaurant(1);
        assertEquals(restaurantDAO.find(1).getTotalTables(),presenter.getRestaurantCapacity());
    }
    @Test
    public void getRestaurantCapacityNullRestaurant() {
        presenter.setRestaurant(-1);
        assertEquals(0,presenter.getRestaurantCapacity());
    }

    @Test
    public void checkTableAvailabilityNullRestaurant() {
        presenter.setRestaurant(-1);
        assertFalse(presenter.checkTableAvailability(12));
    }
    @Test
    public void checkTableAvailability() {
        presenter.setRestaurant(1);
        assertTrue(presenter.checkTableAvailability(5));
    }
    @Test
    public void checkTableAvailabilityTableUnavailable() {
        presenter.setRestaurant(1);
        assertFalse(presenter.checkTableAvailability(12));
    }

    @Test
    public void onPlaceOrder() {
        presenter.onPlaceOrder();
        assertEquals("Redirecting to place order page",view.getMessage());
    }
}