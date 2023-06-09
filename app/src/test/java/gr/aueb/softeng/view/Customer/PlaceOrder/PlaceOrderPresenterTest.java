package gr.aueb.softeng.view.Customer.PlaceOrder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.DishDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.DishDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class PlaceOrderPresenterTest {

    PlaceOrderPresenter presenter;

    PlaceOrderViewStub view;

    RestaurantDAO restaurantDAO;

    CustomerDAO customerDAO;

    OrderDAO orderDAO;

    DishDAO dishDAO;


    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new PlaceOrderViewStub();

        orderDAO = new OrderDAOmemory();
        restaurantDAO = new RestaurantDAOmemory();
        customerDAO = new CustomerDAOmemory();
        dishDAO = new DishDAOmemory();

        presenter = new PlaceOrderPresenter(restaurantDAO,customerDAO,orderDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }

    @Test
    public void setView() {
        PlaceOrderView testView = new PlaceOrderViewStub();
        presenter.setView(testView);
        assertEquals(testView,presenter.getView());
    }

    @Test
    public void getView() {
        assertEquals(view,presenter.getView());
    }

    @Test
    public void setRestaurant() {
        presenter.setRestaurant(1);
        assertEquals(restaurantDAO.find(1), presenter.getRestaurant());
    }

    @Test
    public void getRestaurants()
    {
        presenter.setRestaurant(1);
        assertEquals(restaurantDAO.find(1), presenter.getRestaurant());
    }

    @Test
    public void getDishes() {
        presenter.setRestaurant(1);
        assertEquals(3,presenter.getDishes().size());
        assertEquals("patates",presenter.getDishes().get(0).getDishName());
    }

    @Test
    public void getDishesNullRestaurant() {
        assertTrue(presenter.getDishes().isEmpty());
    }

    @Test
    public void addOrderLine() {
        Dish dish = dishDAO.find(1);
        presenter.createOrder(12);
        presenter.addOrderLine(2,dish);
        assertEquals(1,presenter.getOrder().getOrderLines().size());
        assertEquals("patates",presenter.getOrder().getOrderLines().get(0).getDish().getDishName());
        assertEquals(2,presenter.getOrder().getOrderLines().get(0).getQuantity());
    }

    @Test
    public void addOrderLineNullDish() {
        Dish dish = null;
        presenter.createOrder(12);
        presenter.addOrderLine(2,dish);
        assertEquals(0,presenter.getOrder().getOrderLines().size());
    }

    @Test
    public void addOrderLineInvalidQuantity() {
        Dish dish = dishDAO.find(1);
        presenter.createOrder(3);
        presenter.addOrderLine(0,dish);
        assertEquals(0,presenter.getOrder().getOrderLines().size());
    }


    @Test
    public void onChangeLayoutEmptyList() {
        presenter.onChangeLayout();
        assertTrue(view.getDishListEmpty());
    }
    @Test
    public void onChangeLayoutWithDishes() {
        presenter.setRestaurant(1);
        presenter.onChangeLayout();
        assertFalse(view.getDishListEmpty());
    }

    @Test
    public void onPlaceOrderSuccessful() {
        assertEquals(7, orderDAO.findAll().size());
        presenter.setCustomer(3);
        customerDAO.find(3).topUp(50.0);
        presenter.setRestaurant(1);
        Dish dish = dishDAO.find(1);
        presenter.createOrder(4);
        presenter.addOrderLine(2,dish);
        dish = dishDAO.find(2);
        presenter.addOrderLine(1,dish);
        presenter.onPlaceOrder();
        assertEquals(8,orderDAO.findAll().size());
        assertEquals(23.0, orderDAO.find(8).getTotalCost(),0.00);
        assertEquals(customerDAO.find(3), orderDAO.find(8).getCustomer());
        assertEquals("Are you sure you want to place your order",view.getMessage());
    }

    @Test
    public void onPlaceOrderNotEnoughMoney() {
        //testCustomer has no money
        assertEquals(7, orderDAO.findAll().size());
        presenter.setCustomer(3);
        presenter.setRestaurant(1);
        Dish dish = dishDAO.find(1);
        presenter.createOrder(4);
        presenter.addOrderLine(2,dish);
        dish = dishDAO.find(2);
        presenter.addOrderLine(1,dish);
        presenter.onPlaceOrder();
        assertEquals(7,orderDAO.findAll().size());
        assertEquals( "insufficient funds",view.getMessage());
    }

    @Test
    public void onPlaceOrderNoOrderLines() {
        assertEquals(7, orderDAO.findAll().size());
        presenter.setCustomer(3);
        presenter.setRestaurant(1);
        presenter.createOrder(4);
        presenter.onPlaceOrder();
        assertEquals(7,orderDAO.findAll().size());
        assertEquals("",view.getMessage());
    }

    @Test
    public void getTotalCost() {
        assertEquals(7, orderDAO.findAll().size());
        presenter.setCustomer(3);
        customerDAO.find(3).topUp(50.0);
        presenter.setRestaurant(1);
        Dish dish = dishDAO.find(1);
        presenter.createOrder(4);
        presenter.addOrderLine(2,dish);
        dish = dishDAO.find(2);
        presenter.addOrderLine(1,dish);
        assertEquals(23.0,presenter.getTotalCost(),0.00);
    }

    @Test
    public void createOrder() {
        assertNull(presenter.getOrder());
        presenter.setCustomer(3);
        presenter.createOrder(4);
        assertEquals(4,presenter.getOrder().getTableNumber());
        assertEquals(presenter.getCustomer(),presenter.getOrder().getCustomer());
    }
    @Test
    public void getOrder()
    {
        presenter.setCustomer(3);
        presenter.createOrder(4);
        assertEquals(4,presenter.getOrder().getTableNumber());
        assertEquals(presenter.getCustomer(),presenter.getOrder().getCustomer());
    }

    @Test
    public void setCustomer() {
        presenter.setCustomer(3);
        assertEquals(customerDAO.find(3),presenter.getCustomer());
    }

    @Test
    public void getCustomer() {
        presenter.setCustomer(3);
        assertEquals(customerDAO.find(3),presenter.getCustomer());
    }

    @Test
    public void onCart() {
        assertEquals(7, orderDAO.findAll().size());
        presenter.setCustomer(3);
        customerDAO.find(3).topUp(50.0);
        presenter.setRestaurant(1);
        Dish dish = dishDAO.find(1);
        presenter.createOrder(4);
        presenter.addOrderLine(2,dish);
        dish = dishDAO.find(2);
        presenter.addOrderLine(1,dish);
        presenter.onPlaceOrder();

        presenter.onCart();
        assertEquals(presenter.getOrder().getOrderLines(),view.getReturnedOrderLines());
    }

    @Test
    public void setOrderLines() {

        assertEquals(7, orderDAO.findAll().size());
        presenter.setCustomer(3);
        customerDAO.find(3).topUp(50.0);
        presenter.setRestaurant(1);
        Dish dish1 = dishDAO.find(1);
        presenter.createOrder(4);
        presenter.addOrderLine(2,dish1);
        Dish dish2 = dishDAO.find(2);
        presenter.addOrderLine(1,dish2);
        presenter.onPlaceOrder();

        presenter.onCart();
        assertEquals(presenter.getOrder().getOrderLines(),view.getReturnedOrderLines());

        presenter.getOrder().getOrderLines().remove(0);

        Dish dish3 = dishDAO.find(3);

        ArrayList<OrderLine> newOrderLines = new ArrayList<>();
        newOrderLines.add(new OrderLine(2,dish1));
        newOrderLines.add(new OrderLine(2,dish2));
        newOrderLines.add(new OrderLine(2,dish3));

        presenter.setOrderLines(newOrderLines);
        assertEquals(newOrderLines,presenter.getOrder().getOrderLines());
        assertEquals(46.0,presenter.getOrder().getTotalCost(),0.00);
    }
}