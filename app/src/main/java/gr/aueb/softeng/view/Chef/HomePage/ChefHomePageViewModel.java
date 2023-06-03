package gr.aueb.softeng.view.Chef.HomePage;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePagePresenter;

public class ChefHomePageViewModel extends ViewModel {
    private ChefHomePagePresenter presenter;
    public ChefHomePageViewModel(){
        presenter= new ChefHomePagePresenter(new ChefDAOmemory(), new OrderDAOmemory());
    }

    public ChefHomePagePresenter getPresenter(){
        return this.presenter;
    }
}
