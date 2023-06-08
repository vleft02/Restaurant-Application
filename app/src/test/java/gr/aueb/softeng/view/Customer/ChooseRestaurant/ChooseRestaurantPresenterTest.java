package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class ChooseRestaurantPresenterTest {

    ChooseRestaurantPresenter presenter;

    ChooseRestaurantViewStub view;

    RestaurantDAO restaurantDAO;

    @Before
    public void setUp() {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        view = new ChooseRestaurantViewStub();

        restaurantDAO = new RestaurantDAOmemory();

        presenter = new ChooseRestaurantPresenter(restaurantDAO);
        presenter.setView(view);
    }

    @Test
    public void setView() {
        ChooseRestaurantView testView = new ChooseRestaurantViewStub();
        presenter.setView(testView);
        assertEquals(testView,presenter.getView());
    }

    @Test
    public void getView() {
        assertEquals(view,presenter.getView());
    }

    @Test
    public void setRestaurantList() {
        presenter.setRestaurantList();
        assertEquals(restaurantDAO.findAll(),presenter.getRestaurantList());
    }

    @Test
    public void onChangeLayoutRestaurantListEmpty() {
        presenter.onChangeLayout();
        assertEquals(1,view.getNoRestaurants());
        assertEquals(0,view.getRestaurantsFound());
    }


    @Test
    public void onChangeLayoutRestaurantsFound() {
        presenter.setRestaurantList();
        presenter.onChangeLayout();
        assertEquals(0,view.getNoRestaurants());
        assertEquals(1,view.getRestaurantsFound());
    }


    @Test
    public void onBack() {
        presenter.onBack();
        assertEquals(1, view.getGoBackIsPressed());
    }

    @Test
    public void getRestaurantList() {
        presenter.setRestaurantList();
        assertEquals(restaurantDAO.findAll(), presenter.getRestaurantList());
    }
}