package gr.aueb.softeng.view.Customer.OrderLineCart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.team08.R;

public class OrderLineCartRecyclerViewAdapter extends RecyclerView.Adapter<OrderLineCartRecyclerViewAdapter.ViewHolder> {
private final ArrayList<OrderLine> orderLines;
private final OrderLineSelectionListener listener;

    public OrderLineCartRecyclerViewAdapter(ArrayList<OrderLine> orderLine,OrderLineSelectionListener listener) {
        this.orderLines = orderLine;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrderLineCartRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderLineCartRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.orderline_list_item_cart, parent, false));
        }

@Override
public void onBindViewHolder(@NonNull OrderLineCartRecyclerViewAdapter.ViewHolder holder, int position) {
final OrderLine currentItem = orderLines.get(position);
        holder.DishName.setText(String.valueOf(currentItem.getDish().getDishName()));
        holder.DishQuantity.setText("Quantity:"+String.valueOf(currentItem.getQuantity()));

        holder.DeleteOrderLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.deleteOrderLine(currentItem);
            }
        });

        }
public class ViewHolder extends RecyclerView.ViewHolder
{
    public final TextView DishName;
    public final TextView DishQuantity;

    public final ImageButton DeleteOrderLine;
    public ViewHolder(View view)
    {
        super(view);
        DishName = view.findViewById(R.id.OrderLineCartTextView);
        DishQuantity = view.findViewById(R.id.OrderLineCartQuantityTextView);
        DeleteOrderLine = view.findViewById(R.id.DeleteOrdeLine);

    }
    @Override
    public String toString() {
        return super.toString() + " '" + DishName.getText() + "'"+ DishQuantity.getText();
    }
}

    @Override
    public int getItemCount() {
        if (orderLines != null)
        {
            return orderLines.size();
        }
        return 0;
    }
}
