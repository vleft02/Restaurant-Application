package gr.aueb.softeng.memoryDao;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.domain.Customer;

public class CustomerDAOmemory implements CustomerDAO{
    protected static ArrayList<Customer> customers = new ArrayList<>();
    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {
        if (customer!=null) {
            customers.add(customer);
        }
    }

    @Override
    public Customer find(Customer customer) {
        return null;
    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
