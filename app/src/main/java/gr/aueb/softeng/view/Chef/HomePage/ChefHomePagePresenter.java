package gr.aueb.softeng.view.Chef.HomePage;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;

import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Order;


public class ChefHomePagePresenter {
    ChefHomePageView view;

    private ArrayList<Order> orderList;
    private ChefDAO chefDAO;
    private OrderDAO orderDAO;

    private Chef chef;
    /**
     * Αρχικοποιεί τον Presenter ώστε να μπορούμε να προσθέσουμε / βρούμε τον μάγειρα και τις παραγγελίες του
     * @param chefDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τους μάγειρες και μπορούμε και προσθέτουμε/λαμβάνουμε μάγειρες
     * @param orderDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τα τις παραγγελίες και μπορούμε και προσθέτουμε/λαμβάνουμε παραγγελίες συγκεκριμένου μάγειρα
     */
    public ChefHomePagePresenter(ChefDAO chefDAO, OrderDAO orderDAO){
        this.chefDAO=chefDAO;
        this.orderDAO=orderDAO;
    }
    /**
    *Γεμίζει την λίστα των παραγγελιών με τις παραγγελίες του συγκεκριμένου μάγειρα που έχει συνδεθεί
     * Αφαιρεί κάθε φορά που καλείται τις παραγγελίες που έχουν ολοκληρωθεί
 */
    public void setOrderList(){
        ArrayList<Order> orders = chef.getOrders();
        orderList = new ArrayList<>();
        int i=0;
        for(Order order: orders){
            if (order.getOrderState() == Order.State.RECEIVED)
            {
                orderList.add(order);
            }
        }
    }
    /**
     *Σετάρει το αντικείμενο view μας για να χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Ένα instance του view
     */
    public void setView(ChefHomePageView view){
        this.view=view;
    }
    /**
     * @return επιστρέφει το chef Dao με τους μάγειρες που πήραμε σαν παράμετρο απο τον κατασκευαστή της κλάσης επάνω
     */
    public ChefDAO getChefDAO(){
        return this.chefDAO;
    }
    /**
     * @return επιστρέφει το order Dao με τις παραγγελίες που πήραμε σαν παράμετρο απο τον κατασκευαστή της κλάσης επάνω
     */
    public OrderDAO getOrderDAO(){
        return this.orderDAO;
    }
    /**
     * Αρχικοποιεί τον μάγειρα  με βάση το αντικείμενο που θα βρεί απο το Dao και με βάση το μοναδικό Id που του περνάμε
     * @param chefId είναι το chef Id ενός συγκεκριμένου chef
     */
    public void setChef(int chefId) {
        chef = chefDAO.find(chefId);
    }

    /**
     * Επιστρέφει την λίστα με τις παραγγελίες του συγκεκριμένου μάγειρα
     * @return η λίστα με τις ενεργές παραγγελίες
     */
    public ArrayList<Order> getOrderList(){
        return orderList;
    }

    /**
     * Καλέι την μέθοδο του view που αλλάζει την εμφάνιση της οθόνης ανάλογα εάν είναι άδεια η λίστα με τα εστιατόρια του ιδιοκτήτη ή οχι
     */
    public void onChangeLayout(){
        view.changeLayout();
    }
    /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void onBack(){
        view.goBack();
    }
}
