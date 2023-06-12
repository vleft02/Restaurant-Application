package gr.aueb.softeng.view.Customer.ChooseRestaurant;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.RestaurantDAOmemory;


public class ChooseRestaurantViewModel extends ViewModel {
    ChooseRestaurantPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter περνώντας του σαν παραμέτρους νέα daos που θα χρησιμοποιήσει
     */
    public ChooseRestaurantViewModel()
    {
        presenter = new ChooseRestaurantPresenter(new RestaurantDAOmemory());
    }
    /**
     *
     * @return επιστρέφει τον presenter που έχουμε αποθηκεύσει τα δεδομένα
     */
    public ChooseRestaurantPresenter getPresenter() {
        return presenter;
    }
}
