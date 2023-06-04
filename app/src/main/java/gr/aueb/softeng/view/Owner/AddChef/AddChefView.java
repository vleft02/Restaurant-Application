package gr.aueb.softeng.view.Owner.AddChef;

import java.util.HashMap;

public interface AddChefView {
    HashMap<String,String> getChefDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
