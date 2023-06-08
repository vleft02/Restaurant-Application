package gr.aueb.softeng.view.Customer.OrderLineCart;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;

public class OrderLineCartPresenterTest {

    OrderLineCartPresenter presenter;

    OrderLineCartViewStub view;

    OrderDAO orderDAO;


    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new OrderLineCartViewStub();
        orderDAO = new OrderDAOmemory();
        presenter = new OrderLineCartPresenter();
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }

    @Test
    public void setView() {
        OrderLineCartView testView = new OrderLineCartViewStub();
        presenter.setView(testView);
        assertEquals(testView, presenter.getView());
    }

    @Test
    public void getView() {
        assertEquals(view,presenter.getView());
    }

    @Test
    public void setOrder() {
        presenter.setOrder(orderDAO.find(1).getOrderLines());
        assertEquals(3 ,orderDAO.find(1).getOrderLines().size());
        assertEquals(10 ,presenter.getOrderLines().get(0).getQuantity());
        assertEquals("patates",presenter.getOrderLines().get(0).getDish().getDishName());
    }

    @Test
    public void getOrderLinesWithoutSet() {
        assertTrue(presenter.getOrderLines().isEmpty());
    }

    @Test
    public void getOrderLines() {
        presenter.setOrder(orderDAO.find(1).getOrderLines());
        assertEquals(orderDAO.find(1).getOrderLines(),presenter.getOrderLines());
    }

    @Test
    public void onDeleteOrderLine() {
        presenter.setOrder(orderDAO.find(1).getOrderLines());
        assertEquals(3 ,presenter.getOrderLines().size());
        assertEquals(10 ,presenter.getOrderLines().get(0).getQuantity());
        assertEquals("patates",presenter.getOrderLines().get(0).getDish().getDishName());

        presenter.onDeleteOrderLine(presenter.getOrderLines().get(0));
        assertEquals(2,presenter.getOrderLines().size());
        assertEquals(3 ,presenter.getOrderLines().get(0).getQuantity());
        assertEquals("krema",presenter.getOrderLines().get(0).getDish().getDishName());
    }
}