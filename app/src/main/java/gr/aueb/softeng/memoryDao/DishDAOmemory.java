package gr.aueb.softeng.memoryDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.DishDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Dish;

public class DishDAOmemory implements DishDAO, Serializable {
    protected static ArrayList<Dish> entities = new ArrayList<>();
    @Override
    public void delete(Dish entity) {
        entities.remove(entity);
    }

    @Override
    public void delete(int id) {
        for (Dish dish: entities){
            if (dish.getId()==id){
                entities.remove(dish);
                break;
            }
        }
    }

    @Override
    public List<Dish> findAll() {
        ArrayList<Dish> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Dish entity) {
        entities.add(entity);
    }

    @Override
    public Dish find(Dish entity) {
        for(Dish dish: entities){
            if(dish==entity){
                return dish;
            }
        }
        return null;
    }

    @Override
    public Dish find(int id) {
        for(Dish dish: entities){
            if(dish.getId()==id){
                return dish;
            }
        }
        return null;
    }

    @Override
    public int nextId() {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getId()+1 : 1);
    }
}