package gr.aueb.softeng.memoryDao;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;

public class OrderDAOmemory implements OrderDAO{
    protected static ArrayList<Order> orders = new ArrayList<>();
    @Override
    public void delete(Order order) {

    }

    @Override
    public void save(Order order) {
        if (order!=null) {
            orders.add(order);
        }
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order find(Order order) {
        return null;
    }

    @Override
    public List<Order> findByCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Order> findByCustomer(int id) {
        return null;
    }
}
