package gr.aueb.softeng.view.Customer.PlaceOrder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;
import gr.aueb.softeng.team08.R;

public class PlaceOrderActivity extends AppCompatActivity implements PlaceOrderView{

    PlaceOrderViewModel viewModel;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        viewModel = new PlaceOrderViewModel(new RestaurantDAOmemory(),new CustomerDAOmemory());
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null)
        {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras!=null)
            {
                //get extras
            }
        }


    }
}