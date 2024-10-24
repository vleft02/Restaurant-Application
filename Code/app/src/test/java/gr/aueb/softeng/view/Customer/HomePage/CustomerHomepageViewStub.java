package gr.aueb.softeng.view.Customer.HomePage;

public class CustomerHomepageViewStub implements CustomerHomepageView{

    private String message;
    private int noOrderIsShown, orderIsShown ;

    public CustomerHomepageViewStub()
    {
        message = "";
        noOrderIsShown = orderIsShown = 0;
    }

    public String getMessage() {
        return message;
    }

    public int getNoOrderIsShown() {
        return noOrderIsShown;
    }

    public int getOrderIsShown() {
        return orderIsShown;
    }

    @Override
    public void ShowConfirmationMessage() {
        message = "Canceling order";
    }

    @Override
    public void redirectTopUp() {
        message = "Redirecting to top up page";
    }

    @Override
    public void showCurrentOrder() {
        orderIsShown++;
    }

    @Override
    public void showNoCurrentOrder() {
        noOrderIsShown++;
    }

    @Override
    public void showTableNumberPickerPopup() {
        message = "Redirecting to place order page";
    }

}