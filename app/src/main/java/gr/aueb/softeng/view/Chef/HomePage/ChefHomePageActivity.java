package gr.aueb.softeng.view.Chef.HomePage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import gr.aueb.softeng.team08.R;

public class ChefHomePageActivity extends AppCompatActivity implements ChefHomePageView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_home_page);
    }
}