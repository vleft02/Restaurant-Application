package gr.aueb.softeng.view.Chef.OrderDetails;

public class OrderDetailsViewStub implements OrderDetailsView{
    private String orderId,state,tableNumber,date,successMessage;
    private int goBackPressed;

    private boolean isSetCompletedButtonVisible;
    public boolean isSetCompletedButtonIsVisible() {
        return isSetCompletedButtonVisible;
    }

    public OrderDetailsViewStub(){
        orderId=state=tableNumber=date=successMessage="";
        goBackPressed=0;
        isSetCompletedButtonVisible = false;
    }
    @Override
    public void setOrderId(String orderId) {
        this.orderId=orderId;
    }
    public String getOrderId(){
        return orderId;
    }

    @Override
    public void setOrderState(String state) {
        this.state=state;
    }
    public String getState(){
        return this.state;
    }

    @Override
    public void setTableNumber(String num) {
        this.tableNumber = num;
    }
    public String getTableNumber(){
        return this.tableNumber;
    }

    @Override
    public void setDate(String date) {
        this.date=date;
    }
    public String getDat(){
        return this.date;
    }

    @Override
    public void goBack() {
        goBackPressed++;
    }
    public int getGoBackPressed(){
        return goBackPressed;
    }
    public String getSuccessMessage()
    {
        return successMessage;
    }

    @Override
    public void showOrderCompletedMessage() {
        successMessage = "the order was completed";
    }

    @Override
    public void hideCompletionButton() {
        isSetCompletedButtonVisible = false;
    }

    @Override
    public void showCompletedButton() {
        isSetCompletedButtonVisible =true;
    }


}
