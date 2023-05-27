package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class SignUpCustomerViewModel extends ViewModel {
SignUpCustomerPresenter presenter;

public SignUpCustomerViewModel()
{
    presenter = new SignUpCustomerPresenter();

}
    public SignUpCustomerPresenter getPresenter()
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
