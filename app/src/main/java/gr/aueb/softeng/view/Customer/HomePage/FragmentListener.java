package gr.aueb.softeng.view.Customer.HomePage;

import java.io.Serializable;

public interface FragmentListener extends Serializable {


    CustomerHomePageViewModel getViewModel();

    void changeLayout();

    void onCancel();

    void onPlaceOrder();
}
