package gr.aueb.softeng.view.Customer.HomePage;

import android.view.View;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Order;

public class CustomerHomepagePresenter {
    CustomerDAO customerDAO;
    OrderDAO orderDAO;
    ChefDAO chefDAO;
    CustomerHomepageView view;
    CurrentOrderPageFragment currentOrderPageFragment;
    OrderHistoryPageFragment orderHistoryPageFragment;
    Order currentOrder;
    Customer customer;

    public CustomerHomepagePresenter(CustomerDAO customerDAO, OrderDAO orderDAO,ChefDAO chefDAO)
    {
        this.customerDAO = customerDAO;
        this.orderDAO = orderDAO;
        this.chefDAO = chefDAO;
    }

    public void setCustomer(int id) {
        this.customer = customerDAO.find(id);
    }

    public void setCurrentOrder()
    {
        ArrayList<Order> orders = (ArrayList<Order>) orderDAO.findByCustomer(customer);
        currentOrder = null;
        for (Order order : orders)
        {
            if (order.getOrderState() != Order.State.COMPLETED && order.getOrderState() != Order.State.CANCELLED )
            {
                currentOrder = order;
            }
        }
    }
    public Order getCurrentOrder()
    {
        return currentOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setView(CustomerHomepageView view) {
        this.view = view;
    }

    public void setFragment(Fragment fragment){
        if (fragment instanceof CurrentOrderPageFragment) {
            this.currentOrderPageFragment = (CurrentOrderPageFragment) fragment;

        }
        else
        {
            this.orderHistoryPageFragment = (OrderHistoryPageFragment) fragment;
        }
    }

    public String getCurrentOrderDetails() {
        String output = "";
        if(currentOrder != null)
        {
            output += currentOrder.getOrderState().toString()+"\n";
            output += currentOrder.getOrderState().toString()+"\n";
        }

        return output;
    }

    public void onCancel() {
        view.ShowConfirmationMessage();
    }

    public void cancel()
    {
       if(currentOrder!=null){
            currentOrder.setStateCancelled();
            currentOrder = null;
            chooseLayout();
            //AFAIRESH APO CHEF
       }
    }

    public void chooseLayout() {

        if (currentOrder!=null)
        {
            currentOrderPageFragment.plusButton.setVisibility(View.GONE);
            currentOrderPageFragment.noOrderText.setVisibility(View.GONE);
            currentOrderPageFragment.orderDetails.setText(getCurrentOrderDetails());
            currentOrderPageFragment.cancelButton.setVisibility(View.VISIBLE);
            currentOrderPageFragment.orderDetailsLayout.setVisibility(View.VISIBLE);


        }
        else{
            currentOrderPageFragment.plusButton.setVisibility(View.VISIBLE);
            currentOrderPageFragment.noOrderText.setVisibility(View.VISIBLE);
            currentOrderPageFragment.cancelButton.setVisibility(View.GONE);
            currentOrderPageFragment.orderDetailsLayout.setVisibility(View.GONE);
        }
    }

    public void onTopUp() {
        view.redirectTopUp();
    }
}

