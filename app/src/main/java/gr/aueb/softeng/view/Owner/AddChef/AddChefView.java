package gr.aueb.softeng.view.Owner.AddChef;

import java.util.HashMap;

public interface AddChefView {
    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι username ή τηλέφωνο του μάγειρα
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο ιδιοκτήτης ψάχνοντας τον μάγειρα
     * με τα στοιχεία του
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
}
