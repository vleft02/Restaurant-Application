package gr.aueb.softeng.view.Owner.HomePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.aueb.softeng.domain.Restaurant;
import gr.aueb.softeng.team08.R;

public class OwnerHomePageRecyclerViewAdapter extends RecyclerView.Adapter<OwnerHomePageRecyclerViewAdapter.ViewHolder>{
    private final List<Restaurant> restaurants;
    private final ItemSelectionListener listener;

    public OwnerHomePageRecyclerViewAdapter(List<Restaurant> restaurants, ItemSelectionListener listener){
        this.restaurants = restaurants;
        this.listener=listener;
    }
    @NonNull
    @Override
    public OwnerHomePageRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_list_item , parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerHomePageRecyclerViewAdapter.ViewHolder holder, int position) {
        final Restaurant currentItem = restaurants.get(position);
            holder.restName.setText(String.valueOf(currentItem.getRestaurantName()));
            holder.restName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.selectRestaurant(currentItem);
                }
            });
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView restName;
        public ViewHolder(View view)
        {
            super(view);
            restName = view.findViewById(R.id.RestaurantName);
        }
        @Override
        public String toString() {
            return super.toString() + " '" + restName.getText() + "'";
        }
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
    public interface ItemSelectionListener
    {
        void selectRestaurant(Restaurant restaurant);
    }
}


