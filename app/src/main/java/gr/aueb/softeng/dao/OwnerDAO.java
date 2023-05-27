package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Owner;

public interface OwnerDAO {
    void delete(Owner entity);

    void delete(int id);

    List<Owner> findAll();

    void save(Owner entity);

    Owner find(String username, String password);

    Owner find(int id);

    int nextId();
}
