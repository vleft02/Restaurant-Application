package gr.aueb.softeng.view.Owner.AddChef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;

/**
 * Η κλάση αυτή καλείται όταν επιλέγεται να προστεθεί ένας μάγειρας στο εστιατόριο
 */
public class AddChefActivity extends AppCompatActivity implements AddChefView {

    public int restId;
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(AddChefActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο ιδιοτήτης προσθέσει επιτυχώς τον μάγειρα
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    public void showChefAddedMessage()
    {
        new AlertDialog.Builder(AddChefActivity.this)
                .setCancelable(true)
                .setTitle("Επιτυχής προσθήκη του μάγειρα!")
                .setMessage("Τα στοιχεία που παραχωρήθηκαν επιβεβαιώθηκαν και ο μάγειρας \n προστέθηκε στο εστιατόριο με επιτυχία")
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
     * Πέρνουμε απο το activity που μας κάλεσε το id του εστιατορίου που θέλουμε να προσθέσουμε τον μάγειρα
     * Καλούμε τα activities όταν πατηθούν τα κουμπιά της οθόνης
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chef);

        AddChefViewModel viewModel = new ViewModelProvider(this).get(AddChefViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            restId = extras.getInt("RestaurantId");
        }
        viewModel.getPresenter().setRestaurant(restId);

        findViewById(R.id.confirmChefButton1).setOnClickListener(new View.OnClickListener(){ //Όταν πατηθεί το κουμπί επιβεβαίωσης προσθήκης μάγειρσ
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onAddChefAccount();
            }

        });
        findViewById(R.id.gobackButton7).setOnClickListener(new View.OnClickListener(){ // Όταν πατηθεί το κουμπί της επιστροφής
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });

    }
    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι username ή τηλέφωνο του μάγειρα
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο ιδιοκτήτης ψάχνοντας τον μάγειρα
     * με τα στοιχεία του
     * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
     */
    public HashMap<String,String> getChefDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.ChefNameText1)).getText().toString().trim()));
        details.put("surname",(((EditText)findViewById(R.id.ChefSurnameText1)).getText().toString().trim()));
        details.put("username",(((EditText)findViewById(R.id.ChefUsernameText1)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.ChefTelephoneText1)).getText().toString().trim()));
        details.put("iban",(((EditText)findViewById(R.id.ChefIbanText1)).getText().toString().trim()));
        details.put("tin",(((EditText)findViewById(R.id.ChefTinText1)).getText().toString().trim()));
        return details;
    }
    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    public void goBack(){
        finish();
    }
}