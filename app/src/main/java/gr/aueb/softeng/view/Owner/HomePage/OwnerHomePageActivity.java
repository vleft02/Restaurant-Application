package gr.aueb.softeng.view.Owner.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Login.LoginActivity;
import gr.aueb.softeng.view.Owner.AddRestaurant.AddRestaurantActivity;
import gr.aueb.softeng.view.Owner.RestaurantDetails.RestaurantDetailsActivity;

public class OwnerHomePageActivity extends AppCompatActivity implements OwnerHomePageView,
        OwnerHomePageRecyclerViewAdapter.ItemSelectionListener{
    public int ownerId;
    RecyclerView recyclerView;
    TextView emptyView;
    OwnerHomePageViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home_page);

        viewModel = new ViewModelProvider(this).get(OwnerHomePageViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            ownerId = extras.getInt("OwnerId");
        }
        viewModel.getPresenter().setOwner(ownerId);
        viewModel.getPresenter().setRestaurantList();
        // ui initialization
         recyclerView = findViewById(R.id.RestaurantRecyclerView);
         emptyView = findViewById(R.id.emptyView);
         viewModel.getPresenter().onChangeLayout();

        findViewById(R.id.AddRestaurantButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.getPresenter().onAddRestaurant();
            }
        });

    }
    @Override
    protected void onResume(){
        super.onResume();
        viewModel.getPresenter().setRestaurantList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OwnerHomePageRecyclerViewAdapter(viewModel.getPresenter().getRestaurantList(), this));
        viewModel.getPresenter().onChangeLayout();
    }

    @Override
    public void selectRestaurant(Restaurant restaurant) {
        Intent intent = new Intent(OwnerHomePageActivity.this, RestaurantDetailsActivity.class);
        intent.putExtra("RestaurantId", restaurant.getId());
        startActivity(intent);
    }
    public void AddRestaurant(){
        Intent intent = new Intent(OwnerHomePageActivity.this, AddRestaurantActivity.class);
        intent.putExtra("OwnerId",ownerId);
        startActivity(intent);
    }

    @Override
    public void changeLayout() {
        if (viewModel.getPresenter().getRestaurantList().isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new OwnerHomePageRecyclerViewAdapter(viewModel.getPresenter().getRestaurantList(), this));
        }
    }
}

