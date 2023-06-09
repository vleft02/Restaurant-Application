package gr.aueb.softeng.view.Customer.OrderLineCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.team08.R;

/**
 * Σε αυτή την σελίδα ο χρήστης μπορεί να αφαιρέσει κάποιο orderLine που δεν θέλει
 */
public class OrderLineCartActivity extends AppCompatActivity implements OrderLineCartView,OrderLineSelectionListener {

    public ArrayList<OrderLine> orderLines;
    RecyclerView recyclerView;
    OrderLineCartViewModel viewModel;

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_line_cart);

        viewModel = new ViewModelProvider(this).get(OrderLineCartViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            orderLines = (ArrayList<OrderLine>) extras.getSerializable("OrderLines");
        }
            viewModel.getPresenter().setOrder(orderLines);
            recyclerView = findViewById(R.id.CartRecyclerView);
            setRecyclerView();
    }


    /**
     * Διαγραφή του OrderLine με κλήση μεθόδου στον presenter
     */
    @Override
    public void deleteOrderLine(OrderLine currentItem) {
        viewModel.getPresenter().onDeleteOrderLine(currentItem);
    }

    /**
     * Οταν πατάμε πίσω μεταφέρουμε της αλλαγές στa orderLines μέσω result
     */
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.putExtra("ModifiedOrderLines", viewModel.getPresenter().getOrderLines());// Add other data to the intent if needed
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }

    /**
     * Χρησιμοποιείται κάθε φορά που διαγράφεται ενα orderLine για να ανανεωθούν τα στοιχεία της λίστας
     */
    @Override
    public void setRecyclerView() {
        recyclerView.setLayoutManager(null);
        recyclerView.setAdapter(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderLineCartRecyclerViewAdapter(viewModel.getPresenter().getOrderLines(),this));
    }
}