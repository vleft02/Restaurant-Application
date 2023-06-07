package gr.aueb.softeng.view.Login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;
import gr.aueb.softeng.view.Chef.ChefOrderDetails.ChefOrderDetailsPresenter;
import gr.aueb.softeng.view.Chef.ChefOrderDetails.ChefOrderDetailsViewStub;

public class LoginPresenterTest {

    LoginPresenter presenter;
    LoginViewStub view;

    private ChefDAO chefDAO;
    private CustomerDAO custDAO;
    private OwnerDAO ownerDAO;
    private UserDAO userDAO;
    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new LoginViewStub();

        chefDAO= new ChefDAOmemory();
        custDAO = new CustomerDAOmemory();
        ownerDAO = new OwnerDAOmemory();
        userDAO = new UserDAOmemory();

        presenter = new LoginPresenter(chefDAO,custDAO,ownerDAO,userDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        presenter=null;
        view=null;
    }

    @Test
    public void setView() {
        LoginView testView = new LoginViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }

    @Test
    public void authenticateWithEmptyFields() {
        //no view.setUsername means username == "" && password == ""
        presenter.authenticate();
        assertEquals(view.getErrorTitle(),"Σφάλμα!");
        assertEquals(view.getErrorMessage(),"Συμπληρώστε όλα τα πεδία.");
        assertEquals(view.getErrorCount(),1);
    }
    @Test
    public void authenticateWithEmptyUsername() {
        //no view.setUsername means username == "" && password == ""
        view.setPassword("1234567890");
        presenter.authenticate();
        assertEquals(view.getErrorTitle(),"Σφάλμα!");
        assertEquals(view.getErrorMessage(),"Συμπληρώστε όλα τα πεδία.");
        assertEquals(view.getErrorCount(),1);
    }
    @Test
    public void authenticateWithEmptyPassword() {
        //no view.setUsername means username == "" && password == ""
        view.setUsername("kostas");
        presenter.authenticate();
        assertEquals(view.getErrorTitle(),"Σφάλμα!");
        assertEquals(view.getErrorMessage(),"Συμπληρώστε όλα τα πεδία.");
        assertEquals(view.getErrorCount(),1);
    }

    @Test
    public void authenticateWithCustomer() {
        //existing customer from memory initializer userName == "testCustomer", password == "123456789" and id == 2
        view.setUsername("testCustomer");
        view.setPassword("123456789");
        presenter.authenticate();
        assertEquals(0,view.getErrorCount());
        assertEquals(view.getSuccessMessage(),"Redirecting to Customer with id: 2");

    }

    @Test
    public void authenticateWithOwner() {
        //existing owner from memory initializer userName == "owner1", password == "123456789" and id == 6
        view.setUsername("owner1");
        view.setPassword("123456789");
        presenter.authenticate();
        assertEquals(0,view.getErrorCount());
        assertEquals(view.getSuccessMessage(),"Redirecting to Owner with id: 6");

    }

    @Test
    public void authenticateWithChef() {
        //existing chef from memory initializer userName == "platias", password == "123456789" and id == 1
        view.setUsername("platias");
        view.setPassword("123456789");
        presenter.authenticate();
        assertEquals(0,view.getErrorCount());
        assertEquals(view.getSuccessMessage(),"Redirecting to Chef with id: 1");
    }


    @Test
    public void authenticateWrongDetails() {
        view.setUsername("testCustomer");
        view.setPassword("123456");
        presenter.authenticate();
        assertEquals("Λάθος στοιχεία",view.getErrorTitle());
        assertEquals("Τα στοιχεία που εισάγατε δεν ήταν σωστά. Προσπαθήστε ξανά",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());
    }

    @Test
    public void onSignup() {
        presenter.onSignup();
        assertEquals(1,view.getSignUpPressed());
    }

    @Test
    public void onSignupPersonel() {
        presenter.onSignupPersonel();
        assertEquals(1,view.getSignUpPersonelPressed());
    }

    @Test
    public void onSignupOwner() {
        presenter.onSignupOwner();
        assertEquals(1,view.getSignUpOwnerPressed());
    }
}