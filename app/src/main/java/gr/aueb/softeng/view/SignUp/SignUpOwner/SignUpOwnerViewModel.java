package gr.aueb.softeng.view.SignUp.SignUpOwner;

import androidx.lifecycle.ViewModel;


import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;


public class SignUpOwnerViewModel extends ViewModel {
    SignUpOwnerPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου user dao memory  και owner dao memory  για να χρησιμποιήσει
     */
    public SignUpOwnerViewModel() {
        presenter = new SignUpOwnerPresenter(new UserDAOmemory(), new OwnerDAOmemory());
    }
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public SignUpOwnerPresenter getPresenter() {
        return presenter;
    }
}
