package gr.aueb.softeng.view.Customer.ChooseRestaurant;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;
        import java.util.List;

        import gr.aueb.softeng.domain.Restaurant;
        import gr.aueb.softeng.team08.R;

public class ChooseRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<ChooseRestaurantRecyclerViewAdapter.ViewHolder>{
    private final List<Restaurant> restaurants;
    private final ChooseRestaurantRecyclerViewAdapter.RestaurantSelectionListener listener;

    public ChooseRestaurantRecyclerViewAdapter(ArrayList<Restaurant> restaurants, RestaurantSelectionListener listener){
        this.restaurants = restaurants;
        this.listener=listener;
    }
    @NonNull
    @Override
    public ChooseRestaurantRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChooseRestaurantRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_list_item , parent, false));
    }



    @Override
    public void onBindViewHolder(@NonNull ChooseRestaurantRecyclerViewAdapter.ViewHolder holder, int position) {
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
    public interface RestaurantSelectionListener
    {
        void selectRestaurant(Restaurant restaurant);
    }
}


