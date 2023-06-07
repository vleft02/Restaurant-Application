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
        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία.");
        }else if (custDAO.find(inputUsername, inputPassword) != null) {
            view.showCustomerFoundMessage(custDAO.find(inputUsername,inputPassword).getUserId());
        }
        else if (chefDAO.find(inputUsername, inputPassword) != null) {
            view.showChefFoundMessage(chefDAO.find(inputUsername,inputPassword).getUserId());
        }
        else if (ownerDAO.find(inputUsername, inputPassword) != null) {
            view.showOwnerFoundMessage(ownerDAO.find(inputUsername,inputPassword).getUserId());
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
