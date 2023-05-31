package gr.aueb.softeng.view.Customer.HomePage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;

public class CustomerHomePageActivity extends AppCompatActivity implements CustomerHomepageView,FragmentListener{

    int customerId =-1;
    CustomerHomepagePresenter presenter;//ALLAGI se VIEWMODEL

    public void ShowConfirmationMessage() {
        new AlertDialog.Builder(CustomerHomePageActivity.this)
                .setTitle("Ακύρωση Παραγγελίας")
                .setMessage("Είστε σίγουροι οτι θέλετε να συνεχίσετε;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.cancel(customerId);
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
        setContentView(R.layout.activity_customer_hompepage);

        presenter = new CustomerHomepagePresenter(new CustomerDAOmemory(), new OrderDAOmemory());
        presenter.setView(this);
        if (savedInstanceState == null)
        {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            if (extras != null) {
                customerId = extras.getInt("CustomerId");
            }
        }
        //tabbed Layout initialization
        TabLayout tabLayout = findViewById(R.id.CustomerHomePageTabLayout);//tabs currentOrderTab and orderHistoryTab
        ViewPager2 viewPager2 = findViewById(R.id.CustomerHomePageViewPager);
        viewPager2.setUserInputEnabled(false);//No touch scrolling allowed
        CustomerHomePageViewPagerAdapter adapter = new CustomerHomePageViewPagerAdapter(this,customerId,this);
        viewPager2.setAdapter(adapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());//the appropriate tab is set when selected
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

        findViewById(R.id.LogOutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
    public int getCustomerId()
    {
        return customerId;
    }

}