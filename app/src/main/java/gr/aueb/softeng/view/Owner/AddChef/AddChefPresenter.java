package gr.aueb.softeng.view.Owner.AddChef;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.view.SignUp.SignUpPersonel.SignUpPersonelView;

public class AddChefPresenter {
    private ChefDAO chefDAO;
    private RestaurantDAO restDAO;
    AddChefView view;
    private Restaurant restaurant;

    public AddChefPresenter(RestaurantDAO restDAO, ChefDAO chefDAO)
    {
        this.chefDAO = chefDAO;
        this.restDAO = restDAO;
    }
    public void setView(AddChefView v)
    {
        this.view = v;
    }

    public void setRestaurant(int id){
        this.restaurant = restDAO.find(id);
}

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
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο αριθμό κάρτας");
        }else if (details.get("tin").length() < 3){
            view.showErrorMessage("Σφάλμα!", "Συμπληρώστε έγκυρο cvv.");
        }else if (chefDAO.find(details.get("username"))==null) { // the chef has logged in
            view.showErrorMessage("Σφάλμα!", "Τα στοιχεία που δώσατε δεν αντιστοιχούν σε κάποιον μάγειρα της εφαρμογής , \n Ξαναδοκιμάστε!");
        }else if (chefDAO.find(details.get("username"))!=null &&  chefDAO.find(details.get("username")).getName().equals(details.get("name")) &&
                chefDAO.find(details.get("username")).getSurname().equals(details.get("surname")) && String.valueOf(chefDAO.find(details.get("username")).getIban()).equals(details.get("iban"))
                && String.valueOf(chefDAO.find(details.get("username")).getTin()).equals(details.get("tin")) && String.valueOf(chefDAO.find(details.get("username")).getTelephone()).equals(details.get("telephone"))){


            view.showErrorMessage("Επιτυχία!","Τα στοιχεία ταυτοποιήθηκαν με τον μάγειρα που θέλετε να προστεθεί!" );

            restaurant.addChef(chefDAO.find(details.get("username")));

            view.showErrorMessage("Μπραβο!", details.get("username")+details.get("name")+details.get("surname")+details.get("telephone")+
                    details.get("email")+details.get("password")+details.get("iban")+ details.get("tin"));
            view.goBack();
        }
        else{
            view.showErrorMessage("Σφάλμα!", "Τα στοιχεία που δώσατε δεν αντιστοιχούν σε κάποιον μάγειρα της εφαρμογής , \n Ξαναδοκιμάστε!");
        }

    }
}
