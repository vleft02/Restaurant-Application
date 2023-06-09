package gr.aueb.softeng.view.Chef.HomePage;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

public interface ChefHomePageView {
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     */
    void goBack();
    /**
     * Η μέθοδος αυτή καλείται όταν η λίστα των παραγγελιών του μάγειρα είναι άδεια , ώστε να εμφανιστεί το μήνυμα
     * στην οθόνη ότι η λίστα είναι άδεια.
     */
     void ShowNoOrders();
    /**
     * Η μέθοδος αυτή καλείται όταν η λίστα με τις παραγγελίες ΔΕΝ είναι άδεια και εμφανίζεται στην οθόνη το recycler view με τα αντικείμενα του.
     * σετάροντας παράλληλα τον adapter και το layout manager του recycler view
     */
     void ShowOrders();
}
