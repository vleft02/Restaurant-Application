package gr.aueb.softeng.view.Owner.RestaurantDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;



import gr.aueb.softeng.team08.R;

import gr.aueb.softeng.view.Owner.AddChef.AddChefActivity;
import gr.aueb.softeng.view.Owner.Statistics.StatisticsActivity;

/**
 * Η κλάση αυτή καλείται όταν πατιέται κάποιο εστιατόριο απο τον ιδιοκτήτη για να εμφανιστούν τα στοιχεία του
 */
public class RestaurantDetailsActivity extends AppCompatActivity implements RestaurantDetailsView {
    public int RestaurantId;
    RestaurantDetailsViewModel viewModel;

    /**
     * Εμφανίζει το όνομα του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param name το όνομα που θα εμφανιστεί
     */
    public void setRestName(String name){
        ((TextView)findViewById(R.id.RestaurantNameDetailText)).setText(name);
    }

    /**
     * εμφανίζει το id του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param id το id που θα εμφανιστεί
     */
    public void setRestId(String id){
        ((TextView)findViewById(R.id.RestaurantIdDetailText)).setText(id);
    }

    /**
     * Εμφανίζει τον αριθμό των τραπεζιών του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param tables ο αριθμός των τραπεζιών σε μορφή String
     */
    public void setRestTables(String tables){
        ((TextView)findViewById(R.id.RestaurantTablesDetailText)).setText(tables);
    }

    /**
     * Εμφανίζει το όνομα της οδού του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param street η οδός που θα εμφανιστεί
     */
    public void setRestAddressStreet(String street){
        ((TextView)findViewById(R.id.RestaurantAddressStreetText)).setText(street);
    }

    /**
     * Εμφανίζει τον αριθμό της οδού του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param num ο αριθμός που θα εμφανιστεί
     */
    public void setRestAddressNumber(String num){
        ((TextView)findViewById(R.id.RestaurantAddressNumberText)).setText(num);
    }

    /**
     * Εμφανίζει τον ταχυδρομικό κώδικα  του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param zip ο ταχυδρομικός κώδικας που θέλουμε να εμφανιστεί
     */
    public void setRestZip(String zip){
        ((TextView)findViewById(R.id.RestaurantAddressZCText)).setText(zip);
    }

    /**
     * Εμφανίζει την πόλη του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param city η πόλη που θέλουμε να εμφανιστεί
     */
    public void setRestAddressCity(String city){
        ((TextView)findViewById(R.id.RestaurantCityText)).setText(city);
    }

    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(RestaurantDetailsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    private static boolean initialized = false;

    /**
     *Δημιουργεί to layout και αρχικοποιεί
     *το activity.
     *Αρχικοποιούμε το view Model και περνάμε στον presenter το view
     *Πέρνουμε απο το activity που μας κάλεσε το id του εστιατορλιου που θέλουμε να εμφανίσουμε τα στοιχεία
     * Καλούμε τα acitvities όταν πατηθούν τα κουμπιά της οθόνης
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_restaurant_details);
        viewModel = new ViewModelProvider(this).get(RestaurantDetailsViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            RestaurantId = extras.getInt("RestaurantId");
        }
        viewModel.getPresenter().setRestaurant(RestaurantId);
        viewModel.getPresenter().setDetails();

        findViewById(R.id.ExtractStatsButton).setOnClickListener(new View.OnClickListener() {//Όταν πατηθεί το κουμπί εξαγωγής στατιστικών
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onExtractStats();
            }
        });
        findViewById(R.id.GoBack2).setOnClickListener(new View.OnClickListener(){ // Όταν πατηθεί το κουμπί επιστροφής στην αρχική σελίδα
            @Override
            public void onClick(View v){viewModel.getPresenter().OnBack();}
        });
        findViewById(R.id.addChefButton).setOnClickListener(new View.OnClickListener(){ //Όταν πατηθεί το κουμπί προσθήκης νέου μάγειρα στο εστιατόριο
            @Override
            public void onClick(View v){viewModel.getPresenter().onAddChef();}
        });
    }

    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    public void goBack(){
        finish();
    }

    /**
     * Καλείται όταν πατηθεί το κουμπι εξαγωγής στατιστικών και υπολογίζει τα στατιστικά του εστιατορίου
     */

    public void extractStats(){
        Intent intent = new Intent(RestaurantDetailsActivity.this, StatisticsActivity.class);
        intent.putExtra("RestaurantId",RestaurantId);
        startActivity(intent);
    }

    /**
     * Καλείται όταν πατηθεί το κουμπί της εισαγωγής νέου μάγειρα στο εστιατόριο και περνάει το id του εστιατορίου
     */
    public void addChef(){
        Intent intent = new Intent(RestaurantDetailsActivity.this, AddChefActivity.class);
        intent.putExtra("RestaurantId",RestaurantId);
        startActivity(intent);
    }
}