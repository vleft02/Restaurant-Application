package gr.aueb.softeng.view.Owner.Statistics;

import android.widget.TextView;

import gr.aueb.softeng.team08.R;

public interface StatisticsView {
    void showErrorMessage(String title, String message);
    void goBack();
    void setMonthlyIncome(String monthlyIncome);
    void setYearlyIncome(String yearlyIncome);
    void setCustExpenses(String custExpenses) ;
    void setAVGDailyRevenue(String revenue);
    void setOrderCancellationRate(String canc);
}
