package gr.aueb.softeng.view.Chef.OrderDetails;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;

public class OrderDetailsPresenterTest {
    OrderDetailsViewStub view;
    OrderDetailsPresenter presenter;
    private ChefDAO chefDAO;
    private OrderDAO orderDAO;
    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view=new OrderDetailsViewStub();
        chefDAO=new ChefDAOmemory();
        orderDAO=new OrderDAOmemory();
        presenter=new OrderDetailsPresenter(chefDAO,orderDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        view=null;
        presenter=null;
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }

    @Test
    public void setOrderLineList() {
        Order order = orderDAO.find(2);
        ArrayList<OrderLine> orderLines= order.getOrderLines();
        presenter.setOrder(order.getId());
        presenter.setOrderLineList();
        assertEquals(presenter.getOrderLineList(),orderLines);
    }

    @Test
    public void setView() {
        OrderDetailsViewStub testView = new OrderDetailsViewStub();
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
    public void setOrder() {
        Order order = orderDAO.find(2);
        presenter.setOrder(order.getId());
        assertEquals(presenter.getOrder(),order);
    }

    @Test
    public void getOrderLineList() {
        Order order = orderDAO.find(2);
        ArrayList<OrderLine> orderLines=order.getOrderLines();
        presenter.setOrder(order.getId());
        presenter.setOrderLineList();
        assertEquals(presenter.getOrderLineList(),orderLines);
    }

    @Test
    public void setOrderDetails() {
        Order order = orderDAO.find(2);
        presenter.setOrder(order.getId());
        presenter.setOrderDetails();
        assertEquals(view.getOrderId(),"2");
        assertEquals(view.getState(),"COMPLETED");
        assertEquals(view.getTableNumber(),"11");
        assertEquals(view.getDat(),"3 OCTOBER 2023 Time:10:3");
    }

    @Test
    public void onCompleted() {
        Order order = orderDAO.find(3);
        presenter.setOrder(order.getId());
        presenter.onCompleted();
        assertEquals(view.getSuccessMessage(),"the order was completed");
    }

    @Test
    public void onBack() {
        view.goBack();
        assertEquals(1,view.getGoBackPressed());
    }
    @Test
    public void getChef(){
        Chef chef = chefDAO.find("platias");
        presenter.setChef(chef.getUserId());
        assertEquals(presenter.getChef(),chef);
    }
    @Test
    public void getOrder(){
        Order order = orderDAO.find(3);
        presenter.setOrder(order.getId());
        assertEquals(presenter.getOrder(),order);
    }
    @Test
    public void chooseLayoutCustomer(){
        presenter.chooseLayout(true);
        assertEquals(false,view.isSetCompletedButtonIsVisible());
    }

    @Test
    public void chooseLayoutChef(){
        presenter.chooseLayout(false);
        assertEquals(true,view.isSetCompletedButtonIsVisible());
    }


}