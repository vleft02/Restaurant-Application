package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class SignUpCustomerViewModel extends ViewModel {
SignUpCustomerPresenter presenter;

public SignUpCustomerViewModel()
{
    presenter = new SignUpCustomerPresenter(new CustomerDAOmemory()/*, new UserDAOmemory()*/);

}
    public SignUpCustomerPresenter getPresenter()
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