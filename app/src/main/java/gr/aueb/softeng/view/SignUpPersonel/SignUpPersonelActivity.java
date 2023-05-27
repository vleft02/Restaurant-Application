package gr.aueb.softeng.view.SignUpPersonel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;

public class SignUpPersonelActivity extends AppCompatActivity implements SignUpPersonelView {

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(SignUpPersonelActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_personel);

        SignUpPersonelViewModel viewModel = new ViewModelProvider(this).get(SignUpPersonelViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();

        }
        findViewById(R.id.CreateAccPersonelButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateChefAccount();
            }

        });
    }
    public HashMap<String,String> getChefDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.ChefNameText)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.ChefSurnameText)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.ChefUsernameText)).getText().toString().trim()));
        details.put("email",(((EditText)findViewById(R.id.ChefEmailText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.ChefTelephoneText)).getText().toString().trim()));
        details.put("iban",(((EditText)findViewById(R.id.ChefIbanText)).getText().toString().trim()));
        details.put("tin",(((EditText)findViewById(R.id.ChefTinText)).getText().toString().trim()));
        details.put("password",(((EditText)findViewById(R.id.ChefPasswordText)).getText().toString().trim()));
        return details;
    }
    public void goBack(){
        Intent intent = new Intent(SignUpPersonelActivity.this, LoginActivity.class);
        startActivity(intent);
    }




}