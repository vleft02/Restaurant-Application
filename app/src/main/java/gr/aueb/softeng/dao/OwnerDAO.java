package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Owner;

public interface OwnerDAO {
    void delete(Owner owner);

    void delete(int id);

    List<Owner> findAll();

    void save(Owner owner);

    Owner find(Owner owner);

    Owner find(int id);

    int nextId();
}
