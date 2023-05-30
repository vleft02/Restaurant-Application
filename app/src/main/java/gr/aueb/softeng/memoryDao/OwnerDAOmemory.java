package gr.aueb.softeng.memoryDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.User;

public class OwnerDAOmemory implements OwnerDAO {
    protected static ArrayList<Owner> entities = new ArrayList<>();
    @Override
    public void delete(Owner entity) {
        entities.remove(entity);
    }

    @Override
    public void delete(int id) {
        for (Owner owner: entities){
            if (owner.getUserId()==id){
                entities.remove(owner);
                break;
            }
        }
    }

    @Override
    public List<Owner> findAll() {
        ArrayList<Owner> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Owner entity) {
        entities.add(entity);
    }

    @Override
    public Owner find(String username, String password) {
        for(Owner owner: entities){
            if(username.equals(owner.getUsername()) && password.equals(owner.getPassword())){
                return owner;
            }
        }
        return null;
    }
    @Override
    public Owner find(String username)
    {
        for(Owner owner: entities){
            if(username.equals(owner.getUsername())){
                return owner;
            }
        }
        return null;
    }

    @Override
    public Owner find(int id) {
        for(Owner owner: entities){
            if(owner.getUserId()==id){
                return owner;
            }
        }
        return null;
    }

    @Override
    public int nextId() {
        return (UserDAOmemory.entities.size() > 0 ? UserDAOmemory.entities.get(UserDAOmemory.entities.size()-1).getUserId()+1 : 1);
    }
}
