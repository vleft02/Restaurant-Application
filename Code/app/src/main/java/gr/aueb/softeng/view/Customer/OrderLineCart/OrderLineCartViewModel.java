package gr.aueb.softeng.view.Customer.OrderLineCart;

import androidx.lifecycle.ViewModel;

public class OrderLineCartViewModel extends ViewModel {
    OrderLineCartPresenter presenter;
    public OrderLineCartViewModel(){
        presenter = new OrderLineCartPresenter();
    }

    public OrderLineCartPresenter getPresenter() {
        return presenter;
    }
}
