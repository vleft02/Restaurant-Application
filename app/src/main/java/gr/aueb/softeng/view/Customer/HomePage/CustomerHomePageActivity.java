package gr.aueb.softeng.view.Customer.HomePage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Customer.PlaceOrder.PlaceOrderActivity;
import gr.aueb.softeng.view.Customer.TopUp.TopUpActivity;

public class CustomerHomePageActivity extends AppCompatActivity implements CustomerHomepageView,FragmentListener{

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    int customerId =-1;
    CustomerHomePageViewModel viewModel;
    public void ShowConfirmationMessage() {
        new AlertDialog.Builder(CustomerHomePageActivity.this)
                .setTitle("Ακύρωση Παραγγελίας")
                .setMessage("Είστε σίγουροι οτι θέλετε να συνεχίσετε;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.getPresenter().cancel();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_homepage);


        viewModel = new CustomerHomePageViewModel(new CustomerDAOmemory(), new OrderDAOmemory(),new ChefDAOmemory());
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null)
        {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            if (extras != null) {
                customerId = extras.getInt("CustomerId");
            }
        }
        viewModel.getPresenter().setCustomer(customerId);
        viewModel.getPresenter().setCurrentOrder();

        //tabbed Layout initialization
        tabLayout = findViewById(R.id.CustomerHomePageTabLayout);//tabs currentOrderTab and orderHistoryTab
        viewPager2 = findViewById(R.id.CustomerHomePageViewPager);
        viewPager2.setUserInputEnabled(false);//No touch scrolling allowed
        CustomerHomePageViewPagerAdapter adapter = new CustomerHomePageViewPagerAdapter(this,this);
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());//the appropriate tab is set when selecte
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
        });

        findViewById(R.id.TopUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onTopUp();
            }
        });





    }

    @Override
    protected void onPause() {
        super.onPause();
        viewPager2.setAdapter(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager2.setAdapter(new CustomerHomePageViewPagerAdapter(this,this));
    }


    public void redirectTopUp() {
        Intent intent = new Intent(CustomerHomePageActivity.this , TopUpActivity.class) ;
        intent.putExtra("CustomerId",customerId);
        startActivity(intent);
    }

    public void redirectPlaceOrder() {
        Intent intent = new Intent(CustomerHomePageActivity.this , PlaceOrderActivity.class) ;
        startActivity(intent);
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public CustomerHomePageViewModel getViewModel()
    {
        return viewModel;
    }

    @Override
    public void changeLayout() {
        viewModel.getPresenter().chooseLayout();
    }

    @Override
    public void onCancel() {
        ShowConfirmationMessage();
    }

    @Override
    public void onPlaceOrder() {
        Intent intent = new Intent(CustomerHomePageActivity.this , PlaceOrderActivity.class) ;
        startActivity(intent);
    }


}