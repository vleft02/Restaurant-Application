package gr.aueb.softeng.view.Customer.HomePage;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OrderDAO;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;

public class CustomerHomePageViewModel extends ViewModel {
    CustomerHomepagePresenter presenter;

    public CustomerHomePageViewModel(CustomerDAO customerDAO, OrderDAO orderDAO, ChefDAO chefDAO)
    {
        presenter = new CustomerHomepagePresenter(new CustomerDAOmemory(),new OrderDAOmemory(), new ChefDAOmemory());
    }
    public CustomerHomepagePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        presenter = null;
    }
}
