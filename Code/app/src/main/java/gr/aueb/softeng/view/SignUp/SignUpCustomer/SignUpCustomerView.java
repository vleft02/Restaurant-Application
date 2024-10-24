package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import java.util.HashMap;

public interface SignUpCustomerView {
    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι username ή τηλέφωνο του πελάτη
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο πελάτης τα στοιχεία εγγραφής του
     * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
     */
    HashMap<String,String> getDetails();
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
     * Εμφανίζει μήνυμα επιτυχίας όταν ο πελάτης δημιουργήσει επιτυχώς τον λογαριασμό του
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    void showAccountCreatedMessage();
}
