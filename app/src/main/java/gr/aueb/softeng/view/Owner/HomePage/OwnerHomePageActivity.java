package gr.aueb.softeng.view.Owner.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;

public class OwnerHomePageActivity extends AppCompatActivity implements OwnerHomePageView,
        OwnerHomePageRecyclerViewAdapter.ItemSelectionListener{
int ownerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home_page);

        OwnerHomePageViewModel viewModel = new ViewModelProvider(this).get(OwnerHomePageViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            ownerId = extras.getInt("OwnerId");
        }
        viewModel.getPresenter().setOwner(ownerId);
        // ui initialization
        RecyclerView recyclerView = findViewById(R.id.RestaurantRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Restaurant> restaurantList = new ArrayList<>(viewModel.getPresenter().getRestaurants());
        recyclerView.setAdapter(new OwnerHomePageRecyclerViewAdapter(restaurantList, this));



    }

    @Override
    public void selectRestaurant(Restaurant restaurant) {
        Intent intent = new Intent(OwnerHomePageActivity.this, LoginActivity.class);
        intent.putExtra("RestaurantId", restaurant.getId());
        startActivity(intent);
    }
}

