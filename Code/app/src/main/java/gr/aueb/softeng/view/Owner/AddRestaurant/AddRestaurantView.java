package gr.aueb.softeng.view.Owner.AddRestaurant;

import java.util.HashMap;

public interface AddRestaurantView {    /**
 * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι rname ή τηλέφωνο του εστιατορίου
 * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο ιδιοκτήτης
 * τα στοιχεία του εστιατορίου που θέλει να προσθέσει
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

    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο ιδιοτήτης προσθέσει επιτυχώς το νέο εστιατόριό του
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    void showRestaurantAddedMessage();
}
