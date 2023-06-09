package gr.aueb.softeng.view.Customer.TopUp;

import gr.aueb.softeng.view.View;

public interface TopUpView extends View {


    /**
     * Σετάρουμε το textView να δείχνει το απαραίτητο χρηματικό υπόλοιπο
     */
    void setBalance(String balance);

    int getCustomerId();
}
