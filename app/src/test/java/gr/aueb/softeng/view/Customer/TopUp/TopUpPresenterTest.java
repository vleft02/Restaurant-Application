package gr.aueb.softeng.view.Customer.TopUp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;

public class TopUpPresenterTest {
    Customer customer;

    TopUpPresenter presenter;

    TopUpViewStub view;

    CustomerDAO customerDAO;

    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new TopUpViewStub();

        customerDAO = new CustomerDAOmemory();

        presenter = new TopUpPresenter(customerDAO);
        presenter.setView(view);
        /*customer = customerDAO.find("testCustomer");*/
        view.setCustomerId(customerDAO.find("testCustomer").getUserId() );

    }

    @After
    public void tearDown() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
/*        customer = customerDAO.find("testCustomer");*/
    }

    @Test
    public void setView() {
        TopUpView testView = new TopUpViewStub();
        presenter.setView(testView);
        assertEquals(testView,presenter.getView());
    }

    @Test
    public void getView() {
        assertEquals(view,presenter.getView());
    }

    @Test
    public void setCustomer() {
        presenter.setCustomer();
        assertEquals(customerDAO.find("testCustomer"), presenter.getCustomer());
    }



    @Test
    public void setLayoutCustomerNull() {
        presenter.setLayout();
        assertEquals("ERROR", view.getBalance());
    }


    @Test
    public void setLayoutNormal() {
        presenter.setCustomer();
        presenter.setLayout();
        assertEquals("0.00 €", view.getBalance());
        customerDAO.find(view.getCustomerId()).topUp(10.0);
        presenter.setLayout();
        assertEquals("10.00 €",view.getBalance());
        customerDAO.find(view.getCustomerId()).transaction(10.0);
    }

    @Test
    public void onTopUp() {
        presenter.setCustomer();
        presenter.onTopUp(10.0);
        assertEquals("10.00 €",view.getBalance());
        assertEquals(10.00 ,customerDAO.find(view.getCustomerId()).getBalance(),0.00);
    }
}