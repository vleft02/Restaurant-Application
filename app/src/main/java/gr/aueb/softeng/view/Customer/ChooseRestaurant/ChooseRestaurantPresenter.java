package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import java.util.ArrayList;

import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Restaurant;

public class ChooseRestaurantPresenter {

    ChooseRestaurantView view;
    RestaurantDAO restaurantDAO;

    ArrayList<Restaurant> restaurants;

    public ChooseRestaurantPresenter(RestaurantDAO restaurantDAO)
    {
        this.restaurantDAO = restaurantDAO;
        restaurants = new ArrayList<>();
    }


    public void setView(ChooseRestaurantView view) {
        this.view = view;
    }

    public void setRestaurantList() {
        restaurants = (ArrayList<Restaurant>) restaurantDAO.findAll();
    }

    public void onChangeLayout() {
        view.changeLayout();

    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurants;
    }
}
