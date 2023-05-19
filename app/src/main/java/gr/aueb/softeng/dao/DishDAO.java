package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Dish;

public interface DishDAO {
    void delete(Dish dish);

    void delete(int id);

    List<Dish> findAll();

    void save(Dish dish);

    Dish find(Dish dish);

    Dish find(int id);

    int nextId();
}
