package gr.aueb.softeng.view.Chef.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Chef.ChefOrderDetails.ChefOrderDetailsActivity;

public class ChefHomePageActivity extends AppCompatActivity implements ChefHomePageView,
            ChefHomePageRecyclerViewAdapter.ItemSelectionListener{

    public int chefId;
    RecyclerView recyclerView;
    TextView emptyView;
    ChefHomePageViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_home_page);

        viewModel = new ViewModelProvider(this).get(ChefHomePageViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            chefId = extras.getInt("ChefId");
        }
        viewModel.getPresenter().setChef(chefId);
        viewModel.getPresenter().setOrderList();
        // ui initialization
        recyclerView = findViewById(R.id.recyclerViewChef);
        emptyView = findViewById(R.id.emptyOrdersChefText);
        viewModel.getPresenter().onChangeLayout();

        findViewById(R.id.gobackButton4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        viewModel.getPresenter().setOrderList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChefHomePageRecyclerViewAdapter(viewModel.getPresenter().getOrderList(), this));
        viewModel.getPresenter().onChangeLayout();
    }

    @Override
    public void selectOrder(Order order) {
        Intent intent = new Intent(ChefHomePageActivity.this, ChefOrderDetailsActivity.class);
        intent.putExtra("OrderId", order.getId());
        startActivity(intent);
    }

    @Override
    public void changeLayout() {
        if (viewModel.getPresenter().getOrderList().isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ChefHomePageRecyclerViewAdapter(viewModel.getPresenter().getOrderList(), this));
        }
    }
    public void goBack(){
        finish();
    }
}