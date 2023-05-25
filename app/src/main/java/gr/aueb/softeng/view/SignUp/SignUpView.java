package gr.aueb.softeng.view.SignUp;

import java.util.HashMap;

public interface SignUpView {
    HashMap<String,String> getDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
