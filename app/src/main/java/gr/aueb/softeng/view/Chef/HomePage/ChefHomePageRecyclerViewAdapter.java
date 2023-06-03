package gr.aueb.softeng.view.Chef.HomePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.team08.R;

public class ChefHomePageRecyclerViewAdapter extends RecyclerView.Adapter<ChefHomePageRecyclerViewAdapter.ViewHolder>{
    private final List<Order> orders;
    private final ChefHomePageRecyclerViewAdapter.ItemSelectionListener listener;

    public ChefHomePageRecyclerViewAdapter(List<Order> orders , ChefHomePageRecyclerViewAdapter.ItemSelectionListener listener){
        this.orders = orders;
        this.listener=listener;
    }
    @NonNull
    @Override
    public ChefHomePageRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChefHomePageRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_item2 , parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChefHomePageRecyclerViewAdapter.ViewHolder holder, int position) {
        final Order currentItem = orders.get(position);//////////////////
        holder.OrderId.setText("Id:"+String.valueOf(currentItem.getId()));
        holder.OrderState.setText("State:"+String.valueOf(currentItem.getOrderState()));
        holder.OrderId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.selectOrder(currentItem);
            }
        });

        holder.OrderState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.selectOrder(currentItem);
            }
        });
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView OrderId;
        public final TextView OrderState;
        public ViewHolder(View view)
        {
            super(view);
            OrderId = view.findViewById(R.id.DishNameTextView);
            OrderState = view.findViewById(R.id.DishQuantityTextView);

        }
        @Override
        public String toString() {
            return super.toString() + " '" + OrderId.getText() + "'"+ OrderState.getText();
        }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
    public interface ItemSelectionListener
    {
        void selectOrder(Order order);
    }
}
