package gr.aueb.softeng.view.Customer.TopUp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.CustomerDAO;

public class TopUpViewModel extends ViewModel {
    TopUpPresenter presenter;
    public TopUpViewModel(CustomerDAO customerDAO) {
        presenter = new TopUpPresenter(customerDAO);
    }

    public TopUpPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TopUp", "onCleared");
        presenter= null;
    }
}
