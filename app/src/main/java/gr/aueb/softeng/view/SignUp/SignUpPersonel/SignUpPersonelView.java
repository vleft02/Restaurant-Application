package gr.aueb.softeng.view.SignUp.SignUpPersonel;

import java.util.HashMap;

public interface SignUpPersonelView {
    HashMap<String,String> getChefDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
