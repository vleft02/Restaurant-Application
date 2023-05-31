package gr.aueb.softeng.dao;

import java.util.Date;

import gr.aueb.softeng.domain.Address;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;

public abstract class Initializer {


    public abstract void eraseAll();
    public void prepareData()
    {
        UserDAO userDAO = getUserDAO();
        ChefDAO chefDAO = getChefDAO();

        chefDAO.save(new Chef("chef1","Kostas","Pappas","2105647839", "chef1@gmail.com","123456789", chefDAO.nextId(), "12341324134123","1324132412341"));
        chefDAO.save(new Chef("chef2","Gianis","Pappas","2105784903", "chef2@gmail.com","123456789", chefDAO.nextId(), "12341324134123","1324132456789"));
        chefDAO.save(new Chef("chef3","Adreas","Pappas","2105647839", "chef3@gmail.com","123456789", chefDAO.nextId(), "12341324134123","1324132565433"));

        CustomerDAO customerDAO = getCustomerDAO();
        Customer customer = new Customer("kostas123", "Kostas","Papadopoulos", "6972169794","kostas@gmail.com", "123456789", customerDAO.nextId(), "13241341341313421","Kostas Papadopoulos","123");
        customerDAO.save(customer);
        userDAO.save(customer);
        customer = new Customer("priamoss", "Priamos","Alafouzos", "2105789235","priamos@gmail.com", "123456789", customerDAO.nextId(), "13241342345678897","Priamos Alafouzos","234");
        customerDAO.save(customer);
        userDAO.save(customer);
        customer = new Customer("adreas:)", "Antreas","Antreopoulos", "2113335867","adreas@gmail.com", "123456789", customerDAO.nextId(), "14353452435523245","Kostas Papadopoulos","678");
        customerDAO.save(customer);
        userDAO.save(customer);

        OwnerDAO ownerDAO = getOwnerDAO();
        Owner owner = new Owner("owner1","Kostas","Pappas","2105648463", "owner1@gmail.com","123456789", ownerDAO.nextId(), "12341324134123","132413566767");
        ownerDAO.save(owner);
        userDAO.save(owner);
        owner = new Owner("owner2","Kostas","Pappas","2105644875", "owner2@gmail.com","123456789", ownerDAO.nextId(), "12341324134123","132413566767");
        ownerDAO.save(owner);
        userDAO.save(owner);
        owner = new Owner("owner3","Kostas","Pappas","2105456237", "owner3@gmail.com","123456789", ownerDAO.nextId(), "12341324134123","132413566767");
        ownerDAO.save(owner);
        userDAO.save(owner);


        RestaurantDAO restaurantDAO = getRestaurantDAO();
        Restaurant rest = new Restaurant(restaurantDAO.nextId(), "Taverna","2105347953",12,new Address(12,"Stratigou",122333,"Menidi"));
        restaurantDAO.save(rest);
        ownerDAO.find(4).addRestaurant(rest);
        rest = new Restaurant(restaurantDAO.nextId(), "Kafeteria","2105347234",12,new Address(13,"panagias",122333,"exraxeia"));
        restaurantDAO.save(rest);
        ownerDAO.find(4).addRestaurant(rest);
        restaurantDAO.save(new Restaurant(restaurantDAO.nextId(), "Pitogyra","2105347234",12,new Address(14,"agioy ioannou",122333,"exraxeia")));
        rest = null;
        OrderDAO orderDAO = getOrderDAO();
        orderDAO.save(new Order(12,new Date(),customerDAO.find("kostas123")));
        orderDAO.save(new Order(14,new Date(),customerDAO.find("priamoss")));
        orderDAO.save(new Order(13,new Date(),customerDAO.find("adreas:)")));
        //ARXIKOPOIOUME KAI PIATA KAI RESTAURANTS EDO
    }

    public abstract ChefDAO getChefDAO();
    public abstract CustomerDAO getCustomerDAO();
    public abstract OwnerDAO getOwnerDAO();
    public abstract DishDAO getDishDAO();
    public abstract UserDAO getUserDAO();


    public abstract RestaurantDAO getRestaurantDAO();

    public abstract OrderDAO getOrderDAO();


}
