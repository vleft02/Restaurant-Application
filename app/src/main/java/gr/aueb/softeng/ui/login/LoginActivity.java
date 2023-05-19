package gr.aueb.softeng.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.softeng.team08.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);



    }

    public void handleLoginDetails(View v)
    {
        TextView usernameField = findViewById(R.id.usernameTextEdit);
        String inputUsername = usernameField.getText().toString();
        TextView passwordField = findViewById(R.id.usernameTextEdit);
        String inputPassword = passwordField.getText().toString();
        //viewModel.getPresenter().authenticate(inputUsername,inputPassword);
    }


}