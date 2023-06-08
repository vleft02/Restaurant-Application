package gr.aueb.softeng.view.Owner.AddRestaurant;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class AddRestaurantPresenterTest {
    AddRestaurantPresenter presenter;
    AddRestaurantViewStub view;
    private RestaurantDAO restDAO;

    private OwnerDAO ownerDAO;

    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AddRestaurantViewStub();

        ownerDAO= new OwnerDAOmemory();
        restDAO = new RestaurantDAOmemory();

        presenter = new AddRestaurantPresenter(ownerDAO, restDAO);
        presenter.setView(view);
        presenter.setOwner(ownerDAO.find("owner1").getUserId());
    }
    @After
    public void tearDown() throws Exception {
        presenter=null;
        view=null;
    }

    @Test
    public void setOwner() {
        Owner own = ownerDAO.find("owner1");
        presenter.setOwner(own.getUserId());
        assertEquals(presenter.getOwner(),own);
    }

    @Test
    public void setView() {
        AddRestaurantView testView = new AddRestaurantViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }

    @Test
    public void addWithEmptyNameRestaurant() {
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("15");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Συμπληρώστε όλα τα πεδία!.", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }

    @Test
    public void addWithWrongName() {
        view.setName("piz");
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("15");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Συμπληρώστε 4 έως 15 χαρακτήρες στο Restaurant Name.", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addWithWrongTelephone() {
        view.setName("pizzariaa");
        view.setTelephone("1234");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("15");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addWithWrongStreetName() {
        view.setName("pizzariaaaaa");
        view.setTelephone("1234567890");
        view.setStreetName("gi");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("15");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Συμπληρώστε απο 4 και πάνω χαρακτήρες στο Street Name", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addWithWrongStreetNumber() {
        view.setName("pizzariaa");
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("0");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("15");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Συμπληρώστε απο 1 ψηφίο και πάνω στο Street Number", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addWithWrongZc() {
        view.setName("pizzariaa");
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1");
        view.setCity("iwannina");
        view.setTotalTables("15");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Συμπληρώστε απο 2 και πάνω ψηφία στον Ταχυδρομικό κώδικα(ZC).", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addWithWrongTableNum(){
        view.setName("pizzariaa");
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("0");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Θα πρέπει να έχετε τουλάχιστον 1 τραπέζι και πάνω για να δημιουργηθεί το εστιατόριο", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addRestaurantWithTheSameName() {
        view.setName("Taverna"); // it already exists on the initializer
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("10");

        presenter.onCreateRestaurant();
        assertEquals("Σφάλμα!", view.getErrorTitle());
        assertEquals("Υπάρχει ήδη εστιατόριο με ίδιο όνομα \n Συμπληρώστε νέα στοιχεία!", view.getErrorMessage());
        assertEquals(1, view.getErrorCount());
    }
    @Test
    public void addRestaurantSuccessfully() {
        view.setName("pizzariaa"); // it already exists on the initializer
        view.setTelephone("1234567890");
        view.setStreetName("giannikosta");
        view.setStreetNumber("1234");
        view.setZc("1234");
        view.setCity("iwannina");
        view.setTotalTables("10");
        presenter.onCreateRestaurant();
        assertEquals(0, view.getErrorCount());
        assertEquals(view.getSuccessMessage(), "the restaurant was successfully created");
    }

    @Test
    public void onBack() {
        view.goBack();
        assertEquals(1,view.getGoBackPressed());
    }

    @Test
    public void getView(){
        assertEquals(view,presenter.getView());
    }

    @Test
    public void getOwner(){
        Owner own= ownerDAO.find("owner1");
        presenter.setOwner(own.getUserId());
        assertEquals(own,presenter.getOwner());
    }
}