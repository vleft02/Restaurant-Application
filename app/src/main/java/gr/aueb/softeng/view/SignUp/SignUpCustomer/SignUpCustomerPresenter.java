package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.Customer;

public class SignUpCustomerPresenter {
    private CustomerDAO customerDAO;
    private  UserDAO userDAO;
    SignUpCustomerView view;
    public void setView(SignUpCustomerView v)
    {
        this.view = v;
    }
    public void onCreateAccount(){
        boolean isEmpty=false;
        HashMap<String,String> details = view.getDetails();

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
        }else if (details.get("cardNumber").length() < 5) { // anti gia 5 na valw akrivws posa einai pragmatika
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο αριθμό κάρτας");
        }else if (details.get("password").length() < 8) {
            view.showErrorMessage("Σφάλμα!", "Ο κωδικός θα πρέπει να αποτελείται απο 8 ψηφία και πάνω.");
        }else if (details.get("cvv").length() < 3) {
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο cvv.");
        }else if (userDAO.find(details.get("username"), details.get("password"))!=null){ // there is already a user with the same username and password
            view.showErrorMessage("Σφάλμα!","Ο συνδυασμός Username και Password χρησιμοποιείται ήδη!\n Συμπληρώστε νέα στοιχεία!" );
        }else{
            Customer customer= new Customer(details.get("username"),details.get("name"),details.get("surname"),details.get("telephone"),
                    details.get("email"),details.get("password"), customerDAO.nextId(),details.get("cardNumber"),details.get("cardHolderName"),
                    details.get("cvv"));

            customerDAO.save(customer);
            userDAO.save(customer);

            view.showErrorMessage("Μπραβο!", details.get("username")+details.get("name")+details.get("surname")+details.get("telephone")+
                    details.get("email")+details.get("password")+ customerDAO.nextId() +details.get("cardNumber")+ details.get("cardHolderName")+
                    details.get("cvv"));
            view.goBack();
        }

    }
    public void setCustDao(CustomerDAO custDAO){
        this.customerDAO = custDAO;
    }

    public void setUserDao(UserDAO userDAO){this.userDAO=userDAO;}



}
