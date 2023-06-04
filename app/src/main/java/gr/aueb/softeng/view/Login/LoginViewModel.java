package gr.aueb.softeng.view.Login;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class LoginViewModel extends ViewModel{

    private LoginPresenter loginPresenter;

    public LoginViewModel()
    {
        loginPresenter = new LoginPresenter(new ChefDAOmemory(), new CustomerDAOmemory(), new OwnerDAOmemory(),new UserDAOmemory());
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
