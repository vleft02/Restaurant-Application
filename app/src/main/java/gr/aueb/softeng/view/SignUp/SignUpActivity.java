package gr.aueb.softeng.view.SignUp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;

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
        findViewById(R.id.CreateAccButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateAccount();
            }

        });
    }
    public HashMap<String,String> getDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.NameText)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.SurnameText)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.UsernameText)).getText().toString().trim()));
        details.put("email",(((EditText)findViewById(R.id.EmailText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.TelephoneText)).getText().toString().trim()));
        details.put("cardNumber",(((EditText)findViewById(R.id.CardNumberText)).getText().toString().trim()));
        details.put("cardHolderName",(((EditText)findViewById(R.id.CardHolderNameText)).getText().toString().trim()));
        details.put("cvv",(((EditText)findViewById(R.id.CVVText)).getText().toString().trim()));
        details.put("password",(((EditText)findViewById(R.id.PasswordText)).getText().toString().trim()));
        return details;
    }
    public void goBack(){
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }


}