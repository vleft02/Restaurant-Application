package gr.aueb.softeng.view.Owner.HomePage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import gr.aueb.softeng.team08.R;

public class OwnerHomePageActivity extends AppCompatActivity implements OwnerHomePageView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home_page);
    }
}