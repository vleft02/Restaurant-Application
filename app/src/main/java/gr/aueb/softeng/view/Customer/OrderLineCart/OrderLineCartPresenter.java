package gr.aueb.softeng.view.Customer.OrderLineCart;

import java.util.ArrayList;

import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.OrderLine;

public class OrderLineCartPresenter {
    private OrderLineCartView view;
    private ArrayList<OrderLine> orderLines;

    public void setView(OrderLineCartView view) {
    this.view = view;
}

    public void setOrder(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void onDeleteOrderLine(OrderLine currentItem) {
        orderLines.remove(currentItem);
        view.setRecyclerView();
    }
}
