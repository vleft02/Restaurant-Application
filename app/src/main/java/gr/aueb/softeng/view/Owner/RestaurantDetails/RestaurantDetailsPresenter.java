package gr.aueb.softeng.view.Owner.RestaurantDetails;


import gr.aueb.softeng.dao.RestaurantDAO;

import gr.aueb.softeng.domain.Restaurant;


public class RestaurantDetailsPresenter {
    private RestaurantDAO restaurantDAO;
    private Restaurant restaurant;

    /**
     * Αρχικοποιεί το restaurant dao για να μπορούμε να αποθηκεύσουμε εστιατόρια και να τα ανακτήσουμε από την στατική μας λίστα
     * @param restaurantDAO Instance του DAO
     */

    public RestaurantDetailsPresenter(RestaurantDAO restaurantDAO){
        this.restaurantDAO = restaurantDAO;

    }
    RestaurantDetailsView view;

    /**
     * Αρχικοποιεί το view απο το οποίο θα χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param v Instance του view
     */
    public void setView(RestaurantDetailsView v)
    {
        this.view = v;
    }

    /**
     * Βρίσκει μέσω του μοναδικού id απο την λίστα με τα εστιατόρια του dao το αντικείμενο του εστιατορίου
     * που ψάχνουμε
     * @param restaurantId το id του εστιατορίου που θέλουμε να εμφανίσουμε τα στοιχεία του
     */
    public void setRestaurant(int restaurantId) {
        restaurant = restaurantDAO.find(restaurantId);
    }

    /**
     * Καλεί τις μεθόδους του view που εμφανίζουν στην οθόνη τα στοιχεία του εστιατορίου
     */
    public void setDetails(){
        view.setRestName("Name: "+ restaurant.getRestaurantName());
        view.setRestId("Id: "+String.valueOf(restaurant.getId()));
        view.setRestTables("Total tables: "+ String.valueOf(restaurant.getTotalTables()));
        view.setRestAddressStreet("Address Street: "+restaurant.getAddress().getStreetName());
        view.setRestAddressNumber("Address Number: "+String.valueOf(restaurant.getAddress().getStreetNumber()));
        view.setRestAddressCity("Address City: "+restaurant.getAddress().getCity());
        view.setRestZip("Address ZC: "+String.valueOf(restaurant.getAddress().getZipCode()));
    }

    /**
     * Καλείται για να εξάγει τα στατιστικά όταν πατηθεί το κουμπί εξαγωγής στατιστικών
     */
    public void onExtractStats(){
        view.extractStats();
    }

    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στην αρχική οθόνη
     */
    public void OnBack(){
        view.goBack();
    }

    /**
     * Καλείται για να προστεθεί ένας νέος μάγειρας όταν πατηθεί το κουμπί της εισαγωγής νέου μάγειρα απο τον ιδιοκτήτη
     */
    public void onAddChef(){view.addChef();}
    public RestaurantDetailsView getView(){
        return this.view;
    }
    public Restaurant getRestaurant(){
        return this.restaurant;
    }

}
