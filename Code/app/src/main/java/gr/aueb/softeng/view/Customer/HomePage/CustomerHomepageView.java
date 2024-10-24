package gr.aueb.softeng.view.Customer.HomePage;


import gr.aueb.softeng.view.View;

public interface CustomerHomepageView extends View{

    /**
     * Εμφανίζει ενα μήνυμα τύπου alert
     * Για να ρωτήσει τον χρήστη αν είναι σίγουρος
     * οτι θέλει να ακυρώσει την παραγγελία
     */
    void ShowConfirmationMessage();

    /**
     * Προωθούμαστε στη σελίδα επισκόπησης στοιχείων της ενεργής παραγγελίας
     */
    void redirectTopUp();

    /**
     * Παίρνουμε το fragment του tabLayout και εμφανίζουμε το current Order
     * κρύβοντας τα υπολοιπα γραφικά στοιχεία
     */
    void showCurrentOrder();

    /**
     * Παίρνουμε το fragment του tabLayout και κρύβουμε το πλαίσιο που θα έιχε τα στοιχεία τις παραγγελίας
     * αλλα εμφανίζουμε τα υπολοιπα στοιχεία απαραίτητα γαι την προσθήκη νεας παραγγελίας (Μηνυμα καθοδηγσης, + κουμπι)
     */
    void showNoCurrentOrder();

    /**
     * Εμφανίζεται pop up παράθυρο για την επιλογή
     * ενος ακεραίου που αντιστοιχεί στον αριθμό του
     * τραπεζιού για την παραγγελία που πρόκειται να
     * υποβληθεί.
     */
    void showTableNumberPickerPopup();
}

