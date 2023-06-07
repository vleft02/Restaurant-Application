package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import java.util.HashMap;

public interface SignUpCustomerView {
    HashMap<String,String> getDetails();
    void showErrorMessage(String title, String message);
    void goBack();
    void showAccountCreatedMessage();
}
