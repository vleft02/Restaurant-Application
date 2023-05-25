package gr.aueb.softeng.view.SignUp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.softeng.team08.R;

public class SignUpActivity extends AppCompatActivity implements SignUpView{

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(SignUpActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUpViewModel viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();

        }

    }

}