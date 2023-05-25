package gr.aueb.softeng.view.SignUp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;

public class SignUpViewModel extends ViewModel {
SignUpPresenter presenter;

public SignUpViewModel()
{
    presenter = new SignUpPresenter();
    CustomerDAO custDao = new CustomerDAOmemory();
    presenter.setCustDao(custDao);
}
    public SignUpPresenter getPresenter()
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
