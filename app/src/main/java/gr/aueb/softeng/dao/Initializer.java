package gr.aueb.softeng.dao;

import java.time.LocalDateTime;
import java.util.Date;

import gr.aueb.softeng.domain.Address;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Customer;
import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;

public abstract class Initializer {


    public abstract void eraseAll();
    public void prepareData()
    {
        UserDAO userDAO = getUserDAO();
        ChefDAO chefDAO = getChefDAO();
        Chef chef = new Chef("platias","kwnnn","papapap","101010101010","@","123456789",chefDAO.nextId(),"12121212121","12122211");
        chefDAO.save(chef);
        userDAO.save(chef);

        CustomerDAO customerDAO = getCustomerDAO();
        Customer customer = new Customer("kostas123", "Kostas","Papadopoulos", "6972169794","kostas@gmail.com", "123456789", customerDAO.nextId(), "13241341341313421","Kostas Papadopoulos","123");
        customerDAO.save(customer);
        userDAO.save(customer);
        customer.topUp(1000);
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
        rest.addChef(chef);
        ownerDAO.find(owner.getUserId()).addRestaurant(rest);
        Restaurant rest2 = new Restaurant(restaurantDAO.nextId(), "Kafeteria","2105347234",12,new Address(13,"panagias",122333,"exraxeia"));
        restaurantDAO.save(rest2);
        ownerDAO.find(owner.getUserId()).addRestaurant(rest2);
     /*  restaurantDAO.save(new Restaurant(restaurantDAO.nextId(), "Pitogyra","2105347234",12,new Address(14,"agioy ioannou",122333,"exraxeia")));
        */OrderDAO orderDAO = getOrderDAO();
        orderDAO.save(new Order(12, LocalDateTime.of(2023,10,12,10,12),orderDAO.nextId(),customerDAO.find("kostas123")));
        Order order1 = new Order(10, LocalDateTime.of(2023,10,12,10,12),orderDAO.nextId(),customerDAO.find("kostas123"));
        //order.setStateCompleted();
        orderDAO.save(order1);
        Order order2 = new Order(10, LocalDateTime.of(2023,10,12,10,12),orderDAO.nextId(),customerDAO.find("kostas123"));
        //order.setStateCancelled();
        orderDAO.save(order2);
        Order order3 = new Order(12,LocalDateTime.of(2023,10,12,10,12),orderDAO.nextId(),customerDAO.find("kostas123"));
        orderDAO.save(order3);
        orderDAO.save(new Order(14, LocalDateTime.of(2023,10,12,3,55,23),orderDAO.nextId(),customerDAO.find("priamoss")));
        orderDAO.save(new Order(13,LocalDateTime.of(2023,10,12,3,55,23),orderDAO.nextId(),customerDAO.find("adreas:)")));
        //ARXIKOPOIOUME KAI PIATA KAI RESTAURANTS EDO

        chef.addOrder(order1);
        chef.addOrder(order2);
        chef.addOrder(order3);

        Dish dish1 = new Dish(1,"patates",10);
        Dish dish2= new Dish(2,"krema",3);
        Dish dish3 = new Dish(3,"kreas",10);

        DishDAO dishDAO = getDishDAO();
        dishDAO.save(dish1);
        dishDAO.save(dish2);
        dishDAO.save(dish3);
        rest.addDish(dish1);
        rest.addDish(dish2);
        rest.addDish(dish3);

        OrderLine o1 = new OrderLine(10,dish1);
        OrderLine o2 = new OrderLine(3,dish2);
        OrderLine o3 = new OrderLine(1,dish3);

        order1.addOrderLine(o1);
        order1.addOrderLine(o2);
        order1.addOrderLine(o3);
    }

    public abstract ChefDAO getChefDAO();
    public abstract CustomerDAO getCustomerDAO();
    public abstract OwnerDAO getOwnerDAO();
    public abstract DishDAO getDishDAO();
    public abstract UserDAO getUserDAO();


    public abstract RestaurantDAO getRestaurantDAO();

    public abstract OrderDAO getOrderDAO();


}
