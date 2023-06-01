package gr.aueb.softeng.view.Owner.Statistics;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.view.Owner.RestaurantDetails.RestaurantDetailsView;

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

    public void calculateStats(){
        view.setYearlyIncome("0");
        view.setCustExpenses("0");
        view.setAVGDailyRevenue("0");
        view.setMonthlyIncome("0");
        view.setOrderCancellationRate("0");
    }
}
