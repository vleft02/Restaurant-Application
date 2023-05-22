package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Chef;
public interface ChefDAO {
    void delete(Chef entity);

    void delete(int id);

    List<Chef> findAll();

    void save(Chef entity);

    Chef find(Chef entity);

    Chef find(int id);
    int nextId();
}
