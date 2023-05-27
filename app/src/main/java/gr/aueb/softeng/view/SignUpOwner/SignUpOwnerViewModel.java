package gr.aueb.softeng.view.SignUpOwner;

import android.util.Log;
import android.widget.ViewAnimator;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.domain.User;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;


public class SignUpOwnerViewModel extends ViewModel {
    SignUpOwnerPresenter presenter;

    public SignUpOwnerViewModel() {
        presenter = new SignUpOwnerPresenter();
        OwnerDAO ownerDao = new OwnerDAOmemory();
        UserDAO userDao = new UserDAOmemory();
        presenter.setOwnerDao(ownerDao);
        presenter.setUserDAO(userDao);
    }

    public SignUpOwnerPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        //loginPresenter = null;
    }
}
