package gr.aueb.softeng.view.Owner.HomePage;

public interface OwnerHomePageView {
    /**
     * Καλεί το νέο activity το οποίο προσθέτει ένα νέο εστιατόριο στον ιδιοκτήτη
     */
    void AddRestaurant();
    void ShowNoRestaurants();
    void ShowRestaurants();

    /**
     * επιστρέφει στο προηγούμενο activity που μας κάλεσε
     */
    void goBack();
}
