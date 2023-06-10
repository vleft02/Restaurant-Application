package gr.aueb.softeng.view.Login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.softeng.memoryDao.MemoryInitializer;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Chef.HomePage.ChefHomePageActivity;
import gr.aueb.softeng.view.Customer.ChooseRestaurant.ChooseRestaurantActivity;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageActivity;
import gr.aueb.softeng.view.SignUp.SignUpCustomer.SignUpCustomerActivity;
import gr.aueb.softeng.view.SignUp.SignUpOwner.SignUpOwnerActivity;
import gr.aueb.softeng.view.SignUp.SignUpPersonel.SignUpPersonelActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο πελάτης συνδεθεί επιτυχώς τον λογαριασμό του
     * και κατευθύνεται στο Home Page ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    public void showCustomerFoundMessage(int id)
    {
        new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(true)
                .setTitle("Συγχαρητήρια")
                .setMessage("Τα στοιχεία που παραχωρήσατε είναι σωστα")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        redirectToCustomerPage(id);
                    }
                }).create().show();
    }
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο ιδιοκτήτης συνδεθεί επιτυχώς τον λογαριασμό του
     * και κατευθύνεται στο Home Page ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    public void showOwnerFoundMessage(int id)
    {
        new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(true)
                .setTitle("Συγχαρητήρια")
                .setMessage("Τα στοιχεία που παραχωρήσατε είναι σωστα")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        redirectToOwnerHomePage(id);
                    }
                }).create().show();
    }
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο μάγειρας συνδεθεί επιτυχώς τον λογαριασμό του
     * και κατευθύνεται στο Home Page ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    public void showChefFoundMessage(int id)
    {
        new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(true)
                .setTitle("Συγχαρητήρια")
                .setMessage("Τα στοιχεία που παραχωρήσατε είναι σωστα")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        redirectToChefHomePage(id);
                    }
                }).create().show();
    }
    private LoginViewModel viewModel;

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
        setContentView(R.layout.activity_login);

/*        //USED FOR DEBUGGING
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        //REMOVE LATER*/

        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null){
            Intent intent = getIntent();

        }

        findViewById(R.id.SignUpCustomerButton).setOnClickListener(new View.OnClickListener() { //το κουμπί όταν θέλει να εγγραφτεί νέος πελάτης στην εφαμοργή
            public void onClick(View v) {
                viewModel.getPresenter().onSignup();
            }
        });

        findViewById(R.id.SignUpPersonelButton).setOnClickListener(new View.OnClickListener() { // το κουμπί όταν θέλει να εγγραφτεί νέος μάγειρας στην εφαμοργή
            public void onClick(View v) {
                viewModel.getPresenter().onSignupPersonel();
            }
        });

        findViewById(R.id.SignUpOwnerButton).setOnClickListener(new View.OnClickListener() {// το κουμπί όταν θέλει να εγγραφτεί νέος ιδιοκτήτης στην εφαρμογή
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onSignupOwner();
            }
        });

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() { // το κουμπί σύνδεσης στην εφαρμογή
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().authenticate();

            }
        });
    }

    /**
     * Η μέθοδος αυτή λαμβάνει το όνομα που έχει πληκτρολογήσει ο χρήστης στο πεδίο Username
     * @return Επιστρέφει το string αυτο
     */

    public String ExtractUsername()
    {
      return ((EditText)findViewById(R.id.usernameText)).getText().toString().trim();

    }

    /**
     * Η μέθδος αυτή λαμβάνει τον κωδικό που έχει πληκτρολογήσει ο χρήστης στο πεδίο PassWord
     * @return Επιστρέφει το string αυτό
     */
    public String ExtractPassword()
    {
        return ((EditText)findViewById(R.id.passwordText)).getText().toString().trim();
    }

    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εγγραφής για πελάτη
     */
    public void signup(){
        Intent intent = new Intent(LoginActivity.this, SignUpCustomerActivity.class);
        startActivity(intent);
    }
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εγγραφής για μάγειρα
     */
    public void signupPersonel() {
        Intent intent = new Intent(LoginActivity.this, SignUpPersonelActivity.class);
        startActivity(intent);
    }
    /**
     * Η μέθοδος αυτή καλείται όταν πατηθεί το κουμπί εγγραφής για ιδιοκτήτη
     */
    public void signupOwner() {
        Intent intent = new Intent(LoginActivity.this, SignUpOwnerActivity.class);
        startActivity(intent);
    }

    /**
     * Η μέθοδος αυτή ανακατευθύνει τον χρήστη στην σελίδα πελατών εφόσον έχουν ταυτοποιηθεί σωστά τα στοιχεία του
     * επίσης περνάει σαν εξτρά πληροφορία στο intent το id του πελάτη
     * @param customerId το Id του πελάτη που πάτησε την σύνδεση
     */

    public void redirectToCustomerPage(int customerId){
        Intent intent = new Intent(LoginActivity.this, ChooseRestaurantActivity.class);
        intent.putExtra("CustomerId",customerId);
        startActivity(intent);
    }
    /**
     * Η μέθοδος αυτή ανακατευθύνει τον χρήστη στην σελίδα μάγειρων εφόσον έχουν ταυτοποιηθεί σωστά τα στοιχεία του
     * επίσης περνάει σαν εξτρά πληροφορία στο intent το id του μάγειρα
     * @param chefId το Id του μάγειρα που πάτησε την σύνδεση
     */
    public void redirectToChefHomePage(int chefId){
            Intent intent = new Intent(LoginActivity.this, ChefHomePageActivity.class);
            intent.putExtra("ChefId",chefId);
            startActivity(intent);
    }
    /**
     * Η μέθοδος αυτή ανακατευθύνει τον χρήστη στην σελίδα ιδιοκτητών εφόσον έχουν ταυτοποιηθεί σωστά τα στοιχεία του
     * επίσης περνάει σαν εξτρά πληροφορία στο intent το id του ιδιοκτήτη
     * @param ownerId το Id του ιδιοκτήτη που πάτησε την σύνδεση
     */
    public void redirectToOwnerHomePage(int ownerId){
        Intent intent = new Intent(LoginActivity.this, OwnerHomePageActivity.class);
        intent.putExtra("OwnerId",ownerId);
        startActivity(intent);
    }

}