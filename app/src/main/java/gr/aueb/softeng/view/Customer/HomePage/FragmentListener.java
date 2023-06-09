package gr.aueb.softeng.view.Customer.HomePage;

import java.io.Serializable;

public interface FragmentListener extends Serializable {


    CustomerHomePageViewModel getViewModel();

    void redirectToOrderDetails();

    void redirectToOrderDetails(int id);
}
