package gr.aueb.softeng.view.Owner.HomePage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Customer.ChooseRestaurant.ChooseRestaurantPresenter;
import gr.aueb.softeng.view.Customer.ChooseRestaurant.ChooseRestaurantViewStub;
import gr.aueb.softeng.view.Owner.AddChef.AddChefView;
import gr.aueb.softeng.view.Owner.AddChef.AddChefViewStub;

public class OwnerHomePagePresenterTest {

    private OwnerHomePagePresenter presenter;

    private OwnerHomePageViewStub view;

    private RestaurantDAO restaurantDAO;
    private OwnerDAO ownerDAO;

    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new OwnerHomePageViewStub();

        restaurantDAO = new RestaurantDAOmemory();
        ownerDAO = new OwnerDAOmemory();

        presenter = new OwnerHomePagePresenter(ownerDAO,restaurantDAO);
        presenter.setView(view);
    }

    @After
    public void tearDown() throws Exception {
        presenter=null;
        view=null;
    }

    @Test
    public void setRestaurantList() {
        Owner owner=ownerDAO.find("owner1");
        ArrayList<Restaurant> restaurantList=owner.getRestaurants();
        presenter.setOwner(owner.getUserId());
        presenter.setRestaurantList();
        assertEquals(presenter.getRestaurantList(),restaurantList);

    }

    @Test
    public void setView() {
        OwnerHomePageView testView = new OwnerHomePageViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }

    @Test
    public void getOwnerDAO() {
        assertEquals(presenter.getOwnerDAO(),ownerDAO);
    }

    @Test
    public void getRestaurantDAO() {
        assertEquals(presenter.getRestaurantDAO(),restaurantDAO);
    }

    @Test
    public void getRestaurants() {
        Owner owner=ownerDAO.find("owner1");
        ArrayList<Restaurant> restaurantList=owner.getRestaurants();
        presenter.setOwner(owner.getUserId());
        assertEquals(presenter.getRestaurants(),restaurantList);
    }

    @Test
    public void setOwner() {
        Owner owner = ownerDAO.find("owner1");
        presenter.setOwner(owner.getUserId());
        assertEquals(presenter.getOwner(),owner);
    }

    @Test
    public void onAddRestaurant() {
        view.AddRestaurant();
        assertEquals(1,view.getAddRestaurantPressed());
    }

    @Test
    public void getRestaurantList() {
        Owner owner=ownerDAO.find("owner1");
        ArrayList<Restaurant> restaurantList=owner.getRestaurants();
        presenter.setOwner(owner.getUserId());
        presenter.setRestaurantList();
        assertEquals(presenter.getRestaurantList(),restaurantList);
    }

    @Test
    public void onChangeLayoutRestaurantListEmpty() {
        presenter.onChangeLayout();
        assertEquals(1,view.getNoRestaurants());
        assertEquals(0,view.getRestaurantsFound());
    }


    @Test
    public void onChangeLayoutRestaurantsFound() {
        Owner owner=ownerDAO.find("owner1");
        presenter.setOwner(owner.getUserId());
        presenter.setRestaurantList();
        presenter.onChangeLayout();
        assertEquals(0,view.getNoRestaurants());
        assertEquals(1,view.getRestaurantsFound());
    }


    @Test
    public void onBack() {
        view.goBack();
        assertEquals(1,view.getGoBackPressed());
    }
}