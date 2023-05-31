package gr.aueb.softeng.view.Owner.HomePage;

import java.util.ArrayList;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public class OwnerHomePagePresenter {

    OwnerHomePageView view;

    private OwnerDAO ownerDAO;
    private RestaurantDAO restaurantDAO;

    private Owner owner;

    public OwnerHomePagePresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO){
        this.ownerDAO=ownerDAO;
        this.restaurantDAO=restaurantDAO;
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
}
