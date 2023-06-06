package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import static org.junit.Assert.*;

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
import gr.aueb.softeng.view.SignUp.SignUpCustomer.ChefOrderDetailsViewStub;

public class ChefOrderDetailsPresenterTest {
    private ChefOrderDetailsPresenter presenter;
    private ChefOrderDetailsViewStub view;
    private ChefDAO chefDAO;
    private OrderDAO orderDAO;
    private Chef chef;
    private Order order;

    @Before
    public void setUp() {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new ChefOrderDetailsViewStub();
        chefDAO = new ChefDAOmemory();
        orderDAO = new OrderDAOmemory();
        presenter = new ChefOrderDetailsPresenter(chefDAO, orderDAO);
        presenter.setView(view);

    }

    @Test
    public void testSetOrderLineList() {
        ArrayList<OrderLine> orderLineList = new ArrayList<>();
        order.setOrderLines(orderLineList);

        presenter.setOrder(1);
        presenter.setOrderLineList();

        assertEquals(orderLineList, presenter.getOrderLineList());
    }

    @Test
    public void testSetChef() {
        presenter.setChef(1);

        assertEquals(chef, presenter.getChefDAO().find(1));
    }

    @Test
    public void testSetOrder() {
        presenter.setOrder(1);

        assertEquals(order, presenter.getOrderDAO().find(1));
    }

    @Test
    public void testSetOrderDetails() {
        presenter.setOrder(1);
        order.setId(1);
        order.setOrderState(Order.State.IN_PROGRESS);
        order.setTableNumber(5);
        // Set the date

        presenter.setOrderDetails();

        assertEquals("1", view.getOrderId());
        assertEquals(Order.State.IN_PROGRESS.toString(), view.getOrderState());
        assertEquals("5", view.getTableNumber());
        // Verify the formatted date
    }

    @Test
    public void testOnCompleted() {
        presenter.setOrder(1);
        order.setOrderState(Order.State.IN_PROGRESS);

        presenter.onCompleted();

        assertEquals(Order.State.COMPLETED, order.getOrderState());
        assertEquals(Order.State.COMPLETED.toString(), view.getOrderState());
    }

    @Test
    public void testOnCompletedCancelledOrder() {
        presenter.setOrder(1);
        order.setOrderState(Order.State.CANCELLED);

        presenter.onCompleted();

        assertEquals(Order.State.CANCELLED, order.getOrderState());
        assertEquals(Order.State.CANCELLED.toString(), view.getOrderState());
    }

    @Test
    public void testOnCompletedCompletedOrder() {
        presenter.setOrder(1);
        order.setOrderState(Order.State.COMPLETED);

        presenter.onCompleted();

        assertEquals(Order.State.COMPLETED, order.getOrderState());
        assertEquals(Order.State.COMPLETED.toString(), view.getOrderState());
    }

    @Test
    public void testOnBack() {
        presenter.OnBack();

        assertEquals(true, view.isGoBackPressed());
    }
}