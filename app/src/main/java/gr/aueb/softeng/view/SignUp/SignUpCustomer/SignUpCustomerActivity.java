package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;

import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;

public class SignUpCustomerActivity extends AppCompatActivity implements SignUpCustomerView {
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(SignUpCustomerActivity.this)
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

        SignUpCustomerViewModel viewModel = new ViewModelProvider(this).get(SignUpCustomerViewModel.class);
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
        details.put("name",(((EditText)findViewById(R.id.CustomerNameText)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.CustomerSurnameText)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.CustomerUsernameText)).getText().toString().trim()));
        details.put("email",(((EditText)findViewById(R.id.CustomerEmailText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.CustomerTelephoneText)).getText().toString().trim()));
        details.put("cardNumber",(((EditText)findViewById(R.id.CardNumberText)).getText().toString().trim()));
        details.put("cardHolderName",(((EditText)findViewById(R.id.CardHolderNameText)).getText().toString().trim()));
        details.put("cvv",(((EditText)findViewById(R.id.CVVText)).getText().toString().trim()));
        details.put("password",(((EditText)findViewById(R.id.CustomerPasswordText)).getText().toString().trim()));
        return details;
    }
    public void goBack(){
        Intent intent = new Intent(SignUpCustomerActivity.this, LoginActivity.class);
        startActivity(intent);
    }

//    @Override
 //   protected void onSaveInstanceState(Bundle outState) {
 //       super.onSaveInstanceState(outState);
  //      outState.putSerializable(view); // Save relevant data
//    }

}