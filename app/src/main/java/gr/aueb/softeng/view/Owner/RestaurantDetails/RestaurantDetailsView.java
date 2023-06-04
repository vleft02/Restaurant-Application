package gr.aueb.softeng.view.Owner.RestaurantDetails;



public interface RestaurantDetailsView {
    void showErrorMessage(String title, String message);
    void goBack();
     void setRestName(String name);
     void setRestId(String id);
     void setRestTables(String tables);
     void setRestAddressStreet(String street);
     void setRestAddressNumber(String num);
     void setRestZip(String zip);
     void setRestAddressCity(String city);
     void extractStats();
     void addChef();
}
