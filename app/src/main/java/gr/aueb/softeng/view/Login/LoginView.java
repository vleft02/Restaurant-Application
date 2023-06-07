package gr.aueb.softeng.view.Login;

import android.app.AlertDialog;
import android.content.DialogInterface;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.view.View;

public interface LoginView extends View {
    String ExtractUsername();
    String ExtractPassword();
    void showCustomerFoundMessage(int id);
    void showChefFoundMessage(int id);
    void showOwnerFoundMessage(int id);
    void signup();
    void signupPersonel();
    void signupOwner();
    void showErrorMessage(String title, String message);
}
