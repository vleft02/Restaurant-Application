package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Order;

public interface OrderDAO {
    void delete(Order entity);
    void save(Order entity);
    List<Order> findAll();
    Order find(int id);
    List<Order> findByCustomer(Customer customer);
    int nextId();
}
