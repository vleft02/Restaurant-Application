package gr.aueb.softeng.view.Chef.ChefOrderDetails;

public class ChefOrderDetailsViewStub implements ChefOrderDetailsView{
    private String orderId,state,tableNumber,date,successMessage;
    private int goBackPressed;

    public ChefOrderDetailsViewStub(){
        orderId=state=tableNumber=date=successMessage="";
        goBackPressed=0;
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


}
