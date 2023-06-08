package gr.aueb.softeng.view.Owner.AddChef;

import android.widget.EditText;

import java.util.HashMap;

import gr.aueb.softeng.team08.R;

public class AddChefViewStub implements AddChefView{
    private String errorTitle,errorMessage,name,surname,username,telephone,iban,tin,successMessage;
    private int errorCount,goBackPressed;

    public AddChefViewStub(){
        errorTitle = errorMessage =name=surname=username=telephone=iban=tin=successMessage="";
        errorCount=goBackPressed=0;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setTelephone(String tel){
        this.telephone=tel;
    }
    public void setIban(String iban){
        this.iban=iban;
    }
    public void setTin(String tin){
        this.tin=tin;
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
    public HashMap<String, String> getChefDetails() {
        HashMap<String,String> details = new HashMap<>();
        details.put("name",this.name);
        details.put("surname",this.surname);
        details.put("username",this.username);
        details.put("telephone",this.telephone);
        details.put("iban",this.iban);
        details.put("tin",this.tin);
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
    public void showChefAddedMessage() {///////////////////////////////////////
        successMessage ="chef with id was successfully added";
    }

}
