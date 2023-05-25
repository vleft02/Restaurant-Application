package gr.aueb.softeng.view.Customer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.softeng.team08.R;

public class CustomerHomepageActivity extends AppCompatActivity implements CustomerHomepageView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chooseLayout();
        setContentView(R.layout.activity_customer_hompepage);

        final CustomerHomepagePresenter presenter = new CustomerHomepagePresenter();

    }

    @Override
    public void chooseLayout() {

    }
}