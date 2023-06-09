package gr.aueb.softeng.view.Chef.OrderDetails;
import gr.aueb.softeng.team08.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Η κλάση αυτή εμφανίζει τα στοιχεία της επιλεγμένης παραγγελίας στην οθόνη του σέφ
 */
public class OrderDetailsActivity extends AppCompatActivity  implements OrderDetailsView {

    public int OrderId;
    RecyclerView recyclerView;
    OrderDetailsViewModel viewModel;

    Button setCompletedButton;

    boolean isCustomer;
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
        setContentView(R.layout.activity_order_details);

        viewModel = new ViewModelProvider(this).get(OrderDetailsViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            OrderId = extras.getInt("OrderId");
            isCustomer = extras.getBoolean("IsCustomer");

        }

        viewModel.getPresenter().setOrder(OrderId);
        viewModel.getPresenter().setOrderLineList();
        viewModel.getPresenter().setOrderDetails();
        // ui initialization
        recyclerView = findViewById(R.id.OrderLinesRecyclerView);
        setCompletedButton  = findViewById(R.id.SetCompletedButton);

        //changeLayout depending on who is using it(chef or customer)
        viewModel.getPresenter().chooseLayout(isCustomer);

        findViewById(R.id.SetCompletedButton).setOnClickListener(new View.OnClickListener() { //Το κουμπί που πατιέται όταν μια παραγγελία πατηθεί ότι είναι completed
            public void onClick(View v) {
                viewModel.getPresenter().onCompleted();
            }
        });

        findViewById(R.id.GoBack3).setOnClickListener(new View.OnClickListener(){ // To κουμπί επιστροφής στην αρχική οθόνη
            @Override
            public void onClick(View v){viewModel.getPresenter().OnBack();}
        });
    }

    /**
     * Η μέθοδος αυτή εμφανίζει μήνυμα επιτυχίας στην οθόνη και καλείται όταν η παραγγελία γίνεται Completed από τον μάγειρα
     * Επίσης , δημιουργεί μία onClick listener η οποία όταν πατηθεί το OK στην οθόνη , μας
     * επιστρέφει στο προηγούμενο activity που μας κάλεσε
     */
    public void showOrderCompletedMessage()
    {
        new AlertDialog.Builder(OrderDetailsActivity.this)
                .setCancelable(true)
                .setTitle("Επιτυχής ολοκλήρωση της παραγγελίας")
                .setMessage("Η παραγγελία προστέθηκε στην λίστα των ολοκληρωμένων παραγγελιών!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).create().show();
    }
    /**
     * Κρύβει το κουμπί του SetCompletedButton που είναι για τις περιπτώσεις που το activity καλείται απο τον customer
     */
    @Override
    public void hideCompletionButton() {
        setCompletedButton.setVisibility(View.GONE);
    }

    /**
     * Εμφανίζει το κουμπί του SetCompletedButton που είναι για τις περιπτώsεις του μάγειρα ώστε να μπορεί να την αλλάξει
     */
    @Override
    public void showCompletedButton() {
        setCompletedButton.setVisibility(View.VISIBLE);
    }
    /**
     * Καλείται όταν επιστρέφουμε στην οθόνη αυτού του  activity
     * Ενημερώνει την λίστα με τα Order Lines μήπως προστέθηκε κάποιο για να εμφανιστεί στο Recycler View, αλλά και τον adapter του recycler view
     * Καλεί την μέθοδο changeLyaout του presenter
     */
    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getPresenter().setOrderLineList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderDetailsRecyclerViewAdapter(viewModel.getPresenter().getOrderLineList()));
    }

    /**
     * Εμφανίζει στην οθόνη το id της παραγγελίας που έχει πατηθεί
     * @param orderId το μοναδικό id της παραγγελίας
     */
    public void setOrderId(String orderId){
        ((TextView)findViewById(R.id.OrderIdText)).setText("Id:"+orderId);
    }

    /**
     * Εμφανίζει στην οθόνη την κατάσταση της τρέχουσας επιλεγμένης παραγγελίας
     * @param state η κατάσταση της παραγγελίας
     */
    public void setOrderState(String state){
        ((TextView)findViewById(R.id.OrderStateText)).setText("State:"+state);
    }

    /**
     * Εμφανίζει στην οθόνη τον αριθμό τραπεζιού όπου έγινε η παραγγελία
     * @param num ο αριθμός του τραπεζιού
     */
    public void setTableNumber(String num){
        ((TextView)findViewById(R.id.TableNumberText)).setText("Table:"+num);
    }

    /**
     * Εμφανιζει στην οθόνη την ώρα και λεπτό που έγινε η παραγγελία
     * @param date η ώρα και το λεπτό σε μορφή ενωμένου String
     */
    public void setDate(String date){
        ((TextView)findViewById(R.id.DateText)).setText(date);
    }
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     *
     */
    public void goBack(){
        finish();
    }


}