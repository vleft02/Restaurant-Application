package gr.aueb.softeng.view.Owner.HomePage;

public interface OwnerHomePageView {
    /**
     * Καλεί το νέο activity το οποίο προσθέτει ένα νέο εστιατόριο στον ιδιοκτήτη
     */
    void AddRestaurant();

    /**
     * Αλλάζει την εμφάνιση του Home Page σε περίπτωση που είναι άδεια η λίστα με τα εστιατόρια
     */
    void changeLayout();

    /**
     * επιστρέφει στο προηγούμενο activity που μας κάλεσε
     */
    void goBack();
}
