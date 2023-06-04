package gr.aueb.softeng.view.Owner.HomePage;



import java.util.ArrayList;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public class OwnerHomePagePresenter {

    OwnerHomePageView view;

    private ArrayList<Restaurant> restaurantList;
    private OwnerDAO ownerDAO;
    private RestaurantDAO restaurantDAO;

    private Owner owner;

    public OwnerHomePagePresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO){
        this.ownerDAO=ownerDAO;
        this.restaurantDAO=restaurantDAO;
    }
    public void setRestaurantList(){
        restaurantList = owner.getRestaurants();
    }
    public void setView(OwnerHomePageView view){
        this.view=view;
    }
    public OwnerDAO getOwnerDAO(){
        return this.ownerDAO;
    }
    public RestaurantDAO getRestaurantDAO(){
        return this.restaurantDAO;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return ownerDAO.findRestaurants(owner.getUserId());
    }
    public void setOwner(int ownerId) {
        owner = ownerDAO.find(ownerId);
    }

    public void onAddRestaurant(){
        view.AddRestaurant();
    }

    public ArrayList<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }
    public void onChangeLayout(){
        view.changeLayout();
    }
}
