package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Chef;
public interface ChefDAO {
    void delete(Chef chef);

    void delete(int id);

    List<Chef> findAll();

    void save(Chef chef);

    Chef find(Chef chef);

    Chef find(int id);
    int nextId();
}
