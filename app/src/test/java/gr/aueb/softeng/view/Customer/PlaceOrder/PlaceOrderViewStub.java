package gr.aueb.softeng.view.Customer.PlaceOrder;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;

public class PlaceOrderViewStub implements PlaceOrderView{

    private boolean dishListEmpty;
    private String message;

    private ArrayList<OrderLine> returnedOrderLines;
    private boolean placeOrder;


    public PlaceOrderViewStub()
    {
        message="";
        placeOrder =false;
    }

    public void setPlaceOrder(boolean placeOrder) {
        this.placeOrder = placeOrder;
    }

    public boolean getDishListEmpty()
    {
        return dishListEmpty;
    }

    public ArrayList<OrderLine> getReturnedOrderLines() {
        return returnedOrderLines;
    }

    public String getMessage(){
        return message;
    }
    @Override
    public void redirectToCart(ArrayList<OrderLine> orderLines) {
        returnedOrderLines = orderLines;
    }

    @Override
    public void showEmptyList()
    {
        dishListEmpty = true;
    }

    @Override
    public void showDishList() {
        dishListEmpty = false;
    }

    @Override
    public void insufficientFundsMessage() {
        message = "insufficient funds";
    }

    @Override
    public void ShowConfirmationMessage(ConfirmationListener confirmationListener) {
        if (placeOrder == true)
            confirmationListener.onConfirmation(true);
        else
        {
            confirmationListener.onConfirmation(false);
        }
    }

    @Override
    public void goBack() {
        message = "redirecting to homepage";
    }
}
