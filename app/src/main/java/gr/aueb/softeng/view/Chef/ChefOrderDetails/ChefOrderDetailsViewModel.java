package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;


public class ChefOrderDetailsViewModel extends ViewModel {
    private ChefOrderDetailsPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter περνώντας του σαν παραμέτρους νέα daos που θα χρησιμοποιήσει
     */
    public ChefOrderDetailsViewModel(){
        presenter= new ChefOrderDetailsPresenter(new ChefDAOmemory(), new OrderDAOmemory());
    }
    /**
     *
     * @return επιστρέφει τον presenter που έχουμε αποθηκεύσει τα δεδομένα
     */
    public ChefOrderDetailsPresenter getPresenter(){
        return this.presenter;
    }
}
