package gr.aueb.softeng.view.Owner.RestaurantDetails;

import android.util.Log;

import androidx.lifecycle.ViewModel;


import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;


public class RestaurantDetailsViewModel extends ViewModel {
    RestaurantDetailsPresenter presenter;

    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου restaurant dao για να χρησιμποιήσει
     */
    public RestaurantDetailsViewModel(){
        presenter = new RestaurantDetailsPresenter(new RestaurantDAOmemory());
    }

    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public RestaurantDetailsPresenter getPresenter()
    {
        return presenter;
    }

}
