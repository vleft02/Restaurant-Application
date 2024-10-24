package gr.aueb.softeng.dao;

import java.util.ArrayList;
import java.util.List;


import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public interface OwnerDAO {
    void delete(Owner entity);

    void delete(int id);

    void deleteAll();

    List<Owner> findAll();

    void save(Owner entity);
    Owner find(String username);
    Owner find(String username, String password);

    Owner find(int id);

    ArrayList<Restaurant> findRestaurants(int id);

    int nextId();
}
