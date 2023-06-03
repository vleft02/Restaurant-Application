package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import java.util.ArrayList;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.domain.Chef;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.OrderLine;

public class ChefOrderDetailsPresenter {
    ChefOrderDetailsView view;

    private ArrayList<OrderLine> orderLineList;
    private ChefDAO chefDAO;
    private OrderDAO orderDAO;
    private Chef chef;

    private Order order;

    public ChefOrderDetailsPresenter(ChefDAO chefDAO, OrderDAO orderDAO){
        this.chefDAO=chefDAO;
        this.orderDAO=orderDAO;
    }
    public void setOrderLineList() {
        orderLineList = order.getOrderLines();
    }

    public void setView(ChefOrderDetailsView view){
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

    public void setOrder(int orderId){
        order= orderDAO.find(orderId);
    }

    public ArrayList<OrderLine> getOrderLineList(){
        return this.orderLineList;
    }
    public void setOrderDetails(){
        view.setOrderId(String.valueOf(order.getId()));
        view.setOrderState(String.valueOf(order.getOrderState()));
        view.setTableNumber(String.valueOf(order.getTableNumber()));
    //    view.setDate(String.valueOf(order.getDate()));
    }
    public void onCompleted() {
        if (order.getOrderState() != Order.State.CANCELLED && order.getOrderState() != Order.State.COMPLETED) {
            order.setStateCompleted();
            view.setOrderState(String.valueOf(order.getOrderState()));
        }
    }
    public void OnBack(){
        view.goBack();
    }
}
