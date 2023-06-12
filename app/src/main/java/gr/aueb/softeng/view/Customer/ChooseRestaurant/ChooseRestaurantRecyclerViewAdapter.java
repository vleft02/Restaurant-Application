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
    /**
     * Αρχικοποιεί την λίστα με τα διαθέσιμα εστιατόρια
     * Αρχικοποιεί το αντικείμενο Listener που θα χρησιμοποιηθεί όταν ο πελάτης πατήσει επάνω σε κάποια παραγγελία
     * @param restaurants τα διαθέσιμα εστιατόρια
     * @param listener το αντικείμενο item selection listener που θα χρησιμοποιήσουμε
     */
    public ChooseRestaurantRecyclerViewAdapter(ArrayList<Restaurant> restaurants, RestaurantSelectionListener listener){
        this.restaurants = restaurants;
        this.listener=listener;
    }
    /**
     * Περνάει στον adapter το layout που θέλουμε να εμφανιστούν τα αντικείμενα της λίστας μας - τα διεθέσιμα εστιατόρια στην περίπτωσή μας
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return νέο αντικείμενο view holder με το custom layout των εστιατορίων
     */
    @NonNull
    @Override
    public ChooseRestaurantRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChooseRestaurantRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_list_item , parent, false));
    }


    /*
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
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
    /**
     * Αρχικοποιεί τα Text Views που χρησιμοποιούμε στην παραπάνω μέθοδο
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView restName;
        public ViewHolder(View view)
        {
            super(view);
            restName = view.findViewById(R.id.RestaurantName);
        }
        /**
         * @return τα στοιχεία της παραγγελίας καλεστεί με System.out.print
         */
        @Override
        public String toString() {
            return super.toString() + " '" + restName.getText() + "'";
        }
    }
    /**
     *
     * @return επιστρέφει το μέγεθος της λίστας με τα εστιατόρια
     */
    @Override
    public int getItemCount() {
        return restaurants.size();
    }
    /**
     * καλεί την μέθοδο που θέλουμε όταν πατηθεί ένα εστιατόριο
     */
    public interface RestaurantSelectionListener
    {
        void selectRestaurant(Restaurant restaurant);
    }
}


