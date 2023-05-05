import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Setting up the customers");
        customer = new Customer("john23", "john", "pappas", "694", "pap@gmail.com", "123456789123", 0, "123", "johnPap", "322", 50.0);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        customer = null;
        assertNull(customer);
        }


    @org.junit.jupiter.api.Test
    void transaction() {
        System.out.println("Running :Transaction");
        customer.transaction(35);
        assertEquals(15,customer.getBalance());
    }

    @org.junit.jupiter.api.Test
    void topUp() {
    }
}