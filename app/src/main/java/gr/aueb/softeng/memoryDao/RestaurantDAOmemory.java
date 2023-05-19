package gr.aueb.softeng.memoryDao;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;

public class RestaurantDAOmemory implements RestaurantDAO{
    protected static ArrayList<Restaurant> restaurants = new ArrayList<>();
    @Override
    public void delete(Restaurant restaurant) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Restaurant> findAll() {
        return null;
    }

    @Override
    public List<Restaurant> findByOwner(Owner owner) {
        return null;
    }

    @Override
    public void save(Restaurant restaurant) {
        if (restaurant!=null) {
           restaurants.add(restaurant);
        }
    }

    @Override
    public Restaurant find(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant find(int id) {
        return null;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
