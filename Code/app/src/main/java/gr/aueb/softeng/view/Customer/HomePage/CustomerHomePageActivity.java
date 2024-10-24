package gr.aueb.softeng.view.Customer.HomePage;

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


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;


import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Chef.OrderDetails.OrderDetailsActivity;
import gr.aueb.softeng.view.Customer.PlaceOrder.PlaceOrderActivity;
import gr.aueb.softeng.view.Customer.TopUp.TopUpActivity;


/**
 * Σε αυτή την σελίδα ο χρήστης μπορεί να δεί τη  τωρινή του παραγγελία να την ακυρώσει να δει
 * το ιστορικό των παραγγελιών του ή να προωθηθεί στην σελίδα top up και στην σελίδα καταχώρησης παραγγελίας
 */
public class CustomerHomePageActivity extends AppCompatActivity implements CustomerHomepageView,FragmentListener{

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private int customerId = -1;
    private int restaurantId = -1;
    private CustomerHomePageViewModel viewModel;
    private int tableNumber = 0;

    /**
     * Εμφανίζεται pop up παράθυρο για την επιλογή
     * ενος ακεραίου που αντιστοιχεί στον αριθμό του
     * τραπεζιού για την παραγγελία που πρόκειται να
     * υποβληθεί.
     */
    public void showTableNumberPickerPopup() {

        PopupWindow popupWindow = new PopupWindow(this);

        // Set the content view of the pop-up window
        View contentView = getLayoutInflater().inflate(R.layout.quantity_picker, null);
        popupWindow.setContentView(contentView);

        // Set the width and height of the pop-up window
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        // Configure the NumberPicker
        NumberPicker numberPicker = contentView.findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(viewModel.getPresenter().getRestaurantCapacity());

        // Configure the Confirm button
        Button confirmButton = contentView.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the selected number
                int tableNo = numberPicker.getValue();
                if (viewModel.getPresenter().checkTableAvailability(tableNo))
                {
                    tableNumber = tableNo;
                    popupWindow.dismiss();
                    redirectPlaceOrder();
                }// Dismiss the pop-up window
                else
                {
                    tableUnavailableMessage();
                }
            }
        });

        // Show the pop-up window
        popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
    }

    /**
     * Εμφανίζει ενα μήνυμα τύπου alert
     * για την μη διαθεσιμότητα του τραπεζιού
     * που επιλέγχθηκε με το pop up window
     * της μεθόδου showTableNumberPickerPopup()
     */
    public void tableUnavailableMessage()
    {
        new android.app.AlertDialog.Builder(CustomerHomePageActivity.this)
                .setCancelable(true)
                .setTitle("Μη διαθέσιμο Τραπέζι")
                .setMessage("Το τραπέζι που επιλέξατε δεν είναι διαθέσιμο")
                .setPositiveButton("OK", null).create().show();
    }

    /**
     * Εμφανίζει ενα μήνυμα τύπου alert
     * Για να ρωτήσει τον χρήστη αν είναι σίγουρος
     * οτι θέλει να ακυρώσει την παραγγελία
     */
    public void ShowConfirmationMessage() {
        new AlertDialog.Builder(CustomerHomePageActivity.this)
                .setTitle("Ακύρωση Παραγγελίας")
                .setMessage("Είστε σίγουροι οτι θέλετε να συνεχίσετε;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.getPresenter().cancel();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();

    }


    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_customer_homepage);


        viewModel = new ViewModelProvider(this).get(CustomerHomePageViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null)
        {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            if (extras != null) {
                customerId = extras.getInt("CustomerId");
                restaurantId = extras.getInt("RestaurantId");
            }
        }
        viewModel.getPresenter().setCustomer(customerId);
        viewModel.getPresenter().setRestaurant(restaurantId);
        viewModel.getPresenter().setCurrentOrder();

        //tabbed Layout initialization
        tabLayout = findViewById(R.id.CustomerHomePageTabLayout);//tabs currentOrderTab and orderHistoryTab
        viewPager2 = findViewById(R.id.CustomerHomePageViewPager);
        viewPager2.setUserInputEnabled(false);//No touch scrolling allowed
        CustomerHomePageViewPagerAdapter adapter = new CustomerHomePageViewPagerAdapter(this,this);
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());//the appropriate tab is set when selecte
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
        });

        findViewById(R.id.TopUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onTopUp();
            }
        });





    }

    @Override
    protected void onPause() {
        super.onPause();
        viewPager2.setAdapter(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager2.setAdapter(new CustomerHomePageViewPagerAdapter(this,this));
        viewModel.getPresenter().setCurrentOrder();
        viewModel.getPresenter().setOrderHistory();
    }

    /**
     * Προωθούμαστε στη σελίδα ανανέωσης χρηαμτικού υπολοίπου
     */
    public void redirectTopUp() {
        Intent intent = new Intent(CustomerHomePageActivity.this , TopUpActivity.class) ;
        intent.putExtra("CustomerId",customerId);
        startActivity(intent);
    }


    /**
     * Παίρνουμε το fragment του tabLayout και εμφανίζουμε το current Order
     * κρύβοντας τα υπολοιπα γραφικά στοιχεία
     */
    @Override
    public void showCurrentOrder() {
        if (((CustomerHomePageViewPagerAdapter)viewPager2.getAdapter()).getCurrFragment() instanceof CurrentOrderPageFragment) {
            CurrentOrderPageFragment currFragment = (CurrentOrderPageFragment) ((CustomerHomePageViewPagerAdapter)viewPager2.getAdapter()).getCurrFragment();
            currFragment.showCurrentOrder();
        }}

    /**
     * Παίρνουμε το fragment του tabLayout και κρύβουμε το πλαίσιο που θα έιχε τα στοιχεία τις παραγγελίας
     * αλλα εμφανίζουμε τα υπολοιπα στοιχεία απαραίτητα γαι την προσθήκη νεας παραγγελίας (Μηνυμα καθοδηγσης, + κουμπι)
     */
    @Override
    public void showNoCurrentOrder() {
        if (((CustomerHomePageViewPagerAdapter)viewPager2.getAdapter()).getCurrFragment() instanceof CurrentOrderPageFragment) {
            CurrentOrderPageFragment currFragment = (CurrentOrderPageFragment) ((CustomerHomePageViewPagerAdapter) viewPager2.getAdapter()).getCurrFragment();
            currFragment.showNoCurrentOrder();
        }
    }


    public CustomerHomePageViewModel getViewModel()
    {
        return viewModel;
    }

    /**
     * Προωθούμαστε στη σελίδα επισκόπησης στοιχείων της ενεργής παραγγελίας
     */
    @Override
    public void redirectToOrderDetails() {
        Intent intent = new Intent(CustomerHomePageActivity.this , OrderDetailsActivity.class) ;
        intent.putExtra("IsCustomer",true);
        intent.putExtra("OrderId",viewModel.getPresenter().getCurrentOrder().getId());
        startActivity(intent);
    }

    /**
     * Προωθούμαστε στη σελίδα επισκόπησης στοιχείων μιας παραγγελία
     * που επιλέχθηκε απο το ιστορικό
     */
    @Override
    public void redirectToOrderDetails(int id) {
        Intent intent = new Intent(CustomerHomePageActivity.this , OrderDetailsActivity.class) ;
        intent.putExtra("IsCustomer",true);
        intent.putExtra("OrderId",id);
        startActivity(intent);
    }

    public void redirectPlaceOrder()
    {
        Intent intent = new Intent(CustomerHomePageActivity.this , PlaceOrderActivity.class) ;
        intent.putExtra("RestaurantId",restaurantId);
        intent.putExtra("CustomerId",customerId);
        intent.putExtra("TableNumber",tableNumber);
        startActivity(intent);
    }

}