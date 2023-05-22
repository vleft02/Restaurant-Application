package gr.aueb.softeng.memoryDao;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;

public class OrderDAOmemory implements OrderDAO{
    protected static ArrayList<Order> entities = new ArrayList<>();
    @Override
    public void delete(Order entity) {
        entities.remove(entity);
    }

    @Override
    public void save(Order entity) {
        entities.add(entity);
    }

    @Override
    public List<Order> findAll() {
        ArrayList<Order> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public Order find(Order entity) {
        for(Order order: entities){
            if(order==entity){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findByCustomer(Customer customer) {
        ArrayList<Order> result= new ArrayList<>();
        for(Order order : entities){
            if(order.getCustomer()==customer){
                result.add(order);
            }
        }
        return  result;
    }

    @Override
    public List<Order> findByCustomer(int id) {
        ArrayList<Order> result= new ArrayList<>();
        for(Order order : entities){
            if(order.getCustomer().getUserId()==id){
                result.add(order);
            }
        }
        return  result;
    }
}
