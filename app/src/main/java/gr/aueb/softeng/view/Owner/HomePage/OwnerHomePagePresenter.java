package gr.aueb.softeng.view.Owner.HomePage;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;

public class OwnerHomePagePresenter {

    OwnerHomePageView view;

    private OwnerDAO ownerDAO;
    private RestaurantDAO restaurantDAO;

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
}
