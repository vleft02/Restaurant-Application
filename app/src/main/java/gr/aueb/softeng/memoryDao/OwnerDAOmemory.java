package gr.aueb.softeng.memoryDao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Owner;

public class OwnerDAOmemory implements OwnerDAO {
    protected static ArrayList<Owner> owners = new ArrayList<>();
    @Override
    public void delete(Owner owner) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Owner> findAll() {
        return null;
    }

    @Override
    public void save(Owner owner) {
        if (owner!=null) {
            owners.add(owner);
        }
    }

    @Override
    public Owner find(Owner owner) {
        return null;
    }

    @Override
    public Owner find(int id) {
        return null;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
