package gr.aueb.softeng.ui;

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

    public void handleUsername(View v)
    {
        TextView t = findViewById(R.id.usernameTextEdit);
        String inputUsername = t.getText().toString();
    }


    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showInfo(String message) {

    }
}