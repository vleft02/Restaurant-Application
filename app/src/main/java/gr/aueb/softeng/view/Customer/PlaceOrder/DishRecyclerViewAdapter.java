package gr.aueb.softeng.view.Customer.PlaceOrder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import gr.aueb.softeng.domain.Dish;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Customer.HomePage.OrderHistoryRecyclerViewAdapter;
import gr.aueb.softeng.view.Customer.HomePage.OrderSelectionListener;

public class DishRecyclerViewAdapter extends RecyclerView.Adapter<DishRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<Dish> dishes;
    private final DishSelectionListener listener;

    public DishRecyclerViewAdapter(ArrayList<Dish> dishes,DishSelectionListener listener)
    {
        this.dishes = dishes;
        this.listener = listener;
    }


    @NonNull
    @Override
    public DishRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DishRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dish_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DishRecyclerViewAdapter.ViewHolder holder, int position) {
        final Dish currentDish = dishes.get(position);
        holder.dishName.setText(String.valueOf(currentDish.getDishName()));
        holder.dishPrice.setText(String.format("%.2f",currentDish.getDishWorth())+" €"); ///MPOREI NA DHMIOURGEI THMEA
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.selectDish(currentDish);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView dishName;
        public final TextView dishPrice;
        public final Button addButton;

        public ViewHolder(View v)
        {
            super(v);
            dishName = v.findViewById(R.id.dishName);
            dishPrice = v.findViewById(R.id.dishPrice);
            addButton = v.findViewById(R.id.AddOrderLineButton);

        }
        @Override
        public String toString() {
            return super.toString()+" "+dishName.getText()+" "+dishPrice.getText()+ " "+addButton.getText();
        }
    }
}
