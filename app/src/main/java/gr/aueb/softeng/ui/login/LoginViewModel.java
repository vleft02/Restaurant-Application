package gr.aueb.softeng.ui.login;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel{

    private LoginPresenter loginPresenter;

    public LoginViewModel()
    {
        loginPresenter = new LoginPresenter();
        //UserDAO userDao = new UserDAOmemory()
        //loginPresenter.setUserDAO(userDao)
    }

    public LoginPresenter getLoginPresenter() {
        return loginPresenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Login", "onCleared");
        //loginPresenter = null;
    }
}
