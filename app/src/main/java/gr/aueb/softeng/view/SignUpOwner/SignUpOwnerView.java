package gr.aueb.softeng.view.SignUpOwner;

import java.util.HashMap;

public interface SignUpOwnerView {
    HashMap<String,String> getOwnerDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
