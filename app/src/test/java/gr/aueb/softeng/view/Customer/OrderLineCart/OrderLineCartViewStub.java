package gr.aueb.softeng.view.Customer.OrderLineCart;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;

public class OrderLineCartViewStub implements OrderLineCartView {

    private int orderLineViewSet;
    private ArrayList<OrderLine> orderLines;



    public int getOrderLineViewSet() {
        return orderLineViewSet;
    }
    @Override
    public void setRecyclerView() {
        orderLineViewSet++;
    }
}
