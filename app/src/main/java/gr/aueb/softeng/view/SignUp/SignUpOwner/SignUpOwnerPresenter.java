package gr.aueb.softeng.view.SignUp.SignUpOwner;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.dao.CustomerDAO;import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.Owner;


public class SignUpOwnerPresenter {
    private OwnerDAO ownerDAO;
    private UserDAO userDAO;
    SignUpOwnerView view;
    public SignUpOwnerPresenter( UserDAO userDAO, OwnerDAO ownerDAO)
    {
        this.ownerDAO = ownerDAO;
        this.userDAO = userDAO;
    }
    public void setView(SignUpOwnerView v)
    {
        this.view = v;
    }

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
        }else if(!details.get("email").contains("@")) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε σωστά το email.");
        }else if (details.get("telephone").length() < 10) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο τηλεφωνικό αριθμό.");
        }else if (details.get("iban").length() < 5) { // anti gia 5 na valw akrivws posa einai pragmatika
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο αριθμό κάρτας");
        }else if (details.get("password").length() < 8) {
            view.showErrorMessage("Σφάλμα!", "Ο κωδικός θα πρέπει να αποτελείται απο 8 ψηφία και πάνω.");
        }else if (details.get("tin").length() < 3){
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο cvv.");
        }else if (userDAO.find(details.get("username"))!=null){
            view.showErrorMessage("Σφάλμα!","Υπάρχει ήδη λογαριασμός με αυτο το username \n Συμπληρώστε νέα στοιχεία!" );
        }else{
            Owner owner= new Owner(details.get("username"),details.get("name"),details.get("surname"),details.get("telephone"),
                    details.get("email"),details.get("password"), ownerDAO.nextId(),details.get("iban"),details.get("tin"));

            ownerDAO.save(owner);
            userDAO.save(owner); // na dw min exei thema kai epeidh den einai tipou user den touw vazei

            view.showErrorMessage("Μπραβο!", details.get("username")+details.get("name")+details.get("surname")+details.get("telephone")+
                    details.get("email")+details.get("password")+details.get("iban")+ details.get("tin"));
            view.goBack();
        }
    }

}
