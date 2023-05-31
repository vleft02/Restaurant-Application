package gr.aueb.softeng.view.Owner.AddRestaurant;

import java.util.HashMap;

public interface AddRestaurantView {
    HashMap<String,String>  getRestDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
