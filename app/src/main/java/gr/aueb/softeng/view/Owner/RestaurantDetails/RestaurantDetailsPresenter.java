package gr.aueb.softeng.view.Owner.RestaurantDetails;


import gr.aueb.softeng.dao.RestaurantDAO;

import gr.aueb.softeng.domain.Restaurant;


public class RestaurantDetailsPresenter {
    private RestaurantDAO restaurantDAO;
    private Restaurant restaurant;

    public RestaurantDetailsPresenter(RestaurantDAO restaurantDAO){
        this.restaurantDAO = restaurantDAO;

    }
    RestaurantDetailsView view;
    public void setView(RestaurantDetailsView v)
    {
        this.view = v;
    }

    public void setRestaurant(int restaurantId) {
        restaurant = restaurantDAO.find(restaurantId);
    }
    public void setDetails(){
        view.setRestName("Name: "+ restaurant.getRestaurantName());
        view.setRestId("Id: "+String.valueOf(restaurant.getId()));
        view.setRestTables("Total tables: "+ String.valueOf(restaurant.getTotalTables()));
        view.setRestAddressStreet("Address Street: "+restaurant.getAddress().getStreetName());
        view.setRestAddressNumber("Address Number: "+String.valueOf(restaurant.getAddress().getStreetNumber()));
        view.setRestAddressCity("Address City: "+restaurant.getAddress().getCity());
        view.setRestZip("Address ZC: "+String.valueOf(restaurant.getAddress().getZipCode()));
    }
    public void onExtractStats(){
        view.extractStats();
    }
    public void OnBack(){
        view.goBack();
    }
    public void onAddChef(){view.addChef();}

}
