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
        ArrayList<Integer> indexes = new ArrayList<>();
        orderList = chef.getOrders();
        int i=0;
        while (i<orderList.size()){
            if(orderList.get(i).getOrderState()== Order.State.COMPLETED){
                indexes.add(i);
            }
            i+=1;
        }
        for(int rem: indexes){
            orderList.remove(rem);
        }
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
        return orderList;
    }
    public void onChangeLayout(){
        view.changeLayout();
    }
}
