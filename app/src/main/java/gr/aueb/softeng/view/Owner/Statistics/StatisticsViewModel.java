package gr.aueb.softeng.view.Owner.Statistics;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;


public class StatisticsViewModel extends ViewModel {
   StatisticsPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου owner doa και restaurant dao για να χρησιμποιήσει
     */
    public StatisticsViewModel(){
        presenter = new StatisticsPresenter(new OwnerDAOmemory(),new RestaurantDAOmemory());
    }
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public StatisticsPresenter getPresenter()
    {
        return presenter;
    }

}
