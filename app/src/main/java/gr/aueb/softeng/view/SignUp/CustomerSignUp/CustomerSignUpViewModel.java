package gr.aueb.softeng.view.SignUp.CustomerSignUp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;

public class CustomerSignUpViewModel extends ViewModel {
CustomerSignUpPresenter presenter;

public CustomerSignUpViewModel()
{
    presenter = new CustomerSignUpPresenter();
    CustomerDAO custDao = new CustomerDAOmemory();
    presenter.setCustDao(custDao);
}
    public CustomerSignUpPresenter getPresenter()
    {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        //loginPresenter = null;
    }
}
