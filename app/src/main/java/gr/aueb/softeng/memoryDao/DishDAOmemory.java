package gr.aueb.softeng.memoryDao;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.DishDAO;
import gr.aueb.softeng.domain.Dish;

public class DishDAOmemory implements DishDAO{
    protected static ArrayList<Dish> dishes = new ArrayList<>();
    @Override
    public void delete(Dish dish) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Dish> findAll() {
        return null;
    }

    @Override
    public void save(Dish dish) {
        if (dish!=null) {
           dishes.add(dish);
        }
    }

    @Override
    public Dish find(Dish dish) {
        return null;
    }

    @Override
    public Dish find(int id) {
        return null;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
