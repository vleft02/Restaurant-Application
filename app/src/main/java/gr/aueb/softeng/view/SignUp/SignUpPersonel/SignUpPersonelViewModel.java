package gr.aueb.softeng.view.SignUp.SignUpPersonel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class SignUpPersonelViewModel extends ViewModel {
    SignUpPersonelPresenter presenter;

    public SignUpPersonelViewModel() {
        presenter = new SignUpPersonelPresenter(new UserDAOmemory(), new ChefDAOmemory());

    }
    public SignUpPersonelPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        presenter = null;
    }
}
