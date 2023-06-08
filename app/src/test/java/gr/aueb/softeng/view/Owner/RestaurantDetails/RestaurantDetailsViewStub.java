package gr.aueb.softeng.view.Owner.RestaurantDetails;

public class RestaurantDetailsViewStub implements RestaurantDetailsView{

    private String name,id,tables,street,num,zip,city,errorTitle,errorMessage;
    private int addChefButtonPressed,extractStatsButtonPressed,goBackPressed,errorCount;
    public RestaurantDetailsViewStub(){
        name=id=tables=street=num=zip=city="";
        addChefButtonPressed=extractStatsButtonPressed=goBackPressed=errorCount=0;

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
    public void setRestName(String name) {
        this.name=name;
    }
    public String getRestName(){return this.name;}
    @Override
    public void setRestId(String id) {
        this.id=id;
    }
    public String getRestId(){return this.id;}

    @Override
    public void setRestTables(String tables) {
        this.tables=tables;
    }
    public String getRestTables(){
        return this.tables;
    }
    @Override
    public void setRestAddressStreet(String street) {
        this.street=street;
    }
    public String getRestAddressStreet(){
        return this.street;
    }
    @Override
    public void setRestAddressNumber(String num) {
        this.num=num;
    }
    public String getAddressNumber(){
        return this.num;
    }
    @Override
    public void setRestZip(String zip) {
        this.zip=zip;
    }
    public String getRestZip(){
        return this.zip;
    }

    @Override
    public void setRestAddressCity(String city) {
        this.city=city;
    }
    public String getRestAddressCity(){
        return this.city;
    }

    @Override
    public void extractStats() {
        extractStatsButtonPressed++;
    }

    @Override
    public void addChef() {
        addChefButtonPressed++;
    }

    public String getErrorTitle()
    {
        return errorTitle;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getGoBackPressed(){return goBackPressed;}

    public int getAddChefButtonPressed(){
        return this.addChefButtonPressed;
    }
    public int getExtractStatsButtonPressed(){
        return this.extractStatsButtonPressed;
    }
}
