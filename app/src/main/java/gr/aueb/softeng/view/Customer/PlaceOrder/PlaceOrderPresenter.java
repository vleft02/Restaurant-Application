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

    public ArrayList<Dish> getDishes() {
        ArrayList<Dish> dishes = new ArrayList<>();
/*        if (restaurant!=null)
        {
            for (Dish dish : restaurant.getDishes())
            {
                dishes.add(dish);
            }
        }*/
        dishes.add(new Dish(0,"Mpifteki",20.0));
        dishes.add(new Dish(1,"Koka Kola",15.0));
        dishes.add(new Dish(2,"Pizza",25.0));
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

    public void onChangeLayout() {
        if(getDishes().isEmpty())
        {
            view.showEmptyList();
        } else {
            view.showDishList();
        }

    }

    public void onPlaceOrder() {
        if (order.getOrderLines().isEmpty())
        {

        }
        else if(restaurant.addOrder(order))
        {
            orderDAO.save(order);
            view.orderSuccess();
        }
        else
        {
            view.orderFailed();
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

    public void onCart() {
        view.redirectToCart(order.getOrderLines());
    }

    public void setOrderLines(ArrayList<OrderLine> modifiedOrderLines) {
        order.setOrderLines(modifiedOrderLines);
    }
}
