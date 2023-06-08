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

    public LoginPresenter(ChefDAO chefDAO, CustomerDAO custDAO, OwnerDAO ownerDAO,UserDAO userDAO)
    {
        this.chefDAO = chefDAO;
        this.custDAO = custDAO;
        this.ownerDAO = ownerDAO;
        this.userDAO = userDAO;
    }

    public LoginView getView() {
        return view;
    }

    private String inputUsername;
    private String inputPassword;
    public void setView(LoginView view) {
        this.view = view;
    }

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
    public void onSignup(){
        view.signup();
    }

    public void onSignupPersonel() {view.signupPersonel();}
    public void onSignupOwner(){view.signupOwner();}
}
