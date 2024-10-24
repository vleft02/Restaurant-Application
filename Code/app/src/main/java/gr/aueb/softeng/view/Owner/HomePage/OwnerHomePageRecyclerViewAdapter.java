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

    /**
     * Αρχικοποιεί την λίστα με τα εστιατόρια του ιδιοκτήτή που έχει κάνει το log in
     * Αρχικοποιεί το αντικείμενο Listener που θα χρησιμοποιηθεί όταν ο χρήστης πατήσει επάνω σε κάποιο εστιατόριο
     * @param restaurants τα εστιατόρια του ιδιοκτήτη
     * @param listener το αντικείμενο item selection listener που θα χρησιμοποιήσουμε
     */
    public OwnerHomePageRecyclerViewAdapter(List<Restaurant> restaurants, ItemSelectionListener listener){
        this.restaurants = restaurants;
        this.listener=listener;
    }

    /**
     * Περνάει στον adapter το layout που θέλουμε να εμφανιστούν τα αντικείμενα της λίστας μας - τα εστιατόρια του ιδιοκτήτη στην περίπτωσή μας
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return νέο αντικείμενο view holder με το custom layout των εστιατορίων
     */
    @NonNull
    @Override
    public OwnerHomePageRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_list_item , parent, false));
    }

    /**
     * Βάζει σε κάθε αντικείμενο εστιατορίου το όνομα του εστιατορίου στο συγκεκριμένο Text View που έχουμε δημιουργήσει
     * δημιουργεί το On Click Listener το οποίο ενεργοποιείται όταν πατηθεί κάποιο συγκεκριμένο εστιατόριο
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull OwnerHomePageRecyclerViewAdapter.ViewHolder holder, int position) {
        final Restaurant currentItem = restaurants.get(position);
            holder.restName.setText("Name:"+String.valueOf(currentItem.getRestaurantName()));
            holder.restName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.selectRestaurant(currentItem);
                }
            });
    }

    /**
     * Αρχικοποιεί το Text View που χρησιμοποιούμε στην παραπάνω μέθοδο
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
         * @return επιστρέφει το όνομα του εστιατορίου αν καλεστεί με System.out.print
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
    public interface ItemSelectionListener
    {
        void selectRestaurant(Restaurant restaurant);
    }
}


