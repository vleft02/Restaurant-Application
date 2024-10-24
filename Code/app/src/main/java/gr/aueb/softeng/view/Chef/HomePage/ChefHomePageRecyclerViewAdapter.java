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
    /**
     * Αρχικοποιεί την λίστα με τις παραγγελίες του μάγειρα που έχει κάνει το log in
     * Αρχικοποιεί το αντικείμενο Listener που θα χρησιμοποιηθεί όταν ο μάγειρας πατήσει επάνω σε κάποια παραγγελία
     * @param orders οι παραγγελίες του μάγειρα
     * @param listener το αντικείμενο item selection listener που θα χρησιμοποιήσουμε
     */
    public ChefHomePageRecyclerViewAdapter(List<Order> orders , ChefHomePageRecyclerViewAdapter.ItemSelectionListener listener){
        this.orders = orders;
        this.listener=listener;
    }
    /**
     * Περνάει στον adapter το layout που θέλουμε να εμφανιστούν τα αντικείμενα της λίστας μας - οι παραγγελίες του μάγειρα στην περίπτωσή μας
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return νέο αντικείμενο view holder με το custom layout των παραγγελιών
     */
    @NonNull
    @Override
    public ChefHomePageRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChefHomePageRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_item2 , parent, false));
    }
    /**
     * Βάζει σε κάθε αντικείμενο παραγγελίας το id της παραγγελίας στο συγκεκριμένο Text View που έχουμε δημιουργήσει
     * και την κατάστασή της
     * δημιουργεί το On Click Listener το οποίο ενεργοποιείται όταν πατηθεί κάποια συγκεκριμένη παραγγελία
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
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
     /**
     * Αρχικοποιεί τα Text Views που χρησιμοποιούμε στην παραπάνω μέθοδο
     */
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
        /**
         * @return επιστρέφει το id και την κατάσταση της παραγγελίας αν καλεστεί με System.out.print
         */
        @Override
        public String toString() {
            return super.toString() + " '" + OrderId.getText() + "'"+ OrderState.getText();
        }
    }
    /**
     *
     * @return επιστρέφει το μέγεθος της λίστας με τις παραγγελίες
     */
    @Override
    public int getItemCount() {
        return orders.size();
    }
    /**
     * καλεί την μέθοδο που θέλουμε όταν πατηθεί μία παραγγελία
     */
    public interface ItemSelectionListener
    {
        void selectOrder(Order order);
    }
}
