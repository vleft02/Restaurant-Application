package gr.aueb.softeng.view.Customer.TopUp;

import gr.aueb.softeng.view.View;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.domain.Customer;

public class TopUpPresnter {
    TopUpView view;
    CustomerDAO customerDAO;
    Customer customer;
    public TopUpPresnter(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void setView(TopUpView view) {
        this.view = view;
    }
    public void setCustomer()
    {
        customer = customerDAO.find(view.getCustomerId());
    }

    public void setLayout() {
        if (customer!=null)
        {
            String balance = String.format("%.2f",customer.getBalance());
            view.setBalance(balance + " €");
        }
        else
        {
            view.setBalance("ERROR");
        }

    }

    public void onTopUp(double amount) {
        if(customer!=null) {
            customer.topUp(amount);
            setLayout();
        }
    }
}
