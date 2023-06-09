package gr.aueb.softeng.view.SignUp.SignUpPersonel;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class SignUpPersonelViewModel extends ViewModel {
    SignUpPersonelPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου user dao memory  και chef dao memory  για να χρησιμποιήσει
     */
    public SignUpPersonelViewModel() {
        presenter = new SignUpPersonelPresenter(new UserDAOmemory(), new ChefDAOmemory());

    }
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public SignUpPersonelPresenter getPresenter() {
        return presenter;
    }

}
