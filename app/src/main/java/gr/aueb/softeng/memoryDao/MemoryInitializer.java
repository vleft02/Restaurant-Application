package gr.aueb.softeng.memoryDao;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.DishDAO;
import gr.aueb.softeng.dao.Initializer;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;

public class MemoryInitializer extends Initializer {
    @Override
    public void eraseAll() {
        //me for loop kanoume apo ta dao delete ola ta periexomena
    }

    @Override
    public ChefDAO getChefDAO() {
        return new ChefDAOmemory();
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOmemory();
    }

    @Override
    public OwnerDAO getOwnerDAO() {
        return new OwnerDAOmemory();
    }

    @Override
    public DishDAO getDishDAO() {
        return new DishDAOmemory();
    }

    @Override
    public RestaurantDAO getRestaurantDAO() {
        return new RestaurantDAOmemory();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOmemory();
    }

}
