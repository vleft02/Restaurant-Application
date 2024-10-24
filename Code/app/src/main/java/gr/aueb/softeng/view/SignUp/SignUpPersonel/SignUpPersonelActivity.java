package gr.aueb.softeng.view.SignUp.SignUpPersonel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;


import gr.aueb.softeng.team08.R;

/**
 *Η κλάση αυτή καλείται όταν πηγαίνει να προστεθεί νέος μάγειρας στην εφαρμογή
 */
public class SignUpPersonelActivity extends AppCompatActivity implements SignUpPersonelView {
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(SignUpPersonelActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο μάγειρας δημιουργήσει επιτυχώς τον λογαριασμό του
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    @Override
    public void showAccountCreatedMessage()
    {
        new AlertDialog.Builder(SignUpPersonelActivity.this)
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_sign_up_personel);

        SignUpPersonelViewModel viewModel = new ViewModelProvider(this).get(SignUpPersonelViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
        }
        findViewById(R.id.createAccButton).setOnClickListener(new View.OnClickListener(){ // το κουμπί δημιουργίας του account
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateChefAccount();
            }

        });
        findViewById(R.id.gobackButton3).setOnClickListener(new View.OnClickListener(){ // το κουμπί επιστροφής στην προηγόυμενη οθόνη
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });
    }
    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι username ή τηλέφωνο του μάγειρα
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο μάγειρας τα στοιχεία εγγραφής του
     * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
     */
    public HashMap<String,String> getChefDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.ChefNameText)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.ChefSurnameText)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.ChefUsernameText)).getText().toString().trim()));
        details.put("email",(((EditText)findViewById(R.id.ChefEmailText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.ChefTelephoneText)).getText().toString().trim()));
        details.put("iban",(((EditText)findViewById(R.id.ChefIbanText)).getText().toString().trim()));
        details.put("tin",(((EditText)findViewById(R.id.ChefTinText)).getText().toString().trim()));
        details.put("password",(((EditText)findViewById(R.id.ChefPasswordText)).getText().toString().trim()));
        return details;
    }
    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    public void goBack(){
        finish();
    }




}