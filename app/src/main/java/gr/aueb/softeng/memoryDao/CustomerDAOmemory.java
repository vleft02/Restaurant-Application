package gr.aueb.softeng.memoryDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.User;

public class CustomerDAOmemory implements CustomerDAO {
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
    public Customer find(String username, String password) {
        for(Customer cust: entities){
            if(username.equals(cust.getUsername())&& password.equals(cust.getPassword())){
                return cust;
            }
        }
        return null;
    }
    @Override
    public Customer find(String username)
    {
        for(Customer cust: entities){
            if(username.equals(cust.getUsername())){
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
        return (UserDAOmemory.entities.size() > 0 ? UserDAOmemory.entities.get(UserDAOmemory.entities.size()-1).getUserId()+1 : 1);
    }
}
