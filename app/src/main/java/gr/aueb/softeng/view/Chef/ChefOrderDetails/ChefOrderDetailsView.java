package gr.aueb.softeng.view.Chef.ChefOrderDetails;


public interface ChefOrderDetailsView {
    void setOrderId(String orderId);
    void setOrderState(String state);
    void setTableNumber(String num);
    public void setDate(String date);

    void goBack();
}
