package gr.aueb.softeng.view.Owner.Statistics;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Restaurant;

public class StatisticsPresenter {
    private RestaurantDAO restaurantDAO;
    private OwnerDAO ownerDAO;
    private Restaurant restaurant;

    public StatisticsPresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO){
        this.ownerDAO=ownerDAO;
        this.restaurantDAO = restaurantDAO;
    }
    StatisticsView view;
    public void setView(StatisticsView view)
    {
        this.view = view;
    }

    public void setRestaurant(int restaurantId) {
        restaurant = restaurantDAO.find(restaurantId);
    }

    public void OnBack(){
        view.goBack();
    }

    public double calcYearlyIncome(){
        double sum=0.0;
        LocalDateTime now = LocalDateTime.now();
        for(Order order:restaurant.getOrders()){
            if(order.getDate().getYear()== now.getYear() && order.getOrderState()== Order.State.COMPLETED){
                sum+=order.getTotalCost();
            }
        }
        return sum;
    }

    public double calcAvgMonthlyIncome(){
        LocalDateTime now = LocalDateTime.now();
        double totalIncome = 0.0;
        Set<Integer> monthsWithOrders = new HashSet<>();

        for (Order order : restaurant.getOrders()) {
            LocalDateTime orderDate = order.getDate();
            if (orderDate.getYear() == now.getYear() && order.getOrderState()== Order.State.COMPLETED) {
                totalIncome += order.getTotalCost();
                int month = orderDate.getMonthValue();
                monthsWithOrders.add(month);
            }
        }
        int totalMonths = monthsWithOrders.size();
        if(totalMonths!=0) {
            return totalIncome / totalMonths;
        }else{
            return 0;
        }
    }

    public double calcCustExpenses(){
        double cost=0.0;
        LocalDateTime now = LocalDateTime.now();
        for (Order order : restaurant.getOrders()) {
            LocalDateTime orderDate = order.getDate();
            if (orderDate.getYear() == now.getYear() && order.getOrderState()== Order.State.COMPLETED) {
                cost += order.getTotalCost();
            }
        }
        if(restaurant.getOrders().size()!=0){
            return cost/restaurant.getOrders().size();
        }else{
            return 0;
        }
    }

    public double calcAvgDailyRevenue(){
        double totalIncome = 0.0;
        int totalDays = 0;
        LocalDateTime now = LocalDateTime.now();

        for (int month = 1; month <= 12; month++) {
            for (Order order : restaurant.getOrders()) {
                LocalDateTime orderDate = order.getDate();
                if (orderDate.getYear() == now.getYear() && orderDate.getMonthValue() == month && order.getOrderState()== Order.State.COMPLETED ) {
                    totalIncome += order.getTotalCost();
                    totalDays++;
                }
            }
        }
        if(totalDays!=0) {
            return totalIncome / totalDays;
        }else{
            return 0;
        }

    }

    public double calcCancelRate(){
        LocalDateTime now = LocalDateTime.now();
        int totalOrders = 0;
        int cancelledOrders = 0;

        for (Order order : restaurant.getOrders()) {
            LocalDateTime orderDate = order.getDate();
            if (orderDate.getYear() == now.getYear()) {
                totalOrders++;
                if (order.getOrderState()== Order.State.CANCELLED) {
                    cancelledOrders++;
                }
            }
        }
        if(totalOrders!=0) {
           return((double) cancelledOrders / totalOrders * 100);
        }else{
            return 0;
        }
    }
    public void calculateStats(){

        view.setYearlyIncome(String.valueOf(calcYearlyIncome()));


        view.setAVGMonthlyIncome(String.valueOf(calcAvgMonthlyIncome()));

        view.setCustExpenses(String.valueOf(calcCustExpenses()));



        view.setAVGDailyRevenue(String.valueOf(calcAvgDailyRevenue()));

        view.setOrderCancellationRate(String.valueOf(calcCancelRate()));
    }
}
