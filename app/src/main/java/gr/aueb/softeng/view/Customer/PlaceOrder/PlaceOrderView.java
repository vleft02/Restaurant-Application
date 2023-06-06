package gr.aueb.softeng.view.Customer.PlaceOrder;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;

public interface PlaceOrderView {

    void changeLayout();

    void orderFailed();

    void redirectToCart(ArrayList<OrderLine> orderLines);

    void orderSuccess();
}
