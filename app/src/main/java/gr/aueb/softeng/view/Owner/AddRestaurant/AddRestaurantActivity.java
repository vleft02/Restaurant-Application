package gr.aueb.softeng.view.Owner.AddRestaurant;

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
 * Η κλάση αυτή καλείται όταν ο ιδιοκτήτης επιλέγει να προσθέσει ένα νέο εστιατόριο
 */
public class AddRestaurantActivity extends AppCompatActivity implements AddRestaurantView {
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(AddRestaurantActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    /**
     * Εμφανίζει μήνυμα επιτυχίας όταν ο ιδιοτήτης προσθέσει επιτυχώς το νέο εστιατόριό του
     * και επιστρέφει στο προηγούμενο ακτίβιτι όταν πατηθεί το κουμπί ΟΚ
     */
    public void showRestaurantAddedMessage()
    {
        new AlertDialog.Builder(AddRestaurantActivity.this)
                .setCancelable(true)
                .setTitle("Επιτυχής προσθήκη εστιατορίου")
                .setMessage("Το εστιατόριο προστέθηκε με επιτυχία στην λίστα του ιδιοκτήτη!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).create().show();
    }

    private static boolean initialized = false;
    private int ownerId;
    /**
     * Δημιουργεί το layout και αρχικοποιεί το activity
     * Αρχικοποιούμε το view Model και περνάμε στον presenter το view
     * Πέρνουμε απο το activity που μας κάλεσε το id του ιδιοκτήτη που θέλουμε να προσθέσουμε στο εστιατόριο
     * Καλούμε τα acitvities όταν πατηθούν τα κουμπιά της οθόνης
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        AddRestaurantViewModel viewModel = new ViewModelProvider(this).get(AddRestaurantViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            ownerId = extras.getInt("OwnerId");
        }
        viewModel.getPresenter().setOwner(ownerId);

        findViewById(R.id.CreateRestaurantButton).setOnClickListener(new View.OnClickListener(){ // Όταν πατηθεί το κουμπί δημιουργίας του εστιατορίου
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onCreateRestaurant();
            }

        });
        findViewById(R.id.gobackButton8).setOnClickListener(new View.OnClickListener(){ // Όταν πατηθεί το κουμπί επιστροφής στην προηγούμενη σελίδα
            @Override
            public void onClick(View v){
                viewModel.getPresenter().onBack();
            }
        });
    }

    /**
     * Δημιουργεί ένα hash map στο οποίο έχουμε σαν κλειδί την περιγραφή πχ άν είναι name ή τηλέφωνο του εστιατορίου
     * και σαν value έχουμε την τιμή του κλειδιού την οποία παίρνουμε απο την οθόνη που έχει περάσει ο ιδιοκτήτης
     * τα στοιχεία του εστιατορίου που θέλει να προσθέσει
     * @return Επιστρέφουμε το Hash Map αυτό με τα δεδομένα της οθόνης
     */
    public HashMap<String,String> getRestDetails(){
        HashMap<String,String> details = new HashMap<>();
        details.put("name",(((EditText)findViewById(R.id.RestaurantNameText)).getText().toString().trim()));
        details.put("telephone",(((EditText)findViewById(R.id.RestaurantTelephoneText)).getText().toString().trim()));
        details.put("streetName",(((EditText)findViewById(R.id.StreetNameText)).getText().toString().trim()));
        details.put("streetNumber",(((EditText)findViewById(R.id.StreetNumberText)).getText().toString().trim()));
        details.put("zc",(((EditText)findViewById(R.id.ZcText)).getText().toString().trim()));
        details.put("city",(((EditText)findViewById(R.id.CityText)).getText().toString().trim()));
        details.put("total_tables",(((EditText)findViewById(R.id.TotalTablesText)).getText().toString().trim()));
        return details;
    }
    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    public void goBack(){
        finish();
    }
}