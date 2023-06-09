package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import androidx.lifecycle.ViewModel;


import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.UserDAOmemory;

public class SignUpCustomerViewModel extends ViewModel {
SignUpCustomerPresenter presenter;
    /**
     * Αρχικοποιεί τον presenter και του περνάει ένα νέο αντικείμενο τύπου user dao memory  και restaurant dao memory  για να χρησιμποιήσει
     */
public SignUpCustomerViewModel()
{
    presenter = new SignUpCustomerPresenter(new UserDAOmemory(), new CustomerDAOmemory());

}
    /**
     * Επιστρέφει τον presenter στις κλάσεις όπου περιέχει τις πληροφορίες
     * @return το instance του presenter που δημιουργήσαμε παραπάνω
     */
    public SignUpCustomerPresenter getPresenter()
    {
        return presenter;
    }
}
