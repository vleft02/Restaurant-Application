package gr.aueb.softeng.view.Owner.HomePage;



import java.util.ArrayList;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public class OwnerHomePagePresenter {

    OwnerHomePageView view;

    private ArrayList<Restaurant> restaurantList= new ArrayList<>();
    private OwnerDAO ownerDAO;
    private RestaurantDAO restaurantDAO;

    private Owner owner;

    /**
     * Αρχικοποιεί τον Presenter ώστε να μπορούμε να προσθέσουμε / βρούμε τον ιδιοκτήτη και τα εστιατόριά του
     * @param ownerDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τους Owners και μπορούμε και προσθέτουμε/λαμβάνουμε ιδιοκτήτες
     * @param restaurantDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τα εστιατόρια και μπορούμε και προσθέτουμε/λαμβάνουμε εστιατόρια συγκεκριμένου ιδιοκτήτη
     */
    public OwnerHomePagePresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO){
        this.ownerDAO=ownerDAO;
        this.restaurantDAO=restaurantDAO;
    }
    /*
    Γεμίζει την λίστα των εστιατορίων με τα εστιατόρια του συγκεκριμένου ιδιοκτήτη που έχει συνδεθεί
     */
    public void setRestaurantList(){
        restaurantList = owner.getRestaurants();
    }

    /**
     *Σετάρει το αντικείμενο view μας για να χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Ένα instance του view
     */
    public void setView(OwnerHomePageView view){
        this.view=view;
    }

    /**
     * @return επιστρέφει το owner Dao με τους ιδιοκτήτες που πήραμε σαν παράμετρο απο τον κατασκευαστή της κλάσης επάνω
     */
    public OwnerDAO getOwnerDAO(){
        return this.ownerDAO;
    }

    /**
     * @return επιστρέφει το owner Dao με τους ιδιοκτήτες που πήραμε σαν παράμετρο απο τον κατασκευαστή της κλάσης επάνω
     */
    public RestaurantDAO getRestaurantDAO(){
        return this.restaurantDAO;
    }

    /**
     * @return Επιστρέφει τα εστιατόρια ενός συγκεκριμένου owner με βάση το UserId του
     */
    public ArrayList<Restaurant> getRestaurants() {
        return ownerDAO.findRestaurants(owner.getUserId());
    }

    /**
     * Αρχικοποιεί τον owner με βάση το αντικείμενο που θα βρεί απο το Dao και με βάση το μοναδικό Id που του περνάμε
     * @param ownerId είναι το User Id ενός συγκεκριμένου owner
     */
    public void setOwner(int ownerId) {
        owner = ownerDAO.find(ownerId);
    }

    /**
     * Καλείται όταν πατηθεί το κουμπί προσθήκης ενός νέου εστιατορίου απο τον ιδιοκτήτη-owner
     * Καλεί την μέθοδο του view που μας πηγαίνει στο Activity που προσθέτουμε ένα νέο εστιατόριο
     */

    public void onAddRestaurant(){
        view.AddRestaurant();
    }

    /**
     *
     * @return Επιστρέφει την λίστα με τα εστιατόρια του συγκεκριμένου ιδιοκτήτη που γεμίσαμε επάνω
     */
    public ArrayList<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }

    /**
     * Καλέι την μέθοδο του view που αλλάζει την εμφάνιση της οθόνης ανάλογα εάν είναι άδεια η λίστα με τα εστιατόρια του ιδιοκτήτη ή οχι
     */
    public void onChangeLayout() {
        if (restaurantList.isEmpty()) {
            view.ShowNoRestaurants();
        }
        else {
            view.ShowRestaurants();
        }
    }

    /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void onBack(){view.goBack();}
    public Owner getOwner(){
        return this.owner;
    }
    public OwnerHomePageView getView(){
        return this.view;
    }
}
