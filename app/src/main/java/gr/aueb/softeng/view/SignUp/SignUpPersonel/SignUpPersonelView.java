package gr.aueb.softeng.view.SignUp.SignUpPersonel;

import java.util.HashMap;

public interface SignUpPersonelView {
    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι username ή τηλέφωνο του μάγειρα
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο μάγειρας τα στοιχεία εγγραφής του
     * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
     */
    HashMap<String,String> getChefDetails();
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
     * Εμφανίζει μήνυμα επιτυχίας όταν ο μάγειρας δημιουργήσει επιτυχώς τον λογαριασμό του
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    void showAccountCreatedMessage();
}
