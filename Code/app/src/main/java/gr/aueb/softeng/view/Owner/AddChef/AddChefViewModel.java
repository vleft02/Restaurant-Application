package gr.aueb.softeng.view.Owner.AddChef;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class AddChefViewModel extends ViewModel {
    AddChefPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου chef dao και restaurant dao για να χρησιμποιήσει
     */
    public AddChefViewModel() {
        presenter = new AddChefPresenter(new RestaurantDAOmemory(), new ChefDAOmemory());

    }
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public AddChefPresenter getPresenter() {
        return presenter;
    }
}
