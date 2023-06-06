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
    /**
     * Αρχικοποιεί την λίστα με τα Order Lines της συγκεκριμένης παραγγελίας
     * @param orderLines η λίστα με τα order lines της παραγγελίας που έχει επιλέξει ο μάγειρας
     */
    public ChefOrderDetailsRecyclerViewAdapter(List<OrderLine> orderLines){
        this.orderLines = orderLines;
    }
    /**
     * Περνάει στον adapter το layout που θέλουμε να εμφανιστούν τα αντικείμενα της λίστας μας - τα order lines της παραγγελίας στην περίπτωσή μας
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return νέο αντικείμενο view holder με το custom layout των order lines
     */
    @NonNull
    @Override
    public ChefOrderDetailsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChefOrderDetailsRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderline_list_item, parent, false));
    }
    /**
     * Βάζει σε κάθε αντικείμενο order line το όνομα του πιάτου στο συγκεκριμένο Text View που έχουμε δημιουργήσει
     * και την ποσότητα του πιάτου στο άλλο Text View
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ChefOrderDetailsRecyclerViewAdapter.ViewHolder holder, int position) {
        final OrderLine currentItem = orderLines.get(position);
        holder.DishName.setText(String.valueOf(currentItem.getDish().getDishName()));
        holder.DishQuantity.setText("Quantity:"+String.valueOf(currentItem.getQuantity()));

    }
    /**
     * Αρχικοποιεί τa Text Views που χρησιμοποιούμε στην παραπάνω μέθοδο
     */
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
        /**
         *
         * @return επιστρέφει το όνομα και την ποσότητα του πιάτου αν καλεστεί με System.out.print
         */
        @Override
        public String toString() {
            return super.toString() + " '" + DishName.getText() + "'"+ DishQuantity.getText();
        }
    }

    /**
     * Επιστρέφει το μέγεθος της λίστας με τα order Lines
     * @return το size της λίστας order lines
     */
    @Override
    public int getItemCount() {
        return orderLines.size();
    }
}
