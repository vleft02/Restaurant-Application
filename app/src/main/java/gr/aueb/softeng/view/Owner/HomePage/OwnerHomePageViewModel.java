package gr.aueb.softeng.view.Owner.HomePage;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class OwnerHomePageViewModel extends ViewModel {

    private OwnerHomePagePresenter presenter;
    public OwnerHomePageViewModel(){
        presenter= new OwnerHomePagePresenter(new OwnerDAOmemory() , new RestaurantDAOmemory());
    }

    public OwnerHomePagePresenter getPresenter(){
        return this.presenter;
    }
}
