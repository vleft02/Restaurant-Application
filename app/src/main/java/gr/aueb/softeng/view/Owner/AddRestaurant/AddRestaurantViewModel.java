package gr.aueb.softeng.view.Owner.AddRestaurant;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class AddRestaurantViewModel extends ViewModel {
    AddRestaurantPresenter presenter;
    public AddRestaurantViewModel(){
        presenter = new AddRestaurantPresenter(new RestaurantDAOmemory());
    }
    public AddRestaurantPresenter getPresenter(){
        return this.presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        presenter = null;
    }
}
