package gr.aueb.softeng.memoryDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.User;

public class ChefDAOmemory implements ChefDAO {
    protected static ArrayList<Chef> entities = new ArrayList<>();
    @Override
    public void delete(Chef entity) {
        entities.remove(entity);
    }

    @Override
    public void delete(int id) {
        for (Chef chef: entities){
            if (chef.getUserId()==id){
                entities.remove(chef);
                break;
            }
        }
    }

    @Override
    public List<Chef> findAll() {
        ArrayList<Chef> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Chef entity) {
        entities.add(entity);
    }

    @Override
    public Chef find(String username, String password) {
        for(Chef chef: entities){
            if(username.equals(chef.getUsername()) && password.equals(chef.getPassword())){
                return chef;
            }
        }
        return null;
    }

    @Override
    public Chef find(String username)
    {
        for(Chef chef: entities){
            if(username.equals(chef.getUsername())){
                return chef;
            }
        }
        return null;
    }

    @Override
    public Chef find(int id) {
        for(Chef chef: entities){
            if(chef.getUserId()==id){
                return chef;
            }
        }
        return null;
    }

    @Override
    public int nextId() {
        return (UserDAOmemory.entities.size() > 0 ? UserDAOmemory.entities.get(UserDAOmemory.entities.size()-1).getUserId()+1 : 1);
    }
}
