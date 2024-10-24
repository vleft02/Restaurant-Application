package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Restaurant;

public class ChooseRestaurantPresenter {

    ChooseRestaurantView view;
    private RestaurantDAO restaurantDAO;

    private ArrayList<Restaurant> restaurants;
    /**
     * Αρχικοποιεί τον Presenter ώστε να μπορούμε να προσθέσουμε / βρούμε τα εστιατόρια
     * @param restaurantDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τα εστιατόρια και μπορούμε και προσθέτουμε/λαμβάνουμε αντικείμενα
     */

    public ChooseRestaurantPresenter(RestaurantDAO restaurantDAO)
    {
        this.restaurantDAO = restaurantDAO;
        restaurants = new ArrayList<>();
    }

    /**
     *Σετάρει το αντικείμενο view μας για να χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Ένα instance του view
     */
    public void setView(ChooseRestaurantView view) {
        this.view = view;
    }
    /**
     * Επιστρέφει το αντικείμενο view Που δημιουργήσαμε παραπάνω
     * @return το Instance του αντικειμένου
     */
    public ChooseRestaurantView getView() {
        return view;
    }
    /**
     * Γεμίζει την λίστα με τα εστιατορια της συγκεκριμένης παραγγελίας
     */
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
    /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void onBack(){
        view.goBack();
    }
    /**
     * Επιστρέφει την λίστα με τα εστιατόρια
     * @return η λίστα με τα εστιατόρια
     */
    public ArrayList<Restaurant> getRestaurantList() {
        return restaurants;
    }
}
