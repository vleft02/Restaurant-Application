package gr.aueb.softeng.view.SignUp.CustomerSignUp;

import java.util.HashMap;

public interface CustomerSignUpView {
    HashMap<String,String> getDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
