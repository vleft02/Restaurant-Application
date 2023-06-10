package gr.aueb.softeng.view.Login;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Owner;

public class LoginPresenter {
    private LoginView view;
    private ChefDAO chefDAO;
    private CustomerDAO custDAO;
    private OwnerDAO ownerDAO;
    private UserDAO userDAO;
    /**
     * Αρχικοποιεί το user dao , το customer dao, το chef dao και το owner dao για να μπορούμε να αποθηκεύσουμε και ανακτήσουμε απο την
     * στατική μας λίστα τους πελάτες, τους μάγειρες ,τους ιδιοκτήτες και τους users.
     * @param userDAO το Inastance του DAO
     * @param custDAO το Instance του DAO
     * @param chefDAO το Instance του DAO
     * @param ownerDAO το nstance του DAO
     */
    public LoginPresenter(ChefDAO chefDAO, CustomerDAO custDAO, OwnerDAO ownerDAO,UserDAO userDAO)
    {
        this.chefDAO = chefDAO;
        this.custDAO = custDAO;
        this.ownerDAO = ownerDAO;
        this.userDAO = userDAO;
    }
    /**
     * Επιστρέφει το αντικείμενο view που δημιουργήσαμε επάνω
     * @return το Instance του αντικειμένου
     */
    public LoginView getView() {
        return view;
    }

    private String inputUsername;
    private String inputPassword;
    /**
     * Αρχικοποιεί το view απο το οποίο θα χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Instance του view
     */
    public void setView(LoginView view) {
        this.view = view;
    }

    /**
     * Η μέθοδος αυτή αρχικά ελέγχει σε ποια κατηγορία ανήκει ο χρήστης που πάτησε το κουμπί της σύνδεσης , ή και
     * εάν δεν ανήκει σε καμία και έχει λανθασμένα στοιχεία , εμφανίζει το κατάληλλο μήνυμα ειδοποίησης στην οθόνη
     * και καλεί το σωστό μήνυμα επιτυχίας ανάλογα τον χρήστη
     */
    public void authenticate() {
        inputUsername = view.ExtractUsername();
        inputPassword = view.ExtractPassword();

        Customer cust = custDAO.find(inputUsername, inputPassword);
        Chef chef= chefDAO.find(inputUsername, inputPassword);
        Owner owner = ownerDAO.find(inputUsername, inputPassword);

        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία.");
        }else if (cust != null) {
            view.showCustomerFoundMessage(cust.getUserId());
        }
        else if (chef != null) {
            view.showChefFoundMessage(chef.getUserId());
        }
        else if (owner != null) {
            view.showOwnerFoundMessage(owner.getUserId());
        }
        else{
            view.showErrorMessage("Λάθος στοιχεία", "Τα στοιχεία που εισάγατε δεν ήταν σωστά. Προσπαθήστε ξανά");
        }
    }

    /**
     * Καλείται όταν πατηθεί να γίνει sign up για customer
     */
    public void onSignup(){
        view.signup();
    }

    /**
     * Καλείται όταν πατηθεί να γίνει sign up για μάγειρα
     */
    public void onSignupPersonel() {view.signupPersonel();}

    /**
     * Καλείται όταν πατηθεί να γίνει sign up για ιδιοκτήτη
     */
    public void onSignupOwner(){view.signupOwner();}
}
