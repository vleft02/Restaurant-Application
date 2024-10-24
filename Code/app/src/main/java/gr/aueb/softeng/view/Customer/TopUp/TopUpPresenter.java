package gr.aueb.softeng.view.Customer.TopUp;


import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.domain.Customer;

public class TopUpPresenter {
    private TopUpView view;
    private CustomerDAO customerDAO;
    private Customer customer;
    public TopUpPresenter(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void setView(TopUpView view) {
        this.view = view;
    }

    public TopUpView getView() {
        return view;
    }

    public void setCustomer()
    {
        customer = customerDAO.find(view.getCustomerId());
    }

    public Customer getCustomer() {
        return customer;
    }


    /**
     * Εαν το instance του πελάτη δεν είναι null εμφανίζουμε το χρηματικό του υπόλοιπο
     * αλλιως εμφανίζουμε Error
     */
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

    /**
     * Εαν το instance του πελάτη δεν είναι null
     * του προσθέτουμε ένα χρηματικό ποσό και
     * καλούμε SetLayout() για να ανανεώσουμε
     * το υπολοιπο που φαίνεται στην οθόνη
     */
    public void onTopUp(double amount) {
        if(customer!=null) {
            customer.topUp(amount);
            setLayout();
        }
    }
}
