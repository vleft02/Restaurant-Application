package gr.aueb.softeng.view.Owner.Statistics;

public class StatisticsViewStub implements StatisticsView{

private String errorTitle,errorMessage,AVGMonthlyIncome,YearlyIncome,AvgOrderExpenses,AvgDailyRevenue,OrderCancellationRate;
private int goBackPressed,errorCount;

    public StatisticsViewStub(){
        errorTitle=errorMessage=AVGMonthlyIncome=YearlyIncome=AvgOrderExpenses=AvgDailyRevenue=OrderCancellationRate="";
        goBackPressed=errorCount=0;
    }


    @Override
    public void showErrorMessage(String title, String message) {
        errorTitle = title;
        errorMessage = message;
        errorCount++;
    }

    @Override
    public void goBack() {
        goBackPressed++;
    }

    @Override
    public void setAVGMonthlyIncome(String monthlyIncome) {
        this.AVGMonthlyIncome=monthlyIncome;
    }

    @Override
    public void setYearlyIncome(String yearlyIncome) {
        this.YearlyIncome= yearlyIncome;
    }

    @Override
    public void setAvgOrderExpenses(String orderExpenses) {
        this.AvgOrderExpenses=orderExpenses;
    }

    @Override
    public void setAVGDailyRevenue(String revenue) {
        this.AvgDailyRevenue=revenue;
    }

    @Override
    public void setOrderCancellationRate(String canc) {
        this.OrderCancellationRate=canc;
    }

    public String getErrorTitle()
    {
        return errorTitle;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getGoBackPressed(){return goBackPressed;}
    public String getAVGMonthlyIncome(){
        return this.AVGMonthlyIncome;
    }
    public String getYearlyIncome(){
        return this.YearlyIncome;
    }
    public String getAvgOrderExpenses(){
        return this.AvgOrderExpenses;
    }
    public String getAvgDailyRevenue(){
        return this.AvgDailyRevenue;
    }
    public String getOrderCancellationRate(){
        return this.OrderCancellationRate;
    }
}
