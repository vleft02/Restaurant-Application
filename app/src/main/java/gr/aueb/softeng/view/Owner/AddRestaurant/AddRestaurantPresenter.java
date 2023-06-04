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

    public AddRestaurantPresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO) {
        this.ownerDAO= ownerDAO;
        this.restaurantDAO = restaurantDAO;
    }
    public void setOwner(int id){
        owner= ownerDAO.find(id);
    }

    AddRestaurantView view;

    public void setView(AddRestaurantView view) {
        this.view = view;
    }

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
        } else if (details.get("streetNumber").length() < 1) {
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

            view.showErrorMessage("Μπραβο!", details.get("name") + details.get("telephone") + details.get("streetName") + details.get("streetNumber") +
                    details.get("zc") + details.get("total_tables"));
            view.goBack();
        }
    }
}
