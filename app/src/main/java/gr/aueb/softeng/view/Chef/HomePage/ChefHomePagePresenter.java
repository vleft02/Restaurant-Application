package gr.aueb.softeng.view.Chef.HomePage;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageView;

public class ChefHomePagePresenter {
    ChefHomePageView view;

    private ArrayList<Order> orderList;
    private ChefDAO chefDAO;
    private OrderDAO orderDAO;

    private Chef chef;

    public ChefHomePagePresenter(ChefDAO chefDAO, OrderDAO orderDAO){
        this.chefDAO=chefDAO;
        this.orderDAO=orderDAO;
    }
    public void setOrderList(){
        orderList = chef.getOrders();
    }
    public void setView(ChefHomePageView view){
        this.view=view;
    }
    public ChefDAO getChefDAO(){
        return this.chefDAO;
    }
    public OrderDAO getOrderDAO(){
        return this.orderDAO;
    }

    public void setChef(int chefId) {
        chef = chefDAO.find(chefId);
    }

    public ArrayList<Order> getOrderList(){
        return this.orderList;
    }
    public void onChangeLayout(){
        view.changeLayout();
    }
}
