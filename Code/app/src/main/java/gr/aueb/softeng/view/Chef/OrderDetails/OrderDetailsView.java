package gr.aueb.softeng.view.Chef.OrderDetails;


public interface OrderDetailsView {
    /**
     * Εμφανίζει στην οθόνη το id της παραγγελίας που έχει πατηθεί
     * @param orderId το μοναδικό id της παραγγελίας
     */
    void setOrderId(String orderId);
    /**
     * Εμφανίζει στην οθόνη την κατάσταση της τρέχουσας επιλεγμένης παραγγελίας
     * @param state η κατάσταση της παραγγελίας
     */
    void setOrderState(String state);
    /**
     * Εμφανίζει στην οθόνη τον αριθμό τραπεζιού όπου έγινε η παραγγελία
     * @param num ο αριθμός του τραπεζιού
     */
    void setTableNumber(String num);
    /**
     * Εμφανιζει στην οθόνη την ώρα και λεπτό που έγινε η παραγγελία
     * @param date η ώρα και το λεπτό σε μορφή ενωμένου String
     */
     void setDate(String date);
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     *
     */
    void goBack();
    /**
     * Η μέθοδος αυτή εμφανίζει μήνυμα επιτυχίας στην οθόνη και καλείται όταν η παραγγελία γίνεται Completed από τον μάγειρα
     * Επίσης , δημιουργεί μία onClick listener η οποία όταν πατηθεί το OK στην οθόνη , μας
     * επιστρέφει στο προηγούμενο activity που μας κάλεσε
     */
    void showOrderCompletedMessage();
    /**
     * Κρύβει το κουμπί του SetCompletedButton που είναι για τις περιπτώσεις που το activity καλείται απο τον customer
     */
    void hideCompletionButton();
    /**
     * Εμφανίζει το κουμπί του SetCompletedButton που είναι για τις περιπτώsεις του μάγειρα ώστε να μπορεί να την αλλάξει
     */
    void showCompletedButton();
}
