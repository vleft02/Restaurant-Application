package gr.aueb.softeng.view.Owner.HomePage;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

public class OwnerHomePageViewStub implements OwnerHomePageView{
    private int goBackPressed,addRestaurantPressed,noRestaurants,restaurantsFound;

    public OwnerHomePageViewStub(){
        goBackPressed=addRestaurantPressed=noRestaurants=restaurantsFound=0;
    }
    public int getGoBackPressed(){return goBackPressed;}

    public int getAddRestaurantPressed(){
        return addRestaurantPressed;
    }

    public int getNoRestaurants(){
        return this.noRestaurants;
    }
    public int getRestaurantsFound(){
        return this.restaurantsFound;
    }


    @Override
    public void AddRestaurant() {
        addRestaurantPressed++;
    }

    @Override
    public void ShowNoRestaurants() {
        noRestaurants++;
    }

    @Override
    public void ShowRestaurants() {
        restaurantsFound++;
    }


    @Override
    public void goBack() {
        goBackPressed++;
    }

}
