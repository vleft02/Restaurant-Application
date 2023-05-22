package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public interface RestaurantDAO {
    void delete(Restaurant entity);

    void delete(int id);

    List<Restaurant> findAll();
  //  List<Restaurant> findByOwner(Owner owner);

    void save(Restaurant entity);

    Restaurant find(Restaurant entity);

    Restaurant find(int id);

    int nextId();
}
