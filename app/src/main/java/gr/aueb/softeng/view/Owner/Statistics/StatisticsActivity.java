package gr.aueb.softeng.view.Owner.Statistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Owner.RestaurantDetails.RestaurantDetailsActivity;
import gr.aueb.softeng.view.Owner.RestaurantDetails.RestaurantDetailsViewModel;

public class StatisticsActivity extends AppCompatActivity implements StatisticsView {
    StatisticsViewModel viewModel;
    public int RestaurantId;

    public void setMonthlyIncome(String monthlyIncome){
        ((TextView)findViewById(R.id.MonthlyIncomeResult)).setText(monthlyIncome);
    }
    public void setYearlyIncome(String yearlyIncome){
        ((TextView)findViewById(R.id.YearlyIncomeResult)).setText(yearlyIncome);
    }
    public void setCustExpenses(String custExpenses){
        ((TextView)findViewById(R.id.AverageExpensesForCustomerResult)).setText(custExpenses);
    }
    public void setAVGDailyRevenue(String revenue){
        ((TextView)findViewById(R.id.AverageDailyRevenueResult)).setText(revenue);
    }
    public void setOrderCancellationRate(String canc){
        ((TextView)findViewById(R.id.OrderCancellationRateResult)).setText(canc);
    }


    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(StatisticsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        findViewById(R.id.GoBack).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){viewModel.getPresenter().OnBack();}
        });
    }
    public void goBack(){
        finish();
    }
}