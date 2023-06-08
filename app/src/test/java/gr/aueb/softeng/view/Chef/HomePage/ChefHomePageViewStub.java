package gr.aueb.softeng.view.Chef.HomePage;

public class ChefHomePageViewStub implements ChefHomePageView{
    private  int noOrders,ordersFound,goBackPressed;

    public ChefHomePageViewStub(){
        noOrders=ordersFound=goBackPressed=0;
    }
    @Override
    public void goBack() {
        goBackPressed++;
    }
    public int getGoBackPressed(){return goBackPressed;}

    @Override
    public void ShowNoOrders() {
        noOrders++;
    }

    @Override
    public void ShowOrders() {
        ordersFound++;
    }
    public int getOrdersFound(){
        return this.ordersFound;
    }
    public int getNoOrders(){
        return this.noOrders;
    }
}
