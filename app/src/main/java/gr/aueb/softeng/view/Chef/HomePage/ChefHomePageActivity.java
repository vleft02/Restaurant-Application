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
import gr.aueb.softeng.view.Chef.OrderDetails.OrderDetailsActivity;

public class ChefHomePageActivity extends AppCompatActivity implements ChefHomePageView,
            ChefHomePageRecyclerViewAdapter.ItemSelectionListener{

    public int chefId;
    RecyclerView recyclerView;
    TextView emptyView;
    ChefHomePageViewModel viewModel;
    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * Αρχικοποιεί το view model και περνάει στον presenter το view
     * Δίνει στον presenter το chefId και αρχικοποιεί τα στοιχεία του layout
     * @param savedInstanceState το Instance state
     */
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
        emptyView = findViewById(R.id.emptyOrdersChefText); // το TextView που εμφανίζεται όταν είναι άδεια η λίστα με τις παραγγελίες
        viewModel.getPresenter().onChangeLayout();

        findViewById(R.id.gobackButton4).setOnClickListener(new View.OnClickListener(){ // Το κουμπί επιστροφής στην προηγούμενη σελίδα
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });

    }
    /**
     * Καλείται όταν επιστρέφουμε στην οθόνη αυτού του  activity
     * Ενημερώνει την λίστα με τις παραγγελίες μήπως προστέθκε κάποιο για να εμφανιστεί στο Recycler View, αλλά και τον adapter του recycler view
     * Καλεί την μέθοδο changeLyaout του presenter
     */
    @Override
    protected void onResume(){
        super.onResume();
        viewModel.getPresenter().setOrderList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChefHomePageRecyclerViewAdapter(viewModel.getPresenter().getOrderList(), this));
        viewModel.getPresenter().onChangeLayout();
    }
    /**
     *Καλεί το activity για την εμφάνιση των στοιχείων της παραγγελίας που περάστηκε σαν παράμετρος
     * @param order η παραγγελία που έχει επιλεχθεί στο Recycler View απο τον μάγειρα
     */
    @Override
    public void selectOrder(Order order) {
        Intent intent = new Intent(ChefHomePageActivity.this, OrderDetailsActivity.class);
        intent.putExtra("IsCustomer", false);
        intent.putExtra("OrderId", order.getId());
        startActivity(intent);
    }
    /**
     * Ελέγχει εάν η λίστα με τις παραγγελίες που εμφανίζεται στο recycler view είναι άδεια ή οχι
     * Εάν είναι άδεια , βγάζει απο την οθόνη το Recycler View και κάνει visible το κέιμενο που ενημερώνει ότι η λίστα είναι άδεια
     * Διαφορετικά , εμφανίζει το Recycler View  , σετάρει τον adapter και βγάζει απο την οθόνη το κείμενο που αναφέρθηκε παραπάνω
     */
    @Override
    public void ShowNoOrders() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void ShowOrders() {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChefHomePageRecyclerViewAdapter(viewModel.getPresenter().getOrderList(), this));
    }
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     */
    public void goBack(){
        finish();
    }
}