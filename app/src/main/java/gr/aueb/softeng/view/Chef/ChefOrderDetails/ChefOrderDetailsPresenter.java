package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.OrderLine;

public class ChefOrderDetailsPresenter {
    ChefOrderDetailsView view;

    private ArrayList<OrderLine> orderLineList;
    private ChefDAO chefDAO;
    private OrderDAO orderDAO;
    private Chef chef;

    private Order order;
    /**
     * Αρχικοποιεί τον Presenter ώστε να μπορούμε να προσθέσουμε / βρούμε τον μάγειρα και τις παραγγελίες του
     * @param chefDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τους μάγειρες και μπορούμε και προσθέτουμε/λαμβάνουμε μάγειρες
     * @param orderDAO αντικείμενο όπου περιέχουμε την στατική λίστα με τις συνολικές παραγγελίες και μπορούμε και προσθέτουμε/λαμβάνουμε παραγγελίες συγκεκριμένου μάγειρα
     */
    public ChefOrderDetailsPresenter(ChefDAO chefDAO, OrderDAO orderDAO){
        this.chefDAO=chefDAO;
        this.orderDAO=orderDAO;
    }

    /**
     * Γεμίζει την λίστα με τα Order Lines της συγκεκριμένης παραγγελίας
     */
    public void setOrderLineList() {
        orderLineList = order.getOrderLines();
    }

    /**
     *Σετάρει το αντικείμενο view μας για να χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Ένα instance του view
     */
    public void setView(ChefOrderDetailsView view){
        this.view=view;
    }

    /**
     * Επιστρέφει το chef dao που πήραμε σαν παράμετρο παραπάνω
     * @return το instance του dao
     */
    public ChefDAO getChefDAO(){
        return this.chefDAO;
    }
    /**
     * Επιστρέφει το order dao που πήραμε σαν παράμετρο παραπάνω
     * @return το instance του dao
     */
    public OrderDAO getOrderDAO(){
        return this.orderDAO;
    }

    /**
     * Βρίσκει τον μάγειρα της παραγγελίας μέσω του dao Και μέσω του μοναδικού chef id που περνάμε
     * @param chefId το μοναδικό id του μάγειρα
     */
    public void setChef(int chefId) {
        chef = chefDAO.find(chefId);
    }

    /**
     * Βρίσκει την παραγγελία που έχει επιλέξει ο μάγειρας μέσω του μοναδικού order id που περνάμε
     * @param orderId το μοναδικό id της παραγγελίας
     */
    public void setOrder(int orderId){
        order= orderDAO.find(orderId);
    }

    /**
     * Επιστρέφει την λίστα με τα Order Lines της παραγγελίας
     * @return η λίστα με τα Order Lines
     */
    public ArrayList<OrderLine> getOrderLineList(){
        return this.orderLineList;
    }

    /**
     * Καλεί τις μεθόδους του view που εμφανίζουν στην οθόνη τα στοιχεία της παραγγελίας
     */
    public void setOrderDetails(){
        view.setOrderId(String.valueOf(order.getId()));
        view.setOrderState(String.valueOf(order.getOrderState()));
        view.setTableNumber(String.valueOf(order.getTableNumber()));
        view.setDate(String.valueOf(order.getDate().getDayOfMonth()+" "+order.getDate().getMonth()+" "+order.getDate().getYear() +" Time:"+ order.getDate().getHour()) + ":"+String.valueOf(order.getDate().getMinute()));
    }

    /**
     * Καλείται όταν πατηθεί το κουμπί ολοκήρωσης της παραγγελίας
     * Ελέγχει αν η κατάσταση δεν είναι ακυρωμένη και αν δεν είναι ήδη ολοκληρωμένη
     * και κάνει την κατάστασή της σε ολοκληρωμένη
     */
    public void onCompleted() {
        if (order.getOrderState() != Order.State.CANCELLED && order.getOrderState() != Order.State.COMPLETED) {
            order.setStateCompleted(); // η μέθοδος αυτή αφαιρεί και τα λεφτά απο τον πελάτη
            view.setOrderState(String.valueOf(order.getOrderState()));
            view.showOrderCompletedMessage();
        }
    }
    /**
     * Καλεί την μέθοδο του view που μας πηγαίνει στο προηγούμενο activity που μας κάλεσε
     */
    public void OnBack(){
        view.goBack();
    }

    public ChefOrderDetailsView getView(){
        return this.view;
    }
    public Chef getChef(){
        return this.chef;
    }
    public Order getOrder(){
        return this.order;
    }
}
