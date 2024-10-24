package gr.aueb.softeng.view.SignUp.SignUpOwner;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;
import gr.aueb.softeng.view.SignUp.SignUpOwner.SignUpOwnerPresenter;
import gr.aueb.softeng.view.SignUp.SignUpOwner.SignUpOwnerView;

public class SignUpOwnerPresenterTest {
    SignUpOwnerPresenter presenter;

    SignUpOwnerViewStub view;

    OwnerDAO ownerDAO;

    UserDAO userDAO;
    @Before
    public void setUp()
    {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new SignUpOwnerViewStub();

        ownerDAO = new OwnerDAOmemory();
        userDAO = new UserDAOmemory();

        presenter = new SignUpOwnerPresenter(userDAO,ownerDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }


    @Test
    public void setView() {
        SignUpOwnerView testView = new SignUpOwnerViewStub();
        presenter.setView(testView);
        assertEquals(testView,presenter.getView());
    }

    @Test
    public void getView() {
        assertEquals(view,presenter.getView());
    }

    @Test
    public void onCreateOwnerAccountSuccessful() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(0,view.getErrorCount());
        assertEquals("Account Created Successfully",view.getSuccessMessage());
        assertNotEquals(null, ownerDAO.find("adrekos"));
        assertNotEquals(null, userDAO.find("adrekos"));
        ownerDAO.delete(ownerDAO.find("adrekos"));
        userDAO.delete(userDAO.find("adrekos"));

    }

    @Test
    public void onCreateOwnerAccountEmptyField() {
        //we leave the name field empty
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε όλα τα πεδία!.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }
    @Test
    public void onCreateOwnerAccountInvalidUsername() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adr");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε 4 έως 15 χαρακτήρες στο Username.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }
    @Test
    public void onCreateOwnerAccountInvalidEmail() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrkmail");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε σωστά το email.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }
    @Test
    public void onCreateOwnerAccountInvalidTelephone() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("21056");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }
    @Test
    public void onCreateOwnerAccountInvalidIban() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο iban.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }
    @Test
    public void onCreateOwnerAccountInvalidPassword() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("12345");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Ο κωδικός θα πρέπει να αποτελείται απο 8 ψηφία και πάνω.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }
    @Test
    public void onCreateOwnerAccountInvalidTin() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("1234567");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο αφμ με 9 ψηφία.",view.getErrorMessage());
        assertEquals(null, ownerDAO.find("adrekos"));
        assertEquals(null, userDAO.find("adrekos"));

    }

    @Test
    public void onCreateOwnerAccountExistingUsername() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("owner1");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setIban("12345678901234567890");
        view.setTin("123456789");
        view.setPassword("123456789");
        presenter.onCreateOwnerAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Υπάρχει ήδη λογαριασμός με αυτο το username \n Συμπληρώστε νέα στοιχεία!",view.getErrorMessage());

    }

    @Test
    public void onBack() {
        presenter.onBack();
        assertEquals(1,view.getGoBackIsPressed());
    }
}