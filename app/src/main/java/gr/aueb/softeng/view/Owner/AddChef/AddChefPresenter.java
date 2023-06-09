package gr.aueb.softeng.view.Owner.AddChef;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Restaurant;

public class AddChefPresenter {
    private ChefDAO chefDAO;
    private RestaurantDAO restDAO;
    AddChefView view;
    private Restaurant restaurant;
    /**
     * Αρχικοποιεί το chef dao και το restaurant dao για να μπορούμε να αποθηκεύσουμε και ανακτήσουμε απο την
     * στατική μας λίστα τα εστιατόρια και τους μάγειρες
     * @param chefDAO
     * @param restDAO
     */
    public AddChefPresenter(RestaurantDAO restDAO, ChefDAO chefDAO)
    {
        this.chefDAO = chefDAO;
        this.restDAO = restDAO;
    }
    /**
     * Αρχικοποιεί το view απο το οποίο θα χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param v Instance του view
     */
    public void setView(AddChefView v)
    {
        this.view = v;
    }
    /**
     * Βρίσκει μέσω του μοναδικού id το εστιατόριο που θέλουμε να προστεθεί ο μάγειρας, απο την στατική λίστα που περιέχει
     * to restaurant dao
     * @param id το μοναδικό id του εστιατορίου που θέλουμε να προσθέσουμε τον μάγειρσ
     */
    public void setRestaurant(int id){
        this.restaurant = restDAO.find(id);
}
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εισαγωγής του μάγειρα στο εστιατόριο
     * αφου πρώτα έχουν περαστεί όλα τα στοιχεία του
     * Κάνουμε ελέγχους σε κάθε πεδίο για το άν θεωρείται αποδεκτό , και εάν δεν είναι εμφανίζεται μήνυμα ειδοποίησης την οθόνη του ιδιοκτήτη
     * που τον ειδοποιεί για να κάνει τις απαραίτητες αλλαγές
     * Επισης , γίνεται έλεγχος για κάθε ένα στοιχείο εάν ταυτίζεται ακριβώς με τα στοιχεία που έχει βάλει
     * ο μάγειρας κατά την εγγραφή του στο σύστημα
     * Εάν έστω και ένα στοιχείο δεν είναι ίδιο , εμφανίζεται μήνυμα λάθους στην οθόνη
     * Εάν τα στοιχεία είναι σωστά , εμφανίζεται κατάλληλο μήνυμα, προστίθεται ο μάγειρας στο εστιατόριο
     */
    public void onAddChefAccount(){
        boolean isEmpty=false;
        HashMap<String,String> details = view.getChefDetails();

        for(Map.Entry<String, String> set: details.entrySet()){
            if(set.getValue().isEmpty() || set.getValue()==null){
                isEmpty=true;
                break;
            }
        }
        if(isEmpty){
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε όλα τα πεδία!.");
        }else if(details.get("username").length() < 4 || details.get("username").length() > 15) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε 4 έως 15 χαρακτήρες στο Username.");
        }else if (details.get("telephone").length() < 10) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.");
        }else if (details.get("iban").length() < 5) { // anti gia 5 na valw akrivws posa einai pragmatika
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο iban.");
        }else if (details.get("tin").length() < 3){
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο tin.");
        }else if (chefDAO.find(details.get("username"))==null) { // the chef has logged in
            view.showErrorMessage("Σφάλμα!", "Τα στοιχεία που δώσατε δεν αντιστοιχούν σε κάποιον μάγειρα της εφαρμογής , \n Ξαναδοκιμάστε!");
        }else if (chefDAO.find(details.get("username"))!=null &&  chefDAO.find(details.get("username")).getName().equals(details.get("name")) &&
                chefDAO.find(details.get("username")).getSurname().equals(details.get("surname")) && String.valueOf(chefDAO.find(details.get("username")).getIban()).equals(details.get("iban"))
                && String.valueOf(chefDAO.find(details.get("username")).getTin()).equals(details.get("tin")) && String.valueOf(chefDAO.find(details.get("username")).getTelephone()).equals(details.get("telephone"))){

            restaurant.addChef(chefDAO.find(details.get("username")));
            view.showChefAddedMessage();
        }
    }
    /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void onBack(){
        view.goBack();
    }

    /**
     * Επιστρέφει το αντικείμενο view που δημιουργήσαμε επάνω
     * @return το Instance του αντικειμένου
     */
    public AddChefView getView(){
        return this.view;
    }

    /**
     * Επιστρέφει το αντικείμενο Restaurant που δημιουργήθηκε επάνω
     * @return το Instance του αντικειμένου
     */
    public Restaurant getRestaurant(){
        return this.restaurant;
    }
}
