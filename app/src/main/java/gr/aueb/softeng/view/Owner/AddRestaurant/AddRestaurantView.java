package gr.aueb.softeng.view.Owner.AddRestaurant;

import java.util.HashMap;

public interface AddRestaurantView {    /**
 * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι rname ή τηλέφωνο του εστιατορίου
 * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο ιδιοκτήτης
 * τα στοιχεία του εστιατορίου που θέλει να προσθέσει
 * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
 */
    HashMap<String,String>  getRestDetails();
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    void showErrorMessage(String title, String message);
    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    void goBack();
}
