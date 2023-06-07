package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class SignUpCustomerPresenterTest {
    SignUpCustomerPresenter presenter;
    SignUpCustomerViewStub view;
    private CustomerDAO custDAO;
    private UserDAO userDAO;
    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new SignUpCustomerViewStub();

        custDAO = new CustomerDAOmemory();
        userDAO = new UserDAOmemory();

        presenter = new SignUpCustomerPresenter(userDAO,custDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setView() {
        SignUpCustomerViewStub testView = new SignUpCustomerViewStub();
        presenter.setView(testView);
        assertEquals(testView,presenter.getView());
    }

    @Test
    public void getView()
    {
        assertEquals(view,presenter.getView());
    }

    @Test
    public void onCreateAccountSuccesfull() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(0,view.getErrorCount());
        assertEquals("Account created successfully",view.getSuccessMessage());
        assertNotEquals(null, custDAO.find("adrekos"));
    }

    @Test
    public void onCreateAccountEmptyField() {
        //name and telephone are not set so they remain ""
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε όλα τα πεδία!.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));

        //name is still ""
        view.setTelephone("2105673456");
        presenter.onCreateAccount();
        assertEquals(2,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε όλα τα πεδία!.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));


    }
    @Test
    public void onCreateAccountInvalidUsername() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adr");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε 4 έως 15 χαρακτήρες στο Username.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adr"));
    }
    @Test
    public void onCreateAccountInvalidEmail() {
        //email is invalid if it doesn't contain'@' and ".com" or ".gr"
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrkgmail");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε σωστά το email.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));
    }
    @Test
    public void onCreateAccountInvalidTelephone() {
        //greek phone numbers have exactly 10 digits
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("21056736");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));
    }

    @Test
    public void onCreateAccountInvalidCardNumber() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("123456789101");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο αριθμό κάρτας με 16 ψηφία",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));
    }
    @Test
    public void onCreateAccountInvalidPassword() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("12345");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Ο κωδικός θα πρέπει να αποτελείται απο 8 ψηφία και πάνω.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));
    }
    @Test
    public void onCreateAccountInvalidCVV() {
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("adrekos");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("12323");
        view.setPassword("123456789");
        presenter.onCreateAccount();
        assertEquals(1,view.getErrorCount());
        assertEquals("Σφάλμα!",view.getErrorTitle());
        assertEquals("Συμπληρώστε έγκυρο cvv.",view.getErrorMessage());
        assertEquals(null, custDAO.find("adrekos"));
    }
    @Test
    public void onCreateAccountExistingUsername() {
        //customer with username kostas123 is already signed up in the initializer
        view.setName("Adreas");
        view.setSurname("Kostadopoulos");
        view.setUsername("kostas123");
        view.setEmail("adrk@gmail.com");
        view.setTelephone("2105673456");
        view.setCardNumber("1234567891011121");
        view.setCardHolderName("Adreas Kostadopoulos");
        view.setCvv("123");
        view.setPassword("123456789");
        presenter.onCreateAccount();
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