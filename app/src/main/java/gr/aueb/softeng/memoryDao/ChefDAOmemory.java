package gr.aueb.softeng.memoryDao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.domain.Chef;

public class ChefDAOmemory implements ChefDAO{
    protected static ArrayList<Chef> chefs = new ArrayList<>();
    @Override
    public void delete(Chef chef) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Chef> findAll() {
        return null;
    }

    @Override
    public void save(Chef chef) {
        if (chef!=null) {
            chefs.add(chef);
        }
    }


    @Override
    public Chef find(Chef chef) {
        return null;
    }

    @Override
    public Chef find(int id) {
        return null;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
