package gr.aueb.softeng.view.Customer.HomePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.team08.R;

public class OrderHistoryRecyclerViewAdapter extends RecyclerView.Adapter<OrderHistoryRecyclerViewAdapter.ViewHolder> {

    private final List<Order> orders;
    private final OrderSelectionListener listener;

    public OrderHistoryRecyclerViewAdapter(List<Order> orders, OrderSelectionListener listener) {
        this.orders = orders;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrderHistoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                                                 parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryRecyclerViewAdapter.ViewHolder holder,
                                 int position) {

        final Order currentItem = orders.get(position);
        holder.orderDate.setText(String.valueOf(currentItem.getDate()));
        holder.orderState.setText(currentItem.getOrderState().toString());
        holder.orderDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.selectOrder(currentItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView orderDate;
        public final TextView orderState;

        public ViewHolder(View view) {
            super(view);
            orderDate = view.findViewById(R.id.OrderDateTextView);
            orderState = view.findViewById(R.id.OrderStateTextView);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}

