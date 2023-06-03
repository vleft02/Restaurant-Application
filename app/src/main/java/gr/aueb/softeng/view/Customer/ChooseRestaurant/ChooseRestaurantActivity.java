package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Customer.HomePage.CustomerHomePageActivity;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageRecyclerViewAdapter;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageViewModel;

public class ChooseRestaurantActivity extends AppCompatActivity implements ChooseRestaurantView, ChooseRestaurantRecyclerViewAdapter.RestaurantSelectionListener {

    ChooseRestaurantViewModel viewModel;
    int customerId;
    RecyclerView recyclerView;
    TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_restaurant);

        viewModel = new ViewModelProvider(this).get(ChooseRestaurantViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            customerId = extras.getInt("CustomerId");
        }
        viewModel.getPresenter().setRestaurantList();
        // ui initialization
        recyclerView = findViewById(R.id.ChooseRestaurantRecyclerView);
        emptyView = findViewById(R.id.NoRestaurants);
        viewModel.getPresenter().onChangeLayout();

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
            recyclerView.setAdapter(new ChooseRestaurantRecyclerViewAdapter(viewModel.getPresenter().getRestaurantList(), this));
        }
    }

    @Override
    public void selectRestaurant(Restaurant restaurant) {
        Intent intent = new Intent(ChooseRestaurantActivity.this, CustomerHomePageActivity.class);
        intent.putExtra("RestaurantId",restaurant.getId());
        intent.putExtra("CustomerId",customerId);
        startActivity(intent);
    }
}