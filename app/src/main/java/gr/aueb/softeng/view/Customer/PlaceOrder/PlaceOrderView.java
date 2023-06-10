package gr.aueb.softeng.view.Customer.PlaceOrder;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;

public interface PlaceOrderView {

    /**
     * Προωθούμαστε στο σελίδα επισκόπησης των περιεχομενων της παραγγελίας
     * περιμένωντας να επιστρέψει ή πιαθνός τροποποιημένη λιστα με orderlines
     */
    void redirectToCart(ArrayList<OrderLine> orderLines);
    /**
     * Κρυβουμε το recyclerView και το κοθμπί για ολοκλήρωση παραγγελίας
     * ενω εμφανίζουμε το μήνυμα μη ύπαρξης πιάτων.
     */
    void showEmptyList();
    /**
     * Εμφανίζουμε και σετάρουμε το recyclerView το κουμπί για ολοκλήρωση παραγγελίας
     * ενώ κρύβουμε το μήνυμα οτι δεν υπάρχουν πιάτα
     */
    void showDishList();

    /**
     * Εμφανίζουμε Alert dialog παράθυρο για να ενημερώσουμε τον χρήστη ότι η παραγγελία απέτυχδ διότι
     * δεν έχει το απαραίτητο χρηματικό υπολοιπο. Έπειτα προωθείται στο Homepage
     */
    void insufficientFundsMessage();


    /**
     * Εμφανίζουμε Alert dialog παράθυρο για να ενημερώσουμε τον χρήστη για το συνολικό κόστος της παραγγελίας.
     * 'Επειτα ο χρήστης είτε διαλέγει να την ολοκληρώσει επιλέγοντας "Ναι" και επιστρέφει στο Homepage ή επιλέγει "Οχι" και
     *  και κλείνει το παράθυρο
     */
    void ShowConfirmationMessage(ConfirmationListener confirmationListener);

    void goBack();

}
