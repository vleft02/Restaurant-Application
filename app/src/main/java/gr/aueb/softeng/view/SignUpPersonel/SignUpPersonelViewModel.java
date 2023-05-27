package gr.aueb.softeng.view.SignUpPersonel;

import android.util.Log;
import android.widget.ViewAnimator;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.User;
import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;
import gr.aueb.softeng.view.SignUp.SignUpPresenter;

public class SignUpPersonelViewModel extends ViewModel {
    SignUpPersonelPresenter presenter;

    public SignUpPersonelViewModel() {
        presenter = new SignUpPersonelPresenter();
        ChefDAO chefDao = new ChefDAOmemory();
        UserDAO userDao = new UserDAOmemory();
        presenter.setChefDao(chefDao);
        presenter.setUserDAO(userDao);
    }

    public SignUpPersonelPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        //loginPresenter = null;
    }
}
