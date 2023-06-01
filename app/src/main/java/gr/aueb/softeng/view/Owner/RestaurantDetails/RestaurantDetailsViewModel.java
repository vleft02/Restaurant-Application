package gr.aueb.softeng.view.Owner.RestaurantDetails;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;
import gr.aueb.softeng.view.SignUp.SignUpCustomer.SignUpCustomerPresenter;

public class RestaurantDetailsViewModel extends ViewModel {
    RestaurantDetailsPresenter presenter;

    public RestaurantDetailsViewModel(){
        presenter = new RestaurantDetailsPresenter(new RestaurantDAOmemory());
    }
    public RestaurantDetailsPresenter getPresenter()
    {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        presenter = null;
    }
}
