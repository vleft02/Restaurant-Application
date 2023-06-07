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
import gr.aueb.softeng.view.Customer.HomePage.CustomerHomePageActivity;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageActivity;
import gr.aueb.softeng.view.SignUp.SignUpCustomer.SignUpCustomerActivity;
import gr.aueb.softeng.view.SignUp.SignUpOwner.SignUpOwnerActivity;
import gr.aueb.softeng.view.SignUp.SignUpPersonel.SignUpPersonelActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //USED FOR DEBUGGING
        MemoryInitializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        //REMOVE LATER

        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getPresenter().setView(this);

        findViewById(R.id.SignUpCustomerButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.getPresenter().onSignup();
            }
        });

        findViewById(R.id.SignUpPersonelButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.getPresenter().onSignupPersonel();
            }
        });

        findViewById(R.id.SignUpOwnerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onSignupOwner();
            }
        });

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().authenticate();

            }
        });
    }

    public String ExtractUsername()
    {
      return ((EditText)findViewById(R.id.usernameText)).getText().toString().trim();

    }
    public String ExtractPassword()
    {
        return ((EditText)findViewById(R.id.passwordText)).getText().toString().trim();
    }
    public void signup(){
        Intent intent = new Intent(LoginActivity.this, SignUpCustomerActivity.class);
        startActivity(intent);
    }

    public void signupPersonel() {
        Intent intent = new Intent(LoginActivity.this, SignUpPersonelActivity.class);
        startActivity(intent);
    }
    public void signupOwner() {
        Intent intent = new Intent(LoginActivity.this, SignUpOwnerActivity.class);
        startActivity(intent);
    }

    public void redirectToCustomerPage(int customerId){
        Intent intent = new Intent(LoginActivity.this, ChooseRestaurantActivity.class);
        intent.putExtra("CustomerId",customerId);
        startActivity(intent);
    }
    public void redirectToChefHomePage(int chefId){
            Intent intent = new Intent(LoginActivity.this, ChefHomePageActivity.class);
            intent.putExtra("ChefId",chefId);
            startActivity(intent);
    }
    public void redirectToOwnerHomePage(int ownerId){
        Intent intent = new Intent(LoginActivity.this, OwnerHomePageActivity.class);
        intent.putExtra("OwnerId",ownerId);
        startActivity(intent);
    }

}