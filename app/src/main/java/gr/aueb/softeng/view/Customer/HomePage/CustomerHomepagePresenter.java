package gr.aueb.softeng.view.Customer.HomePage;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Order;

public class CustomerHomepagePresenter {
    CustomerDAO customerDAO;
    OrderDAO orderDAO;

    CustomerHomepageView view;

    public CustomerHomepagePresenter(CustomerDAO customerDAO, OrderDAO orderDAO)
    {
        this.customerDAO = customerDAO;
        this.orderDAO = orderDAO;
    }

    public Order getCurrentOrder(int customerId)
    {
        ArrayList<Order> orders =  orderDAO.findByCustomer(customerId);
        for (Order order : orders)
        {
            if (order.getOrderState() != Order.State.COMPLETED)
            {
                return order;
            }
        }
        return null;
    }
    public void setView(CustomerHomepageView view) {
        this.view = view;
    }

    public String getCurrentOrderDetails(int customerId) {
        String output = "";
        Order order = getCurrentOrder(customerId);
        output += order.getOrderState().toString()+"\n";
        return output;
    }

    public void onCancel() {
        view.ShowConfirmationMessage();
    }

    public void cancel(int customerId)
    {
        orderDAO.find(getCurrentOrder(customerId)).setStateCancelled();
    }
}

