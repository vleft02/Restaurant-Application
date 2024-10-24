package gr.aueb.softeng.view.Customer.PlaceOrder;

import androidx.lifecycle.ViewModel;


import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class PlaceOrderViewModel extends ViewModel {

    PlaceOrderPresenter presenter;

    public PlaceOrderViewModel()
    {
        presenter = new PlaceOrderPresenter(new RestaurantDAOmemory(),new CustomerDAOmemory(),new OrderDAOmemory());
    }

    public PlaceOrderPresenter getPresenter() {
        return presenter;
    }
}
