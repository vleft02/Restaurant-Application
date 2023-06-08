package gr.aueb.softeng.dao;

import java.util.List;

import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.User;

public interface ChefDAO {
    void delete(Chef entity);

    void delete(int id);

    void deleteAll();
    List<Chef> findAll();

    void save(Chef entity);

    Chef find(String username, String password);
    Chef find(int id);
    Chef find(String username);
    int nextId();
}
