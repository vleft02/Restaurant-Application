package gr.aueb.softeng.view.Customer.PlaceOrder;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;

public class PlaceOrderViewModel extends ViewModel {

    PlaceOrderPresenter presenter;

    public PlaceOrderViewModel(RestaurantDAO restaurantDAO, CustomerDAO customerDAO)
    {
        presenter = new PlaceOrderPresenter(restaurantDAO,customerDAO);
    }

    public PlaceOrderPresenter getPresenter() {
        return presenter;
    }
}
