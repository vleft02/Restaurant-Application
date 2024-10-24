package gr.aueb.softeng.view.Customer.ChooseRestaurant;

public interface ChooseRestaurantView {
    void goBack();


    /**
     * Κρυβουμε το recyclerView και κάνουμε ορατό μήνυμα ενημέρωσης για την
     * απουσία εστιατορίων
     */
    void ShowNoRestaurants();

    /**
     * Εμφανίζουμαι και σετάρουμε το recyclerView και κάνουμε κρύβουμε το μηνυμα
     * απουσίας εστιατορίων
     */
    void ShowRestaurants();
}
