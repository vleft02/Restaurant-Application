package gr.aueb.softeng.memoryDao;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;

public class CustomerDAOmemory implements CustomerDAO{
    protected static ArrayList<Customer> entities = new ArrayList<>();
    @Override
    public void delete(Customer entity) {
        entities.remove(entity);
    }

    @Override
    public void delete(int id) {
        for (Customer cust: entities){
            if (cust.getUserId()==id){
                entities.remove(cust);
                break;
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        ArrayList<Customer> result= new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Customer entity) {
        entities.add(entity);
    }

    @Override
    public Customer find(Customer entity) {
        for(Customer cust: entities){
            if(cust==entity){
                return cust;
            }
        }
        return null;
    }

    @Override
    public Customer find(String username,String password) {
        for(Customer cust: entities){
            if(cust.getUsername().equals(username) && cust.getPassword().equals(password)){
                return cust;
            }
        }
        return null;
    }

    @Override
    public Customer find(int id) {
        for(Customer cust: entities){
            if(cust.getUserId()==id){
                return cust;
            }
        }
        return null;
    }

    @Override
    public int nextId() {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getUserId()+1 : 1);
    }
}
