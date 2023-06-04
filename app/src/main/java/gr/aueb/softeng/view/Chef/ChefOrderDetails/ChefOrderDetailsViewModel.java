package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;


public class ChefOrderDetailsViewModel extends ViewModel {
    private ChefOrderDetailsPresenter presenter;
    public ChefOrderDetailsViewModel(){
        presenter= new ChefOrderDetailsPresenter(new ChefDAOmemory(), new OrderDAOmemory());
    }

    public ChefOrderDetailsPresenter getPresenter(){
        return this.presenter;
    }
}
