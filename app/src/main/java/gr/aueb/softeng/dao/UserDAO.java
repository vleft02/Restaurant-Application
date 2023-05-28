package gr.aueb.softeng.dao;


import java.util.List;

import gr.aueb.softeng.domain.User;

public interface UserDAO {
    void delete(User entity);

    void delete(int id);

    List<User> findAll();

    void save(User entity);

    User find(String username, String password);

    User find(String username);

    User find(int id);
}
