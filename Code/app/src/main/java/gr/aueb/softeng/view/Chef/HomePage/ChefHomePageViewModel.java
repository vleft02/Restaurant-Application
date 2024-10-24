package gr.aueb.softeng.view.Chef.HomePage;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;


public class ChefHomePageViewModel extends ViewModel {
    private ChefHomePagePresenter presenter;
    /**
     * Αρχικοποιεί τον presenter περνώντας του σαν παραμέτρους νέα daos που θα χρησιμοποιήσει
     */
    public ChefHomePageViewModel(){
        presenter= new ChefHomePagePresenter(new ChefDAOmemory(), new OrderDAOmemory());
    }
    /**
     *
     * @return επιστρέφει τον presenter που έχουμε αποθηκεύσει τα δεδομένα
     */
    public ChefHomePagePresenter getPresenter(){
        return this.presenter;
    }
}
