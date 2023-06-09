package gr.aueb.softeng.view.SignUp.SignUpOwner;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.Owner;


public class SignUpOwnerPresenter {
    private OwnerDAO ownerDAO;
    private UserDAO userDAO;
    SignUpOwnerView view;
    /**
     * Αρχικοποιεί το user dao και το customer dao για να μπορούμε να αποθηκεύσουμε και ανακτήσουμε απο την
     * στατική μας λίστα τους ιδιοκτήτες και τους users
     * @param userDAO
     * @param ownerDAO
     */
    public SignUpOwnerPresenter( UserDAO userDAO, OwnerDAO ownerDAO)
    {
        this.ownerDAO = ownerDAO;
        this.userDAO = userDAO;
    }
    /**
     * Αρχικοποιεί το view απο το οποίο θα χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param v Instance του view
     */
    public void setView(SignUpOwnerView v)
    {
        this.view = v;
    }
    /**
     * Επιστρέφει το αντικείμενο view που δημιουργήσαμε επάνω
     * @return το Instance του αντικειμένου
     */
    public SignUpOwnerView getView() {
        return view;
    }
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί δημιουργίας του account απο τον ιδιοκτήτη
     * αφου πρώτα έχουν περαστεί όλα τα στοιχεία του
     * Κάνουμε ελέγχους σε κάθε πεδίο για το άν θεωρείται αποδεκτό , και εάν δεν είναι εμφανίζεται μήνυμα ειδοποίησης την οθόνη του ιδιοκτήτη
     * που τον ειδοποιεί για να κάνει τις απαραίτητες αλλαγές
     * Εάν τα στοιχεία είναι σωστά , εμφανίζεται κατάλληλο μήνυμα και προστίθεται ο ιδιοκτήτης στην εφαρμογή
     */
    public void onCreateOwnerAccount(){
        boolean isEmpty=false;
        HashMap<String,String> details = view.getOwnerDetails();

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
        }else if(!details.get("email").contains("@") &&( !details.get("email").contains(".com") || !details.get("email").contains(".gr"))) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε σωστά το email.");
        }else if (details.get("telephone").length() != 10) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.");
        }else if (details.get("iban").length() < 20) { // iban has 34 digits in our example we use greater than 20 for easier Input in the ui
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο iban.");
        }else if (details.get("password").length() < 8) {
            view.showErrorMessage("Σφάλμα!", "Ο κωδικός θα πρέπει να αποτελείται απο 8 ψηφία και πάνω.");
        }else if (details.get("tin").length() != 9){
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο αφμ με 9 ψηφία.");
        }else if (userDAO.find(details.get("username"))!=null){
            view.showErrorMessage("Σφάλμα!","Υπάρχει ήδη λογαριασμός με αυτο το username \n Συμπληρώστε νέα στοιχεία!" );
        }else{
            Owner owner= new Owner(details.get("username"),details.get("name"),details.get("surname"),details.get("telephone"),
                    details.get("email"),details.get("password"), ownerDAO.nextId(),details.get("iban"),details.get("tin"));

            ownerDAO.save(owner);
            userDAO.save(owner); // na dw min exei thema kai epeidh den einai tipou user den touw vazei

            view.showAccountCreatedMessage();
        }
    }
    /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void onBack(){
        view.goBack();
    }

}
