package gr.aueb.softeng.view.Login;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;

public class LoginPresenter {
    private LoginView view;
    private ChefDAO chefDAO;
    private CustomerDAO custDAO;
    private OwnerDAO ownerDAO;
    private UserDAO userDAO;

    public LoginPresenter(ChefDAO chefDAO, CustomerDAO custDAO, OwnerDAO ownerDAO,UserDAO userDAO)
    {
        this.chefDAO = chefDAO;
        this.custDAO = custDAO;
        this.ownerDAO = ownerDAO;
        this.userDAO = userDAO;
    }
    private String inputUsername;
    private String inputPassword;
    public void setView(LoginView view) {
        this.view = view;
    }

    public ChefDAO getChefDao(){return this.chefDAO;}
    public CustomerDAO getCustomerDao(){return this.custDAO;}
    public OwnerDAO getOwnerDao(){return this.ownerDAO;}
    public UserDAO getUserDAO(){return this.userDAO;}



    public void authenticate() {
        inputUsername = view.ExtractUsername();
        inputPassword = view.ExtractPassword();
        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία.");
        }else if (custDAO.find(inputUsername, inputPassword) != null) {
            view.showErrorMessage("ΒΡΕΘΗΚΕ", " Ο χρηστης βρεθηκε");
            view.redirectToCustomerPage();
        }
        else if (chefDAO.find(inputUsername, inputPassword) != null) {
            view.showErrorMessage("ΒΡΕΘΗΚΕ", " Ο χρηστης βρεθηκε");
            view.redirectToChefHomePage();
        }
        else if (ownerDAO.find(inputUsername, inputPassword) != null) {
            view.showErrorMessage("ΒΡΕΘΗΚΕ", " Ο χρηστης βρεθηκε");
            view.redirectToOwnerHomePage();
        }
        else{
            view.showErrorMessage("ΛΑΘΟΣ ΣΤΟΙΧΕΙΑ", "Τα στοιχεία που εισάγατε δεν ήταν σωστά. Προσπαθήστε ξανά");
        }
    }
    public void onSignup(){
        view.signup();
    }

    public void onSignupPersonel() {view.signupPersonel();
    }
    public void onSignupOwner(){view.signupOwner();}
}
