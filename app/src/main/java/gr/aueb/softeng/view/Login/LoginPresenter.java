package gr.aueb.softeng.view.Login;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;

public class LoginPresenter {
    private LoginView view;
    private ChefDAO chefDAO;
    private CustomerDAO custDAO;
    private OwnerDAO ownerDAO;

    private String inputUsername;
    private String inputPassword;

    public LoginPresenter(){}

    public void setView(LoginView view) {
        this.view = view;
    }

    public ChefDAO getChefDao(){return this.chefDAO;}
    public CustomerDAO getCustomerDao(){return this.custDAO;}
    public OwnerDAO getOwnerDao(){return this.ownerDAO;}

    public void setChefDAO(ChefDAO chefDAO) {
        this.chefDAO = chefDAO;
    }
    public void setCustDao(CustomerDAO custDAO){
        this.custDAO = custDAO;
    }
    public void setOwnerDAO(OwnerDAO ownerDAO){
        this.ownerDAO = ownerDAO;
    }

    public void onExtractUsername(){
       inputUsername= view.ExtractUsername();
    }
    public void onExtractPassword(){
        inputPassword = view.ExtractPassword();
    }

    public void authenticate() {
        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία.");
        }
    }
    public void onSignup(){
        view.signup();
    }
}
