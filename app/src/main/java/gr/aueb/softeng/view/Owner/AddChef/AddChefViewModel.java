package gr.aueb.softeng.view.Owner.AddChef;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class AddChefViewModel extends ViewModel {
    AddChefPresenter presenter;

    public AddChefViewModel() {
        presenter = new AddChefPresenter(new RestaurantDAOmemory(), new ChefDAOmemory());

    }
    public AddChefPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        presenter = null;
    }
}
