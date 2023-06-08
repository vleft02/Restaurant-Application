package gr.aueb.softeng.view.Owner.AddRestaurant;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Address;

import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;


public class AddRestaurantPresenter {
    private RestaurantDAO restaurantDAO;
    private OwnerDAO ownerDAO;
    private int ownerId;
    private Owner owner;
    /**
     * Αρχικοποιεί το owner dao και το restaurant dao για να μπορούμε να αποθηκεύσουμε και ανακτήσουμε απο την
     * στατιστική μας λίστα τα εστιατόρια και τους ιδιοκτήτες
     * @param ownerDAO
     * @param restaurantDAO
     */
    public AddRestaurantPresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO) {
        this.ownerDAO= ownerDAO;
        this.restaurantDAO = restaurantDAO;
    }

    /**
     * Βρίσκει μέσω του μοναδικού id τον ιδιοκτήτη απο την στατική λίστα που περιέχει
     * to owner dao
     * @param id το μοναδικό id του ιδιοκτήτη που θέλουμε να προσθέσουμε το εστιατόριο
     */
    public void setOwner(int id){
        owner= ownerDAO.find(id);
    }

    AddRestaurantView view;
    /**
     * Αρχικοποιεί το view απο το οποίο θα χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Instance του view
     */
    public void setView(AddRestaurantView view) {
        this.view = view;
    }

    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί δημιουργίας του εστιατορίου
     * αφου πρώτα έχουν περαστεί όλα τα στοιχεία του
     * Κάνουμε ελέγχους σε κάθε πεδίο για το άν θεωρείται αποδεκτό , και εάν δεν είναι εμφανίζεται μήνυμα ειδοποίησης την οθόνη του ιδιοκτήτη
     * για να κάνει τις απαραίτητες αλλαγές
     * Εάν τα στοιχεία είναι σωστά , εμφανίζεται κατάλληλο μήνυμα, δημιουργείται το νέο εστιατόριο και το αποθηκεύουμε στο restaurant dao
     * και στην λίστα του ιδιοκτήτη με τα εστιατόρια
     */
    public void onCreateRestaurant() {
        boolean isEmpty = false;
        HashMap<String, String> details = view.getRestDetails();

        for (Map.Entry<String, String> set : details.entrySet()) {
            if (set.getValue().isEmpty() || set.getValue() == null) {
                isEmpty = true;
                break;
            }
        }
        if (isEmpty) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία!.");
        } else if (details.get("name").length() < 4 || details.get("name").length() > 15) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε 4 έως 15 χαρακτήρες στο Restaurant Name.");
        } else if (details.get("telephone").length() < 10) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.");
        } else if (details.get("streetName").length() < 3) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε απο 4 και πάνω χαρακτήρες στο Street Name");
        } else if (details.get("streetNumber").equals("0") ) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε απο 1 ψηφίο και πάνω στο Street Number");
        } else if (details.get("zc").length() < 2) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε απο 2 και πάνω ψηφία στον Ταχυδρομικό κώδικα(ZC).");
        }else if (details.get("total_tables").equals("0")){
            view.showErrorMessage("Σφάλμα!", "Θα πρέπει να έχετε τουλάχιστον 1 τραπέζι και πάνω για να δημιουργηθεί το εστιατόριο");
        } else if (restaurantDAO.find(details.get("name")) != null) {
            view.showErrorMessage("Σφάλμα!", "Υπάρχει ήδη εστιατόριο με ίδιο όνομα \n Συμπληρώστε νέα στοιχεία!");
        } else {
            Restaurant restaurant= new Restaurant(restaurantDAO.nextId(),details.get("name"),details.get("telephone"),Integer.parseInt(details.get("total_tables")),new Address(Integer.parseInt(details.get("streetNumber")),details.get("streetName"),Integer.parseInt(details.get("zc")),details.get("city")));

            restaurantDAO.save(restaurant);
            owner.addRestaurant(restaurant);
            view.showRestaurantAddedMessage();
        }
    }
     /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void onBack(){
        view.goBack();
    }
    public AddRestaurantView getView(){
        return this.view;
    }
    public Owner getOwner(){
        return this.owner;
    }
}
