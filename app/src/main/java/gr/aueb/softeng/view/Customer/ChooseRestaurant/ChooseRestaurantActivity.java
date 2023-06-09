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

/**
 * Σε αυτή την σελίδα ο χρήστης διαλέγει το εστιατόριο στο οποίο θέλει να παραγγείλει
 */
public class ChooseRestaurantActivity extends AppCompatActivity implements ChooseRestaurantView, ChooseRestaurantRecyclerViewAdapter.RestaurantSelectionListener {

    ChooseRestaurantViewModel viewModel;
    int customerId;
    RecyclerView recyclerView;
    TextView emptyView;

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
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
        findViewById(R.id.gobackButton6).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });

    }

    /**
     *  Αυτή η μέθοδος καλείται οταν επιλέξουμε το εστιατόρια και προοθούμαστε στο HomePage
     *  @param restaurant το εστιατόριο που επιλεχτηκε
     */
    @Override
    public void selectRestaurant(Restaurant restaurant) {
        Intent intent = new Intent(ChooseRestaurantActivity.this, CustomerHomePageActivity.class);
        intent.putExtra("RestaurantId",restaurant.getId());
        intent.putExtra("CustomerId",customerId);
        startActivity(intent);
    }
    public void goBack(){
        finish();
    }

    /**
     * Κρυβουμε το recyclerView και κάνουμε ορατό μήνυμα ενημέρωσης για την
     * απουσία εστιατορίων
     */
    @Override
    public void ShowNoRestaurants() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    /**
     * Εμφανίζουμαι και σετάρουμε το recyclerView και κάνουμε κρύβουμε το μηνυμα
     * απουσίας εστιατορίων
     */
    @Override
    public void ShowRestaurants() {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChooseRestaurantRecyclerViewAdapter(viewModel.getPresenter().getRestaurantList(), this));
    }
}