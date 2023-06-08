package gr.aueb.softeng.view.Chef.ChefOrderDetails;


public interface ChefOrderDetailsView {
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
    public void setDate(String date);
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     *
     */
    void goBack();
    void showOrderCompletedMessage();
}
