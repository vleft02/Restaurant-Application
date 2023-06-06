package gr.aueb.softeng.view.Owner.HomePage;

import androidx.lifecycle.ViewModel;


import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;

public class OwnerHomePageViewModel extends ViewModel {

    private OwnerHomePagePresenter presenter;

    /**
     * Αρχικοποιεί τον presenter περνώντας του σαν παραμέτρους νέα daos που θα χρησιμοποιήσει
     */
    public OwnerHomePageViewModel(){
        presenter= new OwnerHomePagePresenter(new OwnerDAOmemory() , new RestaurantDAOmemory());
    }

    /**
     *
     * @return επιστρέφει τον presenter που έχουμε αποθηκεύσει τα δεδομένα
     */
    public OwnerHomePagePresenter getPresenter(){
        return this.presenter;
    }
}
