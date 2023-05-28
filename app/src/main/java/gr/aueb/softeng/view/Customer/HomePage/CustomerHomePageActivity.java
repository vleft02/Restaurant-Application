package gr.aueb.softeng.view.Customer.HomePage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import gr.aueb.softeng.team08.R;

public class CustomerHomePageActivity extends AppCompatActivity implements CustomerHomepageView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chooseLayout();
        setContentView(R.layout.activity_customer_hompepage);

        //tabbed Layout initialization
        TabLayout tabLayout = findViewById(R.id.CustomerHomePageTabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.CustomerHomePageViewPager);
        viewPager2.setUserInputEnabled(false);
        CustomerHomePageViewPagerAdapter adapter = new CustomerHomePageViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
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


        final CustomerHomepagePresenter presenter = new CustomerHomepagePresenter();

    }

    @Override
    public void chooseLayout() {

    }
}