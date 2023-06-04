package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.aueb.softeng.domain.OrderLine;
import gr.aueb.softeng.team08.R;


public class ChefOrderDetailsRecyclerViewAdapter extends RecyclerView.Adapter<ChefOrderDetailsRecyclerViewAdapter.ViewHolder> {
    private final List<OrderLine> orderLines;
    public ChefOrderDetailsRecyclerViewAdapter(List<OrderLine> orderLines){
        this.orderLines = orderLines;
    }
    @NonNull
    @Override
    public ChefOrderDetailsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChefOrderDetailsRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderline_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChefOrderDetailsRecyclerViewAdapter.ViewHolder holder, int position) {
        final OrderLine currentItem = orderLines.get(position);
        holder.DishName.setText(String.valueOf(currentItem.getDish().getDishName()));
        holder.DishQuantity.setText("Quantity:"+String.valueOf(currentItem.getQuantity()));

    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView DishName;
        public final TextView DishQuantity;
        public ViewHolder(View view)
        {
            super(view);
            DishName = view.findViewById(R.id.DishNameTextView);
            DishQuantity = view.findViewById(R.id.DishQuantityTextView);

        }
        @Override
        public String toString() {
            return super.toString() + " '" + DishName.getText() + "'"+ DishQuantity.getText();
        }
    }

    @Override
    public int getItemCount() {
        return orderLines.size();
    }
}
