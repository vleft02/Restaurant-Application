package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.User;

public interface CustomerDAO {
    void delete(Customer entity);

    void delete(int id);

    void deleteAll();

    List<Customer> findAll();

    void save(Customer entity);

    Customer find(String username, String password);
    Customer find(String username);

    Customer find(int id);
    int nextId();
}
