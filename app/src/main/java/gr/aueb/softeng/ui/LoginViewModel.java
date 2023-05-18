package gr.aueb.softeng.ui;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel{

    private LoginPresenter loginPresenter;

    public LoginViewModel()
    {
        loginPresenter = new LoginPresenter();
        //setDAO
    }
}
