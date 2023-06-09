package gr.aueb.softeng.view.Chef.OrderDetails;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;


public class OrderDetailsViewModel extends ViewModel {
    private OrderDetailsPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter περνώντας του σαν παραμέτρους νέα daos που θα χρησιμοποιήσει
     */
    public OrderDetailsViewModel(){
        presenter= new OrderDetailsPresenter(new ChefDAOmemory(), new OrderDAOmemory());
    }
    /**
     *
     * @return επιστρέφει τον presenter που έχουμε αποθηκεύσει τα δεδομένα
     */
    public OrderDetailsPresenter getPresenter(){
        return this.presenter;
    }
}
