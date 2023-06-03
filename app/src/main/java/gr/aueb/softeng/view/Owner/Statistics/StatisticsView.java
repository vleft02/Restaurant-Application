package gr.aueb.softeng.view.Owner.Statistics;

public interface StatisticsView {
    void showErrorMessage(String title, String message);
    void goBack();
    void setAVGMonthlyIncome(String monthlyIncome);
    void setYearlyIncome(String yearlyIncome);
    void setCustExpenses(String custExpenses) ;
    void setAVGDailyRevenue(String revenue);
    void setOrderCancellationRate(String canc);
}
