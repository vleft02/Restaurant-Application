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

public class OwnerHomePageActivity extends AppCompatActivity implements OwnerHomePageView{
     //   OwnerHomePageRecyclerViewAdapter.ItemSelectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home_page);

        OwnerHomePageViewModel viewModel = new ViewModelProvider(this).get(OwnerHomePageViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
        }
    }
}
        // ui initialization
   /*     RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Restaurant> restaurantList = new ArrayList<>(viewModel.getPresenter().getSearchResult());
        recyclerView.setAdapter(new OwnerHomePageRecyclerViewAdapter(restaurantList, this)); */
