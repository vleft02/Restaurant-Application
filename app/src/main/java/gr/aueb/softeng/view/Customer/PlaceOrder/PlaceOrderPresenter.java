package gr.aueb.softeng.view.Customer.PlaceOrder;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;

public class PlaceOrderPresenter {
    PlaceOrderView view;

    RestaurantDAO restaurantDAO;

    CustomerDAO customerDAO;

    public PlaceOrderPresenter(RestaurantDAO restaurantDAO,CustomerDAO customerDAO)
    {
        this.restaurantDAO = restaurantDAO;
        this.customerDAO = customerDAO;
    }

    public void setView(PlaceOrderView view) {
        this.view = view;
    }
}
