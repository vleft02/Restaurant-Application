package gr.aueb.softeng.view.Login;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;

public class LoginViewModel extends ViewModel{

    private LoginPresenter loginPresenter;

    public LoginViewModel()
    {
        loginPresenter = new LoginPresenter();
        ChefDAO chefDao = new ChefDAOmemory();
        CustomerDAO custDao = new CustomerDAOmemory();
        OwnerDAO ownerDAO = new OwnerDAOmemory();
        loginPresenter.setOwnerDAO(ownerDAO);
        loginPresenter.setChefDAO(chefDao);
        loginPresenter.setCustDao(custDao);
    }

    public LoginPresenter getPresenter() {
        return loginPresenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        //loginPresenter = null;
    }
}
