package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Dish;

public interface DishDAO {
    void delete(Dish entity);

    void delete(int id);
    void deleteAll();

    List<Dish> findAll();

    void save(Dish entity);
    Dish find(int id);

    int nextId();
}
