package gr.aueb.softeng.view.Owner.RestaurantDetails;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Owner;
import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Owner.AddRestaurant.AddRestaurantPresenter;
import gr.aueb.softeng.view.Owner.AddRestaurant.AddRestaurantView;
import gr.aueb.softeng.view.Owner.AddRestaurant.AddRestaurantViewStub;

public class RestaurantDetailsPresenterTest {
    RestaurantDetailsPresenter presenter;
    RestaurantDetailsViewStub view;
    private RestaurantDAO restDAO;

    @Before
    public void setUp() throws Exception {
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new RestaurantDetailsViewStub();

        restDAO = new RestaurantDAOmemory();

        presenter = new RestaurantDetailsPresenter(restDAO);
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
        RestaurantDetailsView testView = new RestaurantDetailsViewStub();
        presenter.setView(testView);
        assertEquals(presenter.getView(),testView);
    }

    @Test
    public void setRestaurant() {
        Restaurant rest = restDAO.find("Kafeteria");
        presenter.setRestaurant(rest.getId());
        assertEquals(presenter.getRestaurant(),rest);
    }

    @Test
    public void setDetails() {
        presenter.setDetails();
        assertEquals(view.getRestName(),"Name: "+ presenter.getRestaurant().getRestaurantName());
        assertEquals(view.getRestId(),"Id: "+String.valueOf(presenter.getRestaurant().getId()));
        assertEquals(view.getRestTables(),"Total tables: "+ String.valueOf(presenter.getRestaurant().getTotalTables()));
        assertEquals(view.getRestAddressStreet(),"Address Street: "+presenter.getRestaurant().getAddress().getStreetName());
        assertEquals(view.getAddressNumber(),"Address Number: "+String.valueOf(presenter.getRestaurant().getAddress().getStreetNumber()));
        assertEquals(view.getRestAddressCity(),"Address City: "+presenter.getRestaurant().getAddress().getCity());
        assertEquals(view.getRestZip(),"Address ZC: "+String.valueOf(presenter.getRestaurant().getAddress().getZipCode()));
    }

    @Test
    public void onExtractStats() {
        view.extractStats();
        assertEquals(1,view.getExtractStatsButtonPressed());
    }

    @Test
    public void onBack() {
        view.goBack();
        assertEquals(1,view.getGoBackPressed());
    }

    @Test
    public void onAddChef() {
        view.addChef();
        assertEquals(1,view.getAddChefButtonPressed());
    }
    @Test
    public void getView(){
        assertEquals(view,presenter.getView());
    }
    @Test
    public void getRestaurant(){///////////////////////
        Restaurant rest= restDAO.find("Kafeteria");
        assertEquals(rest,presenter.getRestaurant());
    }
}