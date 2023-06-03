package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import android.widget.TextView;

import gr.aueb.softeng.team08.R;

public interface ChefOrderDetailsView {
    void setOrderId(String orderId);
    void setOrderState(String state);
    void setTableNumber(String num);
    /*public void setDate(){ NA DW TI KANV EDWWWWWWWWWW

    }*/
    void goBack();
}
