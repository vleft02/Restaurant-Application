package gr.aueb.softeng.view.Customer.TopUp;

public class TopUpViewStub implements TopUpView{


    private String balance;
    private int customerId;

    double oldBalance, newBalance;

    public TopUpViewStub()
    {
        balance = "";
        oldBalance = newBalance = 0;
        customerId = 0;
    }
    public void setCustomerId(int id){
        customerId = id;
    }

    @Override
    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public int getCustomerId() {
        return customerId;
    }

    public String getBalance() {
        return balance;
    }
}
