package gr.aueb.softeng.view.Owner.AddChef;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;
import gr.aueb.softeng.view.Login.LoginPresenter;
import gr.aueb.softeng.view.Login.LoginView;
import gr.aueb.softeng.view.Login.LoginViewStub;

public class AddChefPresenterTest {
    AddChefPresenter presenter;
    AddChefViewStub view;
    private RestaurantDAO restDAO;

    private ChefDAO chefDAO;

    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AddChefViewStub();

        chefDAO= new ChefDAOmemory();
        restDAO = new RestaurantDAOmemory();

        presenter = new AddChefPresenter(restDAO,chefDAO);
        presenter.setView(view);
        presenter.setRestaurant(restDAO.find("Kafeteria").getId());
    }
    @After
    public void tearDown() throws Exception {
        presenter=null;
        view=null;
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }

    @Test
    public void setView() {
        AddChefView testView = new AddChefViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }

    @Test
    public void setRestaurant() {
        Restaurant rest = restDAO.find("Kafeteria");
        presenter.setRestaurant(rest.getId());
        assertEquals(presenter.getRestaurant(),rest);
    }

    @Test
    public void addWithEmptyNameChefAccount() {
        view.setSurname("pappas");
        view.setUsername("xox");
        view.setTelephone("1234567890");
        view.setIban("123456789");
        view.setTin("123456");
        presenter.onAddChefAccount();
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε όλα τα πεδία!.",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());
    }
    @Test
    public void addWithWrongUsername(){
        view.setName("kostas");
        view.setSurname("pappas");
        view.setUsername("xox");
        view.setTelephone("1234567890");
        view.setIban("123456789");
        view.setTin("123456");
        presenter.onAddChefAccount();
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε 4 έως 15 χαρακτήρες στο Username.",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());
    }
    @Test
    public void addWithWrongTelephone(){
        view.setName("kostas");
        view.setSurname("pappas");
        view.setUsername("kostas41");
        view.setTelephone("123456");
        view.setIban("123456789");
        view.setTin("123456");
        presenter.onAddChefAccount();
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());
    }
    @Test
    public void addWithWrongIban(){
        view.setName("kostas");
        view.setSurname("pappas");
        view.setUsername("kostas41");
        view.setTelephone("1234567890");
        view.setIban("123");
        view.setTin("123456");
        presenter.onAddChefAccount();
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο iban.",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());

    }
    @Test
    public void addWithWrongTin(){
        view.setName("kostas");
        view.setSurname("pappas");
        view.setUsername("kostas41");
        view.setTelephone("1234567890");
        view.setIban("123456789");
        view.setTin("12");
        presenter.onAddChefAccount();
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο tin.",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());
    }
    @Test
    public void addNonExistantChef(){
        view.setName("kostas");
        view.setSurname("pappas");
        view.setUsername("kostas41");
        view.setTelephone("1234567890");
        view.setIban("123456789");
        view.setTin("1234567");
        presenter.onAddChefAccount();
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Τα στοιχεία που δώσατε δεν αντιστοιχούν σε κάποιον μάγειρα της εφαρμογής , \n Ξαναδοκιμάστε!",view.getErrorMessage());
        assertEquals(1,view.getErrorCount());
    }
    @Test
    public void addExistingChef(){
        view.setUsername("platias");
        view.setName("kwnnn");
        view.setSurname("papapap");
        view.setTelephone("101010101010");
        view.setIban("12121212121");
        view.setTin("12122211");
        presenter.onAddChefAccount();
        assertEquals(0,view.getErrorCount());
        assertEquals(view.getSuccessMessage(),"chef with id was successfully added");
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
    public void getRestaurant(){
        presenter.setRestaurant(restDAO.find("Kafeteria").getId());
        Restaurant rest= restDAO.find("Kafeteria");
        assertEquals(rest,presenter.getRestaurant());
    }
}