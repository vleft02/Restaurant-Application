package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import java.util.HashMap;


import gr.aueb.softeng.team08.R;

/**
 * Η κλάση αυτή καλείται όταν πατηθεί να προστεθεί νέος πελάτης στο σύστημα
 */
public class SignUpCustomerActivity extends AppCompatActivity implements SignUpCustomerView {
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(SignUpCustomerActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο πελάτης δημιουργήσει επιτυχώς τον λογαριασμό του
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    public void showAccountCreatedMessage()
    {
        new AlertDialog.Builder(SignUpCustomerActivity.this)
                .setCancelable(true)
                .setTitle("Επιτυχής δημιουργία λογαριασμού")
                .setMessage("Ο λαγαριασμος δημιουργήθηκε με επιτυχία")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).create().show();
    }
    private static boolean initialized = false;
    /**
     * Δημιουργει το layout και αρχικοποιεί το activity
     * Αρχικοποιούμε το view Model και περνάμε στον presenter το view
     * Καλούμε τα activities όταν πατηθούν τα κουμπιά της οθόνης
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUpCustomerViewModel viewModel = new ViewModelProvider(this).get(SignUpCustomerViewModel.class);
        viewModel.getPresenter().setView(this);
        findViewById(R.id.CreateAccButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateAccount();//μέθοδος που καλείται όταν είναι να δημιουργηθεί το account του χρήστη
            }

        });
        findViewById(R.id.gobackButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            } // μέθοδος επιστροφής στην προηγούμενη οθόνη
        });
    }
    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι username ή τηλέφωνο του πελάτη
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο πελάτης τα στοιχεία εγγραφής του
     * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
     */
    public HashMap<String,String> getDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.CustomerNameText)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.CustomerSurnameText)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.CustomerUsernameText)).getText().toString().trim()));
        details.put("email",(((EditText)findViewById(R.id.CustomerEmailText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.CustomerTelephoneText)).getText().toString().trim()));
        details.put("cardNumber",(((EditText)findViewById(R.id.CardNumberText)).getText().toString().trim()));
        details.put("cardHolderName",(((EditText)findViewById(R.id.CardHolderNameText)).getText().toString().trim()));
        details.put("cvv",(((EditText)findViewById(R.id.CVVText)).getText().toString().trim()));
        details.put("password",(((EditText)findViewById(R.id.CustomerPasswordText)).getText().toString().trim()));
        return details;
    }

    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    public void goBack(){
        finish();
    }


}