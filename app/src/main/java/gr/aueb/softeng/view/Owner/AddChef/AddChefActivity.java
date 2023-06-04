package gr.aueb.softeng.view.Owner.AddChef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.SignUp.SignUpPersonel.SignUpPersonelActivity;
import gr.aueb.softeng.view.SignUp.SignUpPersonel.SignUpPersonelViewModel;

public class AddChefActivity extends AppCompatActivity implements AddChefView {

    public int restId;

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(AddChefActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chef);

        AddChefViewModel viewModel = new ViewModelProvider(this).get(AddChefViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            restId = extras.getInt("RestaurantId");
        }
        viewModel.getPresenter().setRestaurant(restId);

        findViewById(R.id.confirmChefButton1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onAddChefAccount();
            }

        });
    }

    public HashMap<String,String> getChefDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.ChefNameText1)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.ChefSurnameText1)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.ChefUsernameText1)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.ChefTelephoneText1)).getText().toString().trim()));
        details.put("iban",(((EditText)findViewById(R.id.ChefIbanText1)).getText().toString().trim()));
        details.put("tin",(((EditText)findViewById(R.id.ChefTinText1)).getText().toString().trim()));
        return details;
    }
    public void goBack(){
        finish();
    }
}