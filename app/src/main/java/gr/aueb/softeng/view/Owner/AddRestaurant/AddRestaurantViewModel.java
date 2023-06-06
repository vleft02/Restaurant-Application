package gr.aueb.softeng.view.Owner.AddRestaurant;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class AddRestaurantViewModel extends ViewModel {
    AddRestaurantPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου owner dao και restaurant dao για να χρησιμποιήσει
     */
    public AddRestaurantViewModel(){
        presenter = new AddRestaurantPresenter(new OwnerDAOmemory(), new RestaurantDAOmemory());
    }
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public AddRestaurantPresenter getPresenter(){
        return this.presenter;
    }

}
