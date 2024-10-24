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


    public void eraseAll()
    {
        UserDAO userDAO = getUserDAO();
        ChefDAO chefDAO = getChefDAO();
        CustomerDAO customerDAO = getCustomerDAO();
        RestaurantDAO restaurantDAO = getRestaurantDAO();
        OrderDAO orderDAO = getOrderDAO();
        OwnerDAO ownerDAO = getOwnerDAO();
        DishDAO dishDAO = getDishDAO();

        userDAO.deleteAll();
        chefDAO.deleteAll();
        customerDAO.deleteAll();
        orderDAO.deleteAll();
        restaurantDAO.deleteAll();
        ownerDAO.deleteAll();
        dishDAO.deleteAll();
    }
    public void prepareData()
    {
        LocalDateTime now = LocalDateTime.now();
        UserDAO userDAO = getUserDAO();
        ChefDAO chefDAO = getChefDAO();
        CustomerDAO customerDAO = getCustomerDAO();
        RestaurantDAO restaurantDAO = getRestaurantDAO();
        OrderDAO orderDAO = getOrderDAO();
        OwnerDAO ownerDAO = getOwnerDAO();
        DishDAO dishDAO = getDishDAO();

        //NEW CHEF/////////////////////////////////////
        Chef chef = new Chef("platias","kwnnn","papapap","101010101010","@","123456789",chefDAO.nextId(),"12121212121","12122211");
        chefDAO.save(chef);
        userDAO.save(chef);

        Chef chef2 = new Chef("vaggelis","euaggelos","leftakis","101010101010","@","123456789",chefDAO.nextId(),"12121212121","12122211");
        chefDAO.save(chef2);
        userDAO.save(chef2);


        //NEW CUSTOMERS////////////////////////////////

        Customer customer = new Customer("testCustomer", "mpampis","andreopoulos", "6972169794","b@gmail.com", "123456789", customerDAO.nextId(), "13241341341313421","Kostas Papadopoulos","123");
        customerDAO.save(customer);
        userDAO.save(customer);
        customer.getBalance();

        customer = new Customer("kostas123", "Kostas","Papadopoulos", "6972169794","kostas@gmail.com", "123456789", customerDAO.nextId(), "13241341341313421","Kostas Papadopoulos","123");
        customerDAO.save(customer);
        userDAO.save(customer);
        customer.topUp(1000);

        customer = new Customer("priamoss", "Priamos","Alafouzos", "2105789235","priamos@gmail.com", "123456789", customerDAO.nextId(), "13241342345678897","Priamos Alafouzos","234");
        customerDAO.save(customer);
        userDAO.save(customer);

        customer = new Customer("adreas:)", "Antreas","Antreopoulos", "2113335867","adreas@gmail.com", "123456789", customerDAO.nextId(), "14353452435523245","Kostas Papadopoulos","678");
        customerDAO.save(customer);
        userDAO.save(customer);
        customer.topUp(10000);
//NEW OWNERS///////////////////////////////////////
        Owner owner1 = new Owner("owner1","Kostas","Pappas","2105648463", "owner1@gmail.com","123456789", ownerDAO.nextId(), "12341324134123","132413566767");
        ownerDAO.save(owner1);
        userDAO.save(owner1);

        Owner owner2 = new Owner("owner2","Kostas","Pappas","2105644875", "owner2@gmail.com","123456789", ownerDAO.nextId(), "12341324134123","132413566767");
        ownerDAO.save(owner2);
        userDAO.save(owner2);

        Owner owner3 = new Owner("owner3","Kostas","Pappas","2105456237", "owner3@gmail.com","123456789", ownerDAO.nextId(), "12341324134123","132413566767");
        ownerDAO.save(owner3);
        userDAO.save(owner3);
/////// RESTUARANTS//////////////////////////////////////////////////


        Restaurant rest = new Restaurant(restaurantDAO.nextId(), "Taverna","2105347953",12,new Address(12,"Stratigou",122333,"Menidi"));
        restaurantDAO.save(rest);
        rest.addChef(chef);
        ownerDAO.find(owner1.getUserId()).addRestaurant(rest);

        Restaurant rest2 = new Restaurant(restaurantDAO.nextId(), "Kafeteria","2105347234",20,new Address(13,"panagias",122333,"exraxeia"));
        restaurantDAO.save(rest2);
        rest2.addChef(chef2);
        ownerDAO.find(owner1.getUserId()).addRestaurant(rest2);


///ORDERS//////////////////////////////////////////////////////////////

        Order order1 = new Order(10, LocalDateTime.of(now.getYear(),10,12,10,12),orderDAO.nextId(),customerDAO.find("kostas123"));
        order1.setStateCancelled();
        orderDAO.save(order1);

        Order order2 = new Order(11, LocalDateTime.of(now.getYear(),10,3,10,3),orderDAO.nextId(),customerDAO.find("kostas123"));
        order2.setStateCompleted();
        orderDAO.save(order2);

        Order order3 = new Order(12,LocalDateTime.of(now.getYear(),10,8,3,12),orderDAO.nextId(),customerDAO.find("kostas123"));
        orderDAO.save(order3);





        Dish dish1 = new Dish(1,"patates",10);
        Dish dish2= new Dish(2,"krema",3);
        Dish dish3 = new Dish(3,"kreas",10);

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

        OrderLine o4 = new OrderLine(10,dish1);
        OrderLine o5 = new OrderLine(3,dish2);
        OrderLine o6 = new OrderLine(1,dish3);

        order2.addOrderLine(o4);
        order2.addOrderLine(o5);
        order2.addOrderLine(o6);

        OrderLine o7 = new OrderLine(10,dish1);
        OrderLine o8 = new OrderLine(3,dish2);
        OrderLine o9 = new OrderLine(1,dish3);

        order3.addOrderLine(o7);
        order3.addOrderLine(o8);
        order3.addOrderLine(o9);

        rest.addOrder(order1);
        rest.addOrder(order2);
        rest.addOrder(order3);

        //////////////////named Kafeteria items/////////////////////////////////
        Order order11 = new Order(1, LocalDateTime.of(now.getYear(),10,12,10,12),orderDAO.nextId(),customerDAO.find("adreas:)"));
        order11.setStateCompleted();
        orderDAO.save(order11);

        Order order22 = new Order(11, LocalDateTime.of(now.getYear(),9,3,10,3),orderDAO.nextId(),customerDAO.find("adreas:)"));
        order22.setStateCompleted();
        orderDAO.save(order22);

        Order order33 = new Order(12,LocalDateTime.of(now.getYear(),10,8,3,12),orderDAO.nextId(),customerDAO.find("adreas:)"));
        order33.setStateCompleted();
        orderDAO.save(order33);

        Order order44 = new Order(5,LocalDateTime.of(now.getYear(),3,8,3,12),orderDAO.nextId(),customerDAO.find("adreas:)"));
        order44.setStateCancelled();
        orderDAO.save(order44);

        Dish dish4 = new Dish(4,"soupa",15);
        Dish dish5= new Dish(5,"pizza",10);
        Dish dish6 = new Dish(6,"salata",12);

        dishDAO.save(dish4);
        dishDAO.save(dish5);
        dishDAO.save(dish6);

        rest2.addDish(dish4);
        rest2.addDish(dish5);
        rest2.addDish(dish6);

        OrderLine o11 = new OrderLine(10,dish4);
        OrderLine o22 = new OrderLine(3,dish5);
        OrderLine o33 = new OrderLine(1,dish6);

        order11.addOrderLine(o11);
        order11.addOrderLine(o22);
        order11.addOrderLine(o33);

        OrderLine o44 = new OrderLine(10,dish4);
        OrderLine o55 = new OrderLine(4,dish5);
        OrderLine o66 = new OrderLine(1,dish6);

        order22.addOrderLine(o44);
        order22.addOrderLine(o55);
        order22.addOrderLine(o66);

        OrderLine o77 = new OrderLine(10,dish4);
        OrderLine o88 = new OrderLine(3,dish5);
        OrderLine o99 = new OrderLine(1,dish6);

        order33.addOrderLine(o77);
        order33.addOrderLine(o88);
        order33.addOrderLine(o99);
        order44.addOrderLine(o77);

        rest2.addOrder(order11);
        rest2.addOrder(order22);
        rest2.addOrder(order33);
        rest2.addOrder(order44);

    }

    public abstract ChefDAO getChefDAO();
    public abstract CustomerDAO getCustomerDAO();
    public abstract OwnerDAO getOwnerDAO();
    public abstract DishDAO getDishDAO();
    public abstract UserDAO getUserDAO();


    public abstract RestaurantDAO getRestaurantDAO();

    public abstract OrderDAO getOrderDAO();


}
