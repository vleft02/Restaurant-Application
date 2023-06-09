package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

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

    public ChooseRestaurantView getView() {
        return view;
    }

    public void setRestaurantList() {
        restaurants = (ArrayList<Restaurant>) restaurantDAO.findAll();
    }
    /**
     *  Ελεγχουμε εαν η λίστα με τα εστιατόρια είναι άδεια
     *  για να τα προβάλουμε ή να δείξουμε μήνυμα οτι δεν υπάρχουν εστιατόρια
     */
    public void onChangeLayout() {
        if (restaurants.isEmpty()) {
            view.ShowNoRestaurants();
        }
        else {
            view.ShowRestaurants();
        }
    }
    public void onBack(){
        view.goBack();
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurants;
    }
}
