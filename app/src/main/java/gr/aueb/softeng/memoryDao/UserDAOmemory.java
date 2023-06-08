package gr.aueb.softeng.memoryDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.User;

public class UserDAOmemory implements UserDAO{
    protected static ArrayList<User> entities = new ArrayList<>();
    @Override
    public void delete(User entity) {
        entities.remove(entity);
    }

    @Override
    public void delete(int id) {
        for (User user: entities){
            if (user.getUserId()==id){
                entities.remove(user);
                break;
            }
        }

    }

    @Override
    public void deleteAll() {
        entities.clear();
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(User entity) {
        entities.add(entity);
    }

    @Override
    public User find(String username, String password) {
        for(User user: entities){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User find(String username)
    {
        for(User user: entities){
            if(username.equals(user.getUsername())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User find(int id) {
        for(User user: entities){
            if(user.getUserId()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public int size()
    {
        return entities.size();
    }
}
