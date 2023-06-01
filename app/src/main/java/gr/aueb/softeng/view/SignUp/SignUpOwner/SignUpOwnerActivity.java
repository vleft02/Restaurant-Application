package gr.aueb.softeng.view.SignUp.SignUpOwner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;


public class SignUpOwnerActivity extends AppCompatActivity implements SignUpOwnerView {

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(SignUpOwnerActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_owner);

        SignUpOwnerViewModel viewModel = new ViewModelProvider(this).get(SignUpOwnerViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            }

        findViewById(R.id.CreateAccOwnerButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateOwnerAccount();
            }

        });
    }
    public HashMap<String,String> getOwnerDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.OwnerNameText)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.OwnerSurnameText)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.OwnerUsernameText)).getText().toString().trim()));
        details.put("email",(((EditText)findViewById(R.id.OwnerEmailText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.OwnerTelephoneText)).getText().toString().trim()));
        details.put("iban",(((EditText)findViewById(R.id.OwnerIbanText)).getText().toString().trim()));
        details.put("tin",(((EditText)findViewById(R.id.OwnerTinText)).getText().toString().trim()));
        details.put("password",(((EditText)findViewById(R.id.OwnerPasswordText)).getText().toString().trim()));
        return details;
    }
    public void goBack(){
        finish();
    }




}