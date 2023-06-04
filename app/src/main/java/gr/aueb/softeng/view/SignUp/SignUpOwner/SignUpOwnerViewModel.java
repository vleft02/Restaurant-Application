package gr.aueb.softeng.view.SignUp.SignUpOwner;

import android.util.Log;

import androidx.lifecycle.ViewModel;


import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;


public class SignUpOwnerViewModel extends ViewModel {
    SignUpOwnerPresenter presenter;

    public SignUpOwnerViewModel() {
        presenter = new SignUpOwnerPresenter(new UserDAOmemory(), new OwnerDAOmemory());
    }

    public SignUpOwnerPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        presenter = null;
    }
}
