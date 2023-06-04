package gr.aueb.softeng.memoryDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public class RestaurantDAOmemory implements RestaurantDAO {
    protected static ArrayList<Restaurant> entities = new ArrayList<>();
    @Override
    public void delete(Restaurant entity) {
        entities.remove(entity);
    }

    @Override
    public void delete(int id) {
        for(Restaurant rest: entities){
            if(rest.getId()==id){
                entities.remove(rest);
            }
        }
    }
    @Override
    public Restaurant find(String name) {
        for(Restaurant rest: entities){
            if(rest.getRestaurantName().equals(name)){
                return rest;
            }
        }
        return null;
    }
    @Override
    public List<Restaurant> findAll() {
        ArrayList<Restaurant> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }



    @Override
    public void save(Restaurant entity) {
        entities.add(entity);
    }

    @Override
    public Restaurant find(int id) {
        for(Restaurant rest: entities){
            if(rest.getId()==id){
                return rest;
            }
        }
        return null;
    }

    @Override
    public int nextId() {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getId()+1 : 1);
    }
}
