package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import gr.aueb.softeng.view.Chef.ChefOrderDetails.ChefOrderDetailsView;

public class ChefOrderDetailsViewStub implements ChefOrderDetailsView {
    private String orderId;
    private String orderState;
    private String tableNumber;
    private String date;
    private boolean goBackPressed;

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void setOrderState(String state) {
        this.orderState = state;
    }

    @Override
    public void setTableNumber(String num) {
        this.tableNumber = num;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void goBack() {
        goBackPressed = true;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderState() {
        return orderState;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public String getDate() {
        return date;
    }

    public boolean isGoBackPressed() {
        return goBackPressed;
    }
}
