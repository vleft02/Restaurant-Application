package gr.aueb.softeng.view.Owner.HomePage;

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

import gr.aueb.softeng.view.Customer.ChooseRestaurant.ChooseRestaurantRecyclerViewAdapter;
import gr.aueb.softeng.view.Owner.AddRestaurant.AddRestaurantActivity;
import gr.aueb.softeng.view.Owner.RestaurantDetails.RestaurantDetailsActivity;

public class OwnerHomePageActivity extends AppCompatActivity implements OwnerHomePageView,
        OwnerHomePageRecyclerViewAdapter.ItemSelectionListener{
    public int ownerId;
    RecyclerView recyclerView;
    TextView emptyView;
    OwnerHomePageViewModel viewModel;
    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * Αρχικοποιεί το view model και περνάει στον presenter το view
     * Δίνει στον presenter το ownerId και αρχικοποιεί τα στοιχεία του layout
     * @param savedInstanceState το Instance state
     */
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

        findViewById(R.id.AddRestaurantButton).setOnClickListener(new View.OnClickListener() { //Όταν πατηθεί το κουμπί προσθήκης εστιατορίου
            public void onClick(View v) {
                viewModel.getPresenter().onAddRestaurant();
            }
        });

        findViewById(R.id.gobackButton5).setOnClickListener(new View.OnClickListener(){ //Όταν πατηθεί το κουμπί επιστροφής στην προηγούμενη σελίδα
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });

    }

    /**
     * Καλείται όταν επιστρέφουμε στην οθόνη αυτού του  activity
     * Ενημερώνει την λίστα με τα Restaurant μήπως προστέθκε κάποιο για να εμφανιστεί στο Recycler View, αλλά και τον adapter του recycler view
     * Καλεί την μέθοδο changeLyaout του presenter
     */
    @Override
    protected void onResume(){
        super.onResume();
        viewModel.getPresenter().setRestaurantList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OwnerHomePageRecyclerViewAdapter(viewModel.getPresenter().getRestaurantList(), this));
        viewModel.getPresenter().onChangeLayout();
    }

    /**
     *Καλεί το activity για την εμφάνιση των στοιχείων του εστιατορίου που περάστηκε σαν παράμετρος
     * @param restaurant το εστιατόριο που έχει επιλεχθεί στο Recycler View απο τον χρήστη
     */
    @Override
    public void selectRestaurant(Restaurant restaurant) {
        Intent intent = new Intent(OwnerHomePageActivity.this, RestaurantDetailsActivity.class);
        intent.putExtra("RestaurantId", restaurant.getId());
        startActivity(intent);
    }

    /**
     * Καλεί το activity στο οποίο θα περαστούν τα στοιχεία του νέου εστιατορίου που θέλουμε να προσθέσουμε στον ιδιοκτήτη
     */
    public void AddRestaurant(){
        Intent intent = new Intent(OwnerHomePageActivity.this, AddRestaurantActivity.class);
        intent.putExtra("OwnerId",ownerId);
        startActivity(intent);
    }

    /**
     * Ελέγχει εάν η λίστα με τα εστιατόρια που εμφανίζεται στο recycler view είναι άδεια ή οχι
     * Εάν είναι άδεια , βγάζει απο την οθόνη το Recycler View και κάνει visible το κέιμενο που ενημερώνει ότι η λίστα είναι άδεια
     * Διαφορετικά , εμφανίζει το Recycler View  , σετάρει τον adapter και βγάζει απο την οθόνη το κείμενο που αναφέρθηκε παραπάνω
     */

    @Override
    public void ShowNoRestaurants() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void ShowRestaurants() {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OwnerHomePageRecyclerViewAdapter(viewModel.getPresenter().getRestaurantList(), this));
    }


    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     *
     */
    public void goBack(){
        finish();
    }
}

