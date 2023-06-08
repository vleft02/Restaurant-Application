package gr.aueb.softeng.view.Owner.AddRestaurant;

import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;

public class AddRestaurantViewStub implements AddRestaurantView{
    private String name,telephone,streetName, streetNumber, zc,city,total_tables,errorTitle,errorMessage,successMessage;
    private int goBackPressed,errorCount;
    public AddRestaurantViewStub(){
        name=telephone=streetName=streetNumber=zc=city=total_tables=errorTitle=errorMessage=successMessage="";
        goBackPressed=errorCount=0;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setTelephone(String telephone){
        this.telephone=telephone;
    }
    public void setStreetName(String streetName){
        this.streetName=streetName;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public void setZc(String zc){
        this.zc=zc;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setTotalTables(String total){
        this.total_tables=total;
    }

    public String getErrorTitle()
    {
        return errorTitle;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public String getSuccessMessage()
    {
        return successMessage;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getGoBackPressed(){return goBackPressed;}

    @Override
    public HashMap<String, String> getRestDetails() {
        HashMap<String, String> details = new HashMap<>();
        details.put("name", this.name);
        details.put("telephone", this.telephone);
        details.put("streetName", this.streetName);
        details.put("streetNumber", this.streetNumber);
        details.put("zc", this.zc);
        details.put("city", this.city);
        details.put("total_tables", this.total_tables);
        return details;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        errorTitle = title;
        errorMessage = message;
        errorCount++;
    }

    @Override
    public void goBack() {
        goBackPressed++;
    }

    @Override
    public void showRestaurantAddedMessage() {
        successMessage = "the restaurant was successfully created";
    }
}
