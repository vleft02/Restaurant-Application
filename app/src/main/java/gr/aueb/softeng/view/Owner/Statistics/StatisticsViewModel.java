package gr.aueb.softeng.view.Owner.Statistics;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Owner.RestaurantDetails.RestaurantDetailsPresenter;

public class StatisticsViewModel extends ViewModel {
   StatisticsPresenter presenter;

    public StatisticsViewModel(){
        presenter = new StatisticsPresenter(new OwnerDAOmemory(),new RestaurantDAOmemory());
    }
    public StatisticsPresenter getPresenter()
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
