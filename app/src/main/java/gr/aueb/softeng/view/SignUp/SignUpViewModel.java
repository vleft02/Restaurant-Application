package gr.aueb.softeng.view.SignUp;

import androidx.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {
SignUpPresnter presenter;

public SignUpViewModel()
{
    presenter = new SignUpPresnter();
}
    public SignUpPresnter getPresenter()
    {
        return presenter;
    }
}
