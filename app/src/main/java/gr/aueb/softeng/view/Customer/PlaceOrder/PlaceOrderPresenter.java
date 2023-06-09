package gr.aueb.softeng.view.Customer.PlaceOrder;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.domain.Restaurant;

public class PlaceOrderPresenter {
    PlaceOrderView view;

    RestaurantDAO restaurantDAO;
    Restaurant restaurant;

    OrderDAO orderDAO;

    Order order;

    CustomerDAO customerDAO;

    Customer customer;

    public PlaceOrderPresenter(RestaurantDAO restaurantDAO,CustomerDAO customerDAO,OrderDAO orderDAO)
    {
        this.restaurantDAO = restaurantDAO;
        this.customerDAO = customerDAO;
        this.orderDAO = orderDAO;
    }

    public void setView(PlaceOrderView view) {
        this.view = view;
    }

    public PlaceOrderView getView() {
        return view;
    }

    /**
     * Παίρνουμε τα πίατα του εστιατορίου για να τα τυπώσουμε
     * @return Τα πίατα του εστιατορίου
     */
    public ArrayList<Dish> getDishes() {
        ArrayList<Dish> dishes = new ArrayList<>();
        if (restaurant!=null)
        {
            for (Dish dish : restaurant.getDishes())
            {
                dishes.add(dish);
            }
        }
        return dishes;
    }

    public void addOrderLine(int quantity,Dish dish) {
       if (dish!=null){
           order.addOrderLine(new OrderLine(quantity,dish));
       }
    }

    public void setRestaurant(int restaurantId) {
        restaurant = restaurantDAO.find(restaurantId);
    }

    /**
     * Εαν έχουμε πίατα δείχνουμε μηνυμα οτι δεν υπάρχουν πιάτα αλλιώς
     * εμφανίζεται η λίστα με τα πίατα
     */
    public void onChangeLayout() {
        if(getDishes().isEmpty())
        {
            view.showEmptyList();
        } else {
            view.showDishList();
        }

    }

    /**
     * Ελέγχουμε εαν η παραγγελία αρχικά έχει orderLines και εαν όχι δεν κανουμε περαιτέρο λειτουργίες
     * αλλιώς ελέγχουμε αν προστίθεται επιτυχώς στο εστιατόριο και σε αυτη την περιπτωση εμφανίζουμε μήνυμα επιβεβαίωσης.
     * Στην περίπτωση που η παραγγελία δεν πορστέθηκε επιτυψώς σημαίνει οτι ο πελάτης δεν έχει το απαραίτητο χρηματικό υπολοιπο
     * και ενημερώνετια για αυτο με μήνυμα.
     */
    public void onPlaceOrder() {
        if (order.getOrderLines().isEmpty())
        {

        }
        else if(restaurant.addOrder(order))
        {
            orderDAO.save(order);
            view.ShowConfirmationMessage();
        }
        else
        {
            view.insufficientFundsMessage();
        }


    }

    public double getTotalCost() {
        return order.getTotalCost();
    }

    public void createOrder(int tableNumber) {
        order = new Order(tableNumber, LocalDateTime.now(),orderDAO.nextId(),customer);
    }

    public void setCustomer(int customerId) {
        customer = customerDAO.find(customerId);
    }

    public Order getOrder()
    {
        return order;
    }
    public Customer getCustomer(){
        return customer;
    }

    public void onCart() {
        view.redirectToCart(order.getOrderLines());
    }

    public void setOrderLines(ArrayList<OrderLine> modifiedOrderLines) {
        order.setOrderLines(modifiedOrderLines);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
