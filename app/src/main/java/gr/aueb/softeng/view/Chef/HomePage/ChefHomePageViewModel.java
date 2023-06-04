package gr.aueb.softeng.view.Chef.HomePage;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;


public class ChefHomePageViewModel extends ViewModel {
    private ChefHomePagePresenter presenter;
    public ChefHomePageViewModel(){
        presenter= new ChefHomePagePresenter(new ChefDAOmemory(), new OrderDAOmemory());
    }

    public ChefHomePagePresenter getPresenter(){
        return this.presenter;
    }
}
