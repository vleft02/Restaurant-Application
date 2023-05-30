package gr.aueb.softeng.view.Customer.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;

public class CustomerHomePageActivity extends AppCompatActivity implements CustomerHomepageView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_hompepage);

        int customerId =-1;
        CustomerHomepagePresenter presenter = new CustomerHomepagePresenter(new CustomerDAOmemory(), new OrderDAOmemory());

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
        CustomerHomePageViewPagerAdapter adapter = new CustomerHomePageViewPagerAdapter(this,customerId);
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

}