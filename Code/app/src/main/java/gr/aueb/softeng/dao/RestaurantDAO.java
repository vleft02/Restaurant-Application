package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Restaurant;

public interface RestaurantDAO {
    void delete(Restaurant entity);

    void delete(int id);

    void deleteAll();
    List<Restaurant> findAll();

    void save(Restaurant entity);

    Restaurant find(int id);
    Restaurant find(String name);

    int nextId();
}
