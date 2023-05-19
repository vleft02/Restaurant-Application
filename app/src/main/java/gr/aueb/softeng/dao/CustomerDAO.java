package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Customer;

public interface CustomerDAO {
    void delete(Customer customer);

    void delete(int id);

    List<Customer> findAll();

    void save(Customer customer);

    Customer find(Customer customer);

    Customer find(int id);
    int nextId();
}
