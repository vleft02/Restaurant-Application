package gr.aueb.softeng.view.Login;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OwnerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class LoginViewModel extends ViewModel{

    private LoginPresenter loginPresenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου user dao memory, restaurant dao memory ,user dao memory
     * , owner dao memory για να χρησιμποιήσει
     */
    public LoginViewModel()
    {
        loginPresenter = new LoginPresenter(new ChefDAOmemory(), new CustomerDAOmemory(), new OwnerDAOmemory(),new UserDAOmemory());
    }
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public LoginPresenter getPresenter() {
        return loginPresenter;
    }

}
