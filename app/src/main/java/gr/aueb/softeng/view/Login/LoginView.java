package gr.aueb.softeng.view.Login;

import android.app.AlertDialog;
import android.content.DialogInterface;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.view.View;

public interface LoginView extends View {
    /**
     * Η μέθοδος αυτή λαμβάνει το όνομα που έχει πληκτρολογήσει ο χρήστης στο πεδίο Username
     * @return Επιστρέφει το string αυτο
     */
    String ExtractUsername();
    /**
     * Η μέθδος αυτή λαμβάνει τον κωδικό που έχει πληκτρολογήσει ο χρήστης στο πεδίο PassWord
     * @return Επιστρέφει το string αυτό
     */
    String ExtractPassword();
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο πελάτης συνδεθεί επιτυχώς τον λογαριασμό του
     * και κατευθύνεται στο Home Page ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    void showCustomerFoundMessage(int id);
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο μάγειρας συνδεθεί επιτυχώς τον λογαριασμό του
     * και κατευθύνεται στο Home Page ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    void showChefFoundMessage(int id);
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο ιδιοκτήτης συνδεθεί επιτυχώς τον λογαριασμό του
     * και κατευθύνεται στο Home Page ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    void showOwnerFoundMessage(int id);
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εγγραφής για πελάτη
     */
    void signup();
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εγγραφής για μάγειρα
     */
    void signupPersonel();
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εγγραφής για ιδιοκτήτη
     */
    void signupOwner();
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    void showErrorMessage(String title, String message);
}
