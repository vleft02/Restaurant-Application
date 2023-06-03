package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePagePresenter;

public class ChooseRestaurantViewModel extends ViewModel {
    ChooseRestaurantPresenter presenter;

    public ChooseRestaurantViewModel()
    {
        presenter = new ChooseRestaurantPresenter(new RestaurantDAOmemory());
    }

    public ChooseRestaurantPresenter getPresenter() {
        return presenter;
    }
}
