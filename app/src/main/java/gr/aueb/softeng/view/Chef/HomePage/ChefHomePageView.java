package gr.aueb.softeng.view.Chef.HomePage;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

public interface ChefHomePageView {
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     */
    void goBack();
     void ShowNoOrders();

     void ShowOrders();
}
