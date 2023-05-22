package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Customer;

public interface CustomerDAO {
    void delete(Customer entity);

    void delete(int id);

    List<Customer> findAll();

    void save(Customer entity);

    Customer find(Customer entity);

    Customer find(int id);
    int nextId();
}
