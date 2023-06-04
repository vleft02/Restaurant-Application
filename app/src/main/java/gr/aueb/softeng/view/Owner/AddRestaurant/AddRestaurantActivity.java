package gr.aueb.softeng.view.Owner.AddRestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;


public class AddRestaurantActivity extends AppCompatActivity implements AddRestaurantView {

    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(AddRestaurantActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    private static boolean initialized = false;
    private int ownerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        AddRestaurantViewModel viewModel = new ViewModelProvider(this).get(AddRestaurantViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            ownerId = extras.getInt("OwnerId");
        }
        viewModel.getPresenter().setOwner(ownerId);

        findViewById(R.id.CreateRestaurantButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateRestaurant();
            }

        });
    }
    public HashMap<String,String> getRestDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.RestaurantNameText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.RestaurantTelephoneText)).getText().toString().trim()));
        details.put("streetName",(((EditText)findViewById(R.id.StreetNameText)).getText().toString().trim()));
        details.put("streetNumber",(((EditText)findViewById(R.id.StreetNumberText)).getText().toString().trim()));
        details.put("zc",(((EditText)findViewById(R.id.ZcText)).getText().toString().trim()));
        details.put("city",(((EditText)findViewById(R.id.CityText)).getText().toString().trim()));
        details.put("total_tables",(((EditText)findViewById(R.id.TotalTablesText)).getText().toString().trim()));
        return details;
    }
    public void goBack(){
        finish(); /// otan kaleitai auto , poia sinartisi tou proigoymenou intent kaleitai? h on create?
    }
}