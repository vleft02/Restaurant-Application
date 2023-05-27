package gr.aueb.softeng.view.Login;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.view.SignUp.SignUpPresenter;

public class LoginPresenter {
    private LoginView view;
    private ChefDAO chefDAO;
    private CustomerDAO custDAO;
    private OwnerDAO ownerDAO;
    private UserDAO userDAO;

    private String inputUsername;
    private String inputPassword;

    public LoginPresenter(){}

    public void setView(LoginView view) {
        this.view = view;
    }

    public ChefDAO getChefDao(){return this.chefDAO;}
    public CustomerDAO getCustomerDao(){return this.custDAO;}
    public OwnerDAO getOwnerDao(){return this.ownerDAO;}
    public UserDAO getUserDAO(){return this.userDAO;}

    public void setChefDAO(ChefDAO chefDAO) {
        this.chefDAO = chefDAO;
    }
    public void setCustDao(CustomerDAO custDAO){
        this.custDAO = custDAO;
    }
    public void setOwnerDAO(OwnerDAO ownerDAO){
        this.ownerDAO = ownerDAO;
    }
    public void setUserDAO(UserDAO userDAO){this.userDAO= userDAO;}

    public void onExtractUsername(){
       inputUsername= view.ExtractUsername();
    }
    public void onExtractPassword(){
        inputPassword = view.ExtractPassword();
    }

    public void authenticate() {
        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία.");
        }else {
            if (userDAO.find(inputUsername, inputPassword) != null) { // an != null tote iparxei o xristis
                view.showErrorMessage("ΒΡΕΘΗΚΕ", " Ο χρηστης βρεθηκε");
            //    view.redirectToCustomerPage();
           //     view.redirectToChefPage();
           //     view.redirectToOwnerPage();
            }else{
                view.showErrorMessage("ΛΑΘΟΣ ΣΤΟΙΧΕΙΑ", "βαλε σωστα στοιχεια");
            }
        }
    }
    public void onSignup(){
        view.signup(userDAO,custDAO);
    }

    public void onSignupPersonel() {view.signupPersonel();
    }
    public void onSignupOwner(){view.signupOwner();}
}
