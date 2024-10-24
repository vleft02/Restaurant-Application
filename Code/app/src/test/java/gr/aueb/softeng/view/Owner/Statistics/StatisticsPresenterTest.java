package gr.aueb.softeng.view.Owner.Statistics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Owner.AddChef.AddChefPresenter;
import gr.aueb.softeng.view.Owner.AddChef.AddChefView;
import gr.aueb.softeng.view.Owner.AddChef.AddChefViewStub;

public class StatisticsPresenterTest {
    StatisticsPresenter presenter;
    StatisticsViewStub view;
    private RestaurantDAO restDAO;

    private OwnerDAO ownerDAO;
    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new StatisticsViewStub();

        ownerDAO= new OwnerDAOmemory();
        restDAO = new RestaurantDAOmemory();

        presenter = new StatisticsPresenter(ownerDAO,restDAO);
        presenter.setView(view);
        presenter.setRestaurant(restDAO.find("Kafeteria").getId());
    }
    @After
    public void tearDown() throws Exception {
        presenter=null;
        view=null;
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.eraseAll();
    }


    @Test
    public void setView() {
        StatisticsView testView = new StatisticsViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }
    @Test
    public void getView(){
        assertEquals(view,presenter.getView());
    }

    @Test
    public void setRestaurant() {
        Restaurant rest = restDAO.find("Kafeteria");
        presenter.setRestaurant(rest.getId());
        assertEquals(presenter.getRestaurant(),rest);
    }

    @Test
    public void onBack() {
        view.goBack();
        assertEquals(1,view.getGoBackPressed());
    }

    @Test
    public void calcYearlyIncome() {
        assertEquals(String.valueOf(presenter.calcYearlyIncome()),"586.0");//order11=192 euros , order22=202 euros , order33=192 , all on the current year
    }

    @Test
    public void calcAvgMonthlyIncome() {
        assertEquals(String.valueOf(presenter.calcAvgMonthlyIncome()),"293.0");//((order11+order33)+order22)/2
    }

    @Test
    public void calcAvgOrderExpenses() {
        assertEquals(String.valueOf(presenter.calcAvgOrderExpenses()),String.valueOf(586.0/3.0)); // (order11+order22+order33)/3
    }

    @Test
    public void calcAvgDailyRevenue() {
        assertEquals(String.valueOf(presenter.calcAvgDailyRevenue()),String.valueOf(586.0/3.0)); // (order11+order22+order33)/3
    }

    @Test
    public void calcCancelRate() {
        assertEquals(String.valueOf(presenter.calcCancelRate()),"25.0"); // orderr44 cancelled out ouf the 4 total orders = 1/4*100=25.0
    }

    @Test
    public void calculateStats() {
        presenter.calculateStats();
        assertEquals(String.valueOf(presenter.calcAvgDailyRevenue()),view.getAvgDailyRevenue());
        assertEquals(String.valueOf(presenter.calcCancelRate()),view.getOrderCancellationRate());
        assertEquals(String.valueOf(presenter.calcYearlyIncome()),view.getYearlyIncome());
        assertEquals(String.valueOf(presenter.calcAvgOrderExpenses()),view.getAvgOrderExpenses());
        assertEquals(String.valueOf(presenter.calcAvgMonthlyIncome()),view.getAVGMonthlyIncome());
    }
    @Test
    public void getRestaurant(){
        Restaurant rest = restDAO.find("Kafeteria");
        assertEquals(presenter.getRestaurant(),rest);
    }
}