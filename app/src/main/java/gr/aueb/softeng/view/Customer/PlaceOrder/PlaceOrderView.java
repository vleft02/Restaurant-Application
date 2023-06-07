package gr.aueb.softeng.view.Customer.PlaceOrder;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;

public interface PlaceOrderView {
    void orderFailed();
    void redirectToCart(ArrayList<OrderLine> orderLines);
    void showEmptyList();
    void showDishList();
    void orderSuccess();
}
