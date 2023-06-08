package gr.aueb.softeng.view.Customer.ChooseRestaurant;

public class ChooseRestaurantViewStub implements ChooseRestaurantView{


    private int restaurantsFound, goBackIsPressed, noRestaurants;

    public int getGoBackIsPressed() {
        return goBackIsPressed;
    }

    public int getNoRestaurants() {
        return noRestaurants;
    }

    public int getRestaurantsFound() {
        return restaurantsFound;
    }

    public ChooseRestaurantViewStub(){
        goBackIsPressed = noRestaurants = restaurantsFound;
    }
    @Override
    public void goBack() {
        goBackIsPressed++;
    }

    @Override
    public void ShowNoRestaurants() {
        noRestaurants++;
    }

    @Override
    public void ShowRestaurants() {
        restaurantsFound++;
    }
}
