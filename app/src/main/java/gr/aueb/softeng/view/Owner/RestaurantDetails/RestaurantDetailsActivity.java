package gr.aueb.softeng.view.Owner.RestaurantDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;
import gr.aueb.softeng.view.Owner.Statistics.StatisticsActivity;
import gr.aueb.softeng.view.SignUp.SignUpCustomer.SignUpCustomerActivity;
import gr.aueb.softeng.view.SignUp.SignUpCustomer.SignUpCustomerViewModel;

public class RestaurantDetailsActivity extends AppCompatActivity implements RestaurantDetailsView {
    public int RestaurantId;
    RestaurantDetailsViewModel viewModel;

    public void setRestName(String name){
        ((TextView)findViewById(R.id.RestaurantNameDetailText)).setText(name);
    }
    public void setRestId(String id){
        ((TextView)findViewById(R.id.RestaurantIdDetailText)).setText(id);
    }
    public void setRestTables(String tables){
        ((TextView)findViewById(R.id.RestaurantTablesDetailText)).setText(tables);
    }
    public void setRestAddressStreet(String street){
        ((TextView)findViewById(R.id.RestaurantAddressStreetText)).setText(street);
    }
    public void setRestAddressNumber(String num){
        ((TextView)findViewById(R.id.RestaurantAddressNumberText)).setText(num);
    }
    public void setRestZip(String zip){
        ((TextView)findViewById(R.id.RestaurantAddressZCText)).setText(zip);
    }
    public void setRestAddressCity(String city){
        ((TextView)findViewById(R.id.RestaurantCityText)).setText(city);
    }
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(RestaurantDetailsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        viewModel = new ViewModelProvider(this).get(RestaurantDetailsViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            RestaurantId = extras.getInt("RestaurantId");
        }
        viewModel.getPresenter().setRestaurant(RestaurantId);
        viewModel.getPresenter().setDetails();

        findViewById(R.id.ExtractStatsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onExtractStats();
            }
        });
        findViewById(R.id.GoBack2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){viewModel.getPresenter().OnBack();}
        });
    }


    public void goBack(){
        finish();
    }

    public void extractStats(){
        Intent intent = new Intent(RestaurantDetailsActivity.this, StatisticsActivity.class);
        intent.putExtra("RestaurantId",RestaurantId);
        startActivity(intent);
    }
}