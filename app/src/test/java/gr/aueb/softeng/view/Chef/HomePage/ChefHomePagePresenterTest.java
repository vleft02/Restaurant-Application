package gr.aueb.softeng.view.Chef.HomePage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePagePresenter;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageView;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageViewStub;

public class ChefHomePagePresenterTest {

    private ChefHomePagePresenter presenter;

    private ChefHomePageViewStub view;

    private OrderDAO orderDAO;
    private ChefDAO chefDAO;
    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new ChefHomePageViewStub();

        orderDAO = new OrderDAOmemory();
        chefDAO = new ChefDAOmemory();

        presenter = new ChefHomePagePresenter(chefDAO,orderDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        presenter=null;
        view=null;
    }

    @Test
    public void setOrderList() {
        Chef chef = chefDAO.find("platias");
        presenter.setChef(chef.getUserId());
        presenter.setOrderList();
        ArrayList<Order>orders= chef.getOrders();
        ArrayList<Order>ReceivedOrders = new ArrayList<>();
        for(Order order:orders){
            if (order.getOrderState() == Order.State.RECEIVED)
            {
                ReceivedOrders.add(order);
            }
        }

        assertEquals(presenter.getOrderList(),ReceivedOrders);
    }
    @Test
    public void getChef(){
        Chef chef = chefDAO.find("platias");
        presenter.setChef(chef.getUserId());
        assertEquals(presenter.getChef(),chef);
    }

    @Test
    public void setView() {
        ChefHomePageView testView = new ChefHomePageViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }
    @Test
    public void getView(){
        assertEquals(presenter.getView(),view);
    }

    @Test
    public void getChefDAO() {
        assertEquals(presenter.getChefDAO(),chefDAO);
    }

    @Test
    public void getOrderDAO() {
        assertEquals(presenter.getOrderDAO(),orderDAO);
    }

    @Test
    public void setChef() {
        Chef chef = chefDAO.find("platias");
        presenter.setChef(chef.getUserId());
        assertEquals(presenter.getChef(),chef);
    }

    @Test
    public void getOrderList() {
        Chef chef = chefDAO.find("platias");
        presenter.setChef(chef.getUserId());
        presenter.setOrderList();
        ArrayList<Order>orders= chef.getOrders();
        ArrayList<Order>ReceivedOrders = new ArrayList<>();
        for(Order order:orders){
            if (order.getOrderState() == Order.State.RECEIVED)
            {
                ReceivedOrders.add(order);
            }
        }

        assertEquals(presenter.getOrderList(),ReceivedOrders);
    }

    @Test
    public void onChangeLayoutOrderListEmpty() {
        Chef chef = new Chef("alex1234","alexandros","alexandrou","1234567890","@","1234567890",chefDAO.nextId(),"12345678","123456");
        chefDAO.save(chef);
        presenter.setChef(chef.getUserId());
        presenter.setOrderList();
        presenter.onChangeLayout();
        assertEquals(1,view.getNoOrders());
        assertEquals(0,view.getOrdersFound());
    }


    @Test
    public void onChangeLayoutOrderFound() {
        Chef chef = chefDAO.find("platias");
        presenter.setChef(chef.getUserId());
        presenter.setOrderList();
        presenter.onChangeLayout();
        assertEquals(0,view.getNoOrders());
        assertEquals(1,view.getOrdersFound());
    }

    @Test
    public void onBack() {
        view.goBack();
        assertEquals(1,view.getGoBackPressed());
    }
}