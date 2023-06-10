package gr.aueb.softeng.view.Owner.Statistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gr.aueb.softeng.team08.R;

/**
 * Η κλάση αυτή εμφανίζει στην οθόνη τα στατιστικά του εστιατορίου που έχει επιλεχθεί
 */
public class StatisticsActivity extends AppCompatActivity implements StatisticsView {
    StatisticsViewModel viewModel;
    public int RestaurantId;

    /**
     * Εμφανίζει στην οθόνη το μέσο μηνιαίο εισόδημα του εστιατορίου
     * @param monthlyIncome το υπολογισμένο ποσό του μηνιαίου εισοδήματος σε μορφή String
     */
    public void setAVGMonthlyIncome(String monthlyIncome){
        ((TextView)findViewById(R.id.AvgMonthlyIncomeResult)).setText(monthlyIncome);
    }

    /**
     * Εμφανίζει στην οθόνη το ετήσιο εισόδημα του εστιατορίου
     * @param yearlyIncome το υπολογισμένο ετήσιο εισόδημα σε μορφή String
     */
    public void setYearlyIncome(String yearlyIncome){
        ((TextView)findViewById(R.id.YearlyIncomeResult)).setText(yearlyIncome);
    }

    /**
     * Εμφανίζει στην οθόνη τα έξοδα ανα πελάτη
     * @param orderExpenses τα υπολογισμένα έξοδα σε μορφή String
     */
    public void setAvgOrderExpenses(String orderExpenses){
        ((TextView)findViewById(R.id.AverageExpensesForCustomerResult)).setText(orderExpenses);
    }

    /**
     * Εμφανίζει στην οθόνη τα μέσα ημερήσια έξοδα
     * @param revenue το υπολογισμένο ποσό των μέσων ημερησίων εξόδων σε μορφή String
     */
    public void setAVGDailyRevenue(String revenue){
        ((TextView)findViewById(R.id.AverageDailyRevenueResult)).setText(revenue);
    }

    /**
     * Εμφανίζει στην οθόνη το ποσοστό των ακυρωμένων παραγγελιών
     * @param canc το υπολογισμένο ποσοστό ακυρωμένων παραγγελιών
     */
    public void setOrderCancellationRate(String canc){
        ((TextView)findViewById(R.id.OrderCancellationRateResult)).setText(canc + " %");
    }

    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(StatisticsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;

    /**
     * Δημιουργεί το layout και αρχικοποιεί το activity
     * Αρχικοποιούμε το view Model και περνάμε στον presenter το view
     * Πέρνουμε απο το activity που μας κάλεσε το id του εστιατορίου που θέλουμε να εμφανίσουμε τα στοιχεία
     * Καλούμε τα acitvities όταν πατηθούν τα κουμπιά της οθόνης
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_statistics);
        viewModel = new ViewModelProvider(this).get(StatisticsViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            RestaurantId = extras.getInt("RestaurantId");
        }
        viewModel.getPresenter().setRestaurant(RestaurantId);
        viewModel.getPresenter().calculateStats();
        findViewById(R.id.GoBack).setOnClickListener(new View.OnClickListener(){ // Όταν πατηθεί το κουμπί επιστροφής στην αρχική σελίδα
            @Override
            public void onClick(View v){viewModel.getPresenter().OnBack();}
        });
    }

    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    public void goBack(){
        finish();
    }
}