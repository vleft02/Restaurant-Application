package gr.aueb.softeng.view.Customer.HomePage;

import android.view.View;

import androidx.fragment.app.Fragment;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Restaurant;

public class CustomerHomepagePresenter {
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;
    private RestaurantDAO restaurantDAO;
    private CustomerHomepageView view;
    private Order currentOrder;
    private Customer customer;
    private Restaurant restaurant;

    private ArrayList<Order> orderHistory;

    /**
     * Αρχικοποιεί τον Presenter έτσι ώστε
     * να μπορούμε να πραγματόποιήσουμε τις
     * απαραίτητες λειτουργίες του customer
     * @param customerDAO αντικείμενο τυπου CustomerDAO
     * @param orderDAO αντικείμενο τυπου OrderDAO
     * @param restaurantDAO αντικείμενο τυπου RestaurantDAO
     */
    public CustomerHomepagePresenter(CustomerDAO customerDAO, OrderDAO orderDAO,RestaurantDAO restaurantDAO)
    {
        this.customerDAO = customerDAO;
        this.orderDAO = orderDAO;
        this.restaurantDAO = restaurantDAO;
        orderHistory = new ArrayList<>();
    }

    /**
     * Σετάρουμε την μεταβλητη restaurant
     * βρίσκοντας τον απο το RestaurantDAO
     * μέσω του id που δίνεται
     * @param restaurantId το id του εστιατορίου
     */
    public void setRestaurant(int restaurantId) {
        restaurant = restaurantDAO.find(restaurantId);
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }
    /**
     * Σετάρουμε την μεταβλητη customer
     * βρίσκοντας τον απο το CustomerDAO
     * μέσω του id
     * @param id το id του πελάτη
     */
    public void setCustomer(int id) {
        this.customer = customerDAO.find(id);
    }

    /**
     * Σετάρουμε την λίστα orderHistory
     * βρίσκοντας απο το orderDAO
     * ποιές παράγγελίες απο τον σεταρισμένο customer
     * είναι ολοκληρωμένες ή ακυρωμένες και
     * προστιθοντας τες στο orderHistory
     */
    public void setOrderHistory()
    {
        orderHistory = new ArrayList<>();
        ArrayList<Order> orders = (ArrayList<Order>) orderDAO.findByCustomer(customer);
        if (customer!=null)
        {
            for (Order order : orders)
            {
                if (order.getOrderState() == Order.State.COMPLETED || order.getOrderState() == Order.State.CANCELLED ||!orders.contains(order))
                {
                    orderHistory.add(order);
                }
            }
        }
    }

    /**
     * Σετάρουμε την μεταβλητη currentOrder
     * με την παραγγελία του σεταρισμένου
     * πελάτη που δεν είναι ακυρωμένη ή ολοκληρωμένη
     * εαν αυτή υπάρχει.
     * (Δεν είναι δυνατόν να υπάρχουν παραπάνω απο μια τέτοιες)
     */
    public void setCurrentOrder()
    {
        ArrayList<Order> orders = (ArrayList<Order>) orderDAO.findByCustomer(customer);
        currentOrder = null;
        if (orders!=null) {
            for (Order order : orders) {
                if (order.getOrderState() != Order.State.COMPLETED && order.getOrderState() != Order.State.CANCELLED) {
                    currentOrder = order;
                }
            }
        }
    }
    public Order getCurrentOrder()
    {
        return currentOrder;
    }

    /**
     * Επιστρέφει τον customer
     * @return Το αντικέμενο πελατη τυπου Customer
     */
    public Customer getCustomer() {
        return customer;
    }


    /**
     * επιστρέφει την λιστα orderHistory
     * @return ArrayList<Order> με τις ανανεργές παραγγελίες
     */
    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }
    /**
     * Επιστρέφει τον customer
     * @param view ενα instance του view
     */
    public void setView(CustomerHomepageView view) {
        this.view = view;
    }

    /**
     * Επιστρέφει το instance του view
     */
    public CustomerHomepageView getView() {
        return view;
    }

    /**
     * Επιστρέφει τα στοιχεία μιας παραγγελίας
     * @return ένα String με τα στοιχεία της παραγγελίας currentOrder
     */
    public String getCurrentOrderDetails() {
        String output = "";
        if(currentOrder != null)
        {
            output += "#"+currentOrder.getId()+"\n";
            output += currentOrder.getOrderState().toString()+"\n";
            output += currentOrder.getDate().getDayOfMonth() + " " + currentOrder.getDate().getMonth() +" " + currentOrder.getDate().getYear();
            output += "\n" + currentOrder.getDate().getHour() +":"+currentOrder.getDate().getMinute();
            output += "\n" + String.format("%.2f",currentOrder.getTotalCost()) + " €";
        }

        return output;
    }


    public void onCancel()
    {
        view.ShowConfirmationMessage();
    }


    /**
     * Ακύρωση της currentOrder
     * που προκαλέι αλλαγή του layout
     * και της λιστας orderHistory
     * αλλα και αφαίρεση της απο την λίστα
     * παραγγελιών προς προετοιμασία απο τον chef
     */
    public void cancel()
    {
        if(currentOrder!=null){
            currentOrder.setStateCancelled();
            currentOrder = null;
            chooseLayout();
            setOrderHistory();
       }
    }

    /**
     * Αλλάζουμε layout για το currentOrderPageFragment
     * ανάλογα με το αν υπάρχει σεταρισμένη
     * ενεργή παραγγελία ή οχι
     */
    public void chooseLayout() {

        if (currentOrder!=null)
        {
            view.showCurrentOrder();
        }
        else{

            view.showNoCurrentOrder();
        }
    }

    /**
     * κλήση της redirectTopUp() στο
     * activity μέσω του interface customerHomePageView
     * για προώθηση στο top Up activity
     */
    public void onTopUp() {
        view.redirectTopUp();
    }



    /**
     * επιστρέφει τον μέγιστο αριθμό
     * τραπεζιών του εστιατορίου
     * @return εναν ακεραιο που δείχνει το πλήθος τραπεζιών του εσταιτορίου
     */
    public int getRestaurantCapacity() {
        if (restaurant!=null) {
            return restaurant.getTotalTables();
        }
        else
        {
            return 0;
        }
    }

    /**
     * Επιστρέφει false εαν υπάρχει ενεργή
     * παραγγελία στο σεταρισμένο εστιατόριο
     * στο τραπέζι που έχει επιλεγεί
     * και true αν οχι
     * @param tableNumber ο αριθμος ενός τραπεζίου
     * @return true ή false
     */
    public boolean checkTableAvailability(int tableNumber) {
        if (restaurant != null) {
            ArrayList<Order> orders = restaurant.getOrders();
            for (Order order : orders) {
                if (order.getOrderState() == Order.State.RECEIVED
                        && order.getTableNumber() == tableNumber) {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    public void onPlaceOrder() {
        view.showTableNumberPickerPopup();
    }
}

