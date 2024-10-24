package gr.aueb.softeng.view.Customer.PlaceOrder;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import gr.aueb.softeng.domain.Dish;

import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Customer.OrderLineCart.OrderLineCartActivity;

/**
 * Σε αυτή την σελίδα ο χρήστης επιλέγει τα πιάτα και την ποσότητα που θέλει και οταν είναι έτοιμος προσπαθεί
 * να καταχεωρίσει την παραγγελία
 */
public class PlaceOrderActivity extends AppCompatActivity implements PlaceOrderView,DishSelectionListener{

    /**
     * Εμφανίζουμε pop up παράθυρο για να επιλέξουμε πόσοτητα του φαγητού που θέλουμε
     */
    private void showNumberPickerPopup(Dish dish) {

        PopupWindow popupWindow = new PopupWindow(this);

        View contentView = getLayoutInflater().inflate(R.layout.quantity_picker, null);
        popupWindow.setContentView(contentView);

        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        NumberPicker numberPicker = contentView.findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        Button confirmButton = contentView.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the selected number
                int quantity = numberPicker.getValue();
                viewModel.getPresenter().addOrderLine(quantity,dish);
                Toast.makeText(getApplicationContext(), "Selected number: " + quantity, Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
    }

    /**
     * Εμφανίζουμε Alert dialog παράθυρο για να ενημερώσουμε τον χρήστη ότι η παραγγελία απέτυχδ διότι
     * δεν έχει το απαραίτητο χρηματικό υπολοιπο. Έπειτα προωθείται στο Homepage
     */
    @Override
    public void insufficientFundsMessage()     {
        new android.app.AlertDialog.Builder(PlaceOrderActivity.this)
                .setCancelable(true)
                .setTitle("Η παραγγελία δεν ολοκληρώθηκε")
                .setMessage("Ανεπαρκές χρημστικό υπολοιπο")
                .setPositiveButton("OK",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).create().show();


    }
    /**
     * Εμφανίζουμε Alert dialog παράθυρο για να ενημερώσουμε τον χρήστη για το συνολικό κόστος της παραγγελίας.
     * 'Επειτα ο χρήστης είτε διαλέγει να την ολοκληρώσει επιλέγοντας "Ναι" και σετάροντας μια μεταβλητή isConfirmed true
     * ή επιλέγει "Οχι" σετάρει την μεταβλητή isConfirmed σε false και κλείνει το παράθυρο.
     */
    @Override
    public void ShowConfirmationMessage(ConfirmationListener confirmationListener) {
        new AlertDialog.Builder(PlaceOrderActivity.this)
                .setTitle("Ολοκλήρωση Παραγγελίας")
                .setMessage("Το σύνολο της Παραγγελίας σας είναι " + String.format("%.2f",viewModel.getPresenter().getTotalCost())+" €"+"\nΠραγματοποίηση Παραγγελίας;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        confirmationListener.onConfirmation(true);
                    }
                })
                .setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        confirmationListener.onConfirmation(false);
                    }
                }).create().show();

    }

    private ActivityResultLauncher<Intent> cartActivityResultLauncher;
    private PlaceOrderViewModel viewModel;
    private int customerId = -1;
    private int restaurantId = -1;

    private int tableNumber = 0;
    private RecyclerView recyclerView;
    private TextView emptyView;
    private Button placeOrderButton;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_place_order);
        viewModel = new ViewModelProvider(this).get(PlaceOrderViewModel.class);
        viewModel.getPresenter().setView(this);

       cartActivityResultLauncher = registerForActivityResult(
               new ActivityResultContracts.StartActivityForResult(),
               result -> {
                   if (result.getResultCode() == RESULT_OK) {
                       Intent data = result.getData();
                       if (data != null && data.hasExtra("ModifiedOrderLines")) {
                           ArrayList<OrderLine> modifiedOrderLines = (ArrayList<OrderLine>) data.getSerializableExtra("ModifiedOrderLines");
                           viewModel.getPresenter().setOrderLines(modifiedOrderLines);
                           // Update the orderLines in PlaceOrderActivity using the modifiedOrderLines
                       }
                   }
               }
       );

        if (savedInstanceState == null)
        {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras!=null)
            {
                customerId = extras.getInt("CustomerId");
                restaurantId = extras.getInt("RestaurantId");
                tableNumber = extras.getInt("TableNumber");
            }
        }
        viewModel.getPresenter().setRestaurant(restaurantId);
        viewModel.getPresenter().setCustomer(customerId);
        viewModel.getPresenter().createOrder(tableNumber);

       recyclerView = findViewById(R.id.DishRecyclerView);
       emptyView = findViewById(R.id.NoDishes);
       placeOrderButton = findViewById(R.id.PlaceOrdersButton);

       viewModel.getPresenter().onChangeLayout();


       findViewById(R.id.PlaceOrdersButton).setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               viewModel.getPresenter().onPlaceOrder();
           }
       });
       findViewById(R.id.CartButton).setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               viewModel.getPresenter().onCart();
           }
       });
    }

    /**
     * Επιλέγουμε το πίατο και καλείται η μέθοδος για επιλογή ποσότητας
     */
    @Override
    public void selectDish(Dish currentDish) {
        showNumberPickerPopup(currentDish);
    }


    /**
     * Κρυβουμε το recyclerView και το κοθμπί για ολοκλήρωση παραγγελίας
     * ενω εμφανίζουμε το μήνυμα μη ύπαρξης πιάτων.
     */
    @Override
    public void showEmptyList()
    {
        recyclerView.setVisibility(View.GONE);
        placeOrderButton.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);

    }

    /**
     * Εμφανίζουμε και σετάρουμε το recyclerView το κουμπί για ολοκλήρωση παραγγελίας
     * ενώ κρύβουμε το μήνυμα οτι δεν υπάρχουν πιάτα
     */
    @Override
    public void showDishList()
    {
        recyclerView.setVisibility(View.VISIBLE);
        placeOrderButton.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DishRecyclerViewAdapter(viewModel.getPresenter().getDishes(),this));
    }


    /**
     * Προωθούμαστε στο σελίδα επισκόπησης των περιεχομενων της παραγγελίας
     * περιμένωντας να επιστρέψει ή πιαθνός τροποποιημένη λιστα με orderlines
     */
    @Override
    public void redirectToCart(ArrayList<OrderLine> orderLines) {
        Intent intent = new Intent(PlaceOrderActivity.this , OrderLineCartActivity.class);

        intent.putExtra("OrderLines", (Serializable) orderLines);
        cartActivityResultLauncher.launch(intent);
    }

    @Override
    public void goBack()
    {
        finish();
    }


}
