package gr.aueb.softeng.view.Customer.HomePage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomerHomePageViewPagerAdapter extends FragmentStateAdapter {
    int customerId;
    public CustomerHomePageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,int id) {
        super(fragmentActivity);
        customerId = id;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {//The tab which should be next is chosen
        switch(position) {
            case 0:
                return CurrentOrderPageFragment.newInstance(customerId);
            case 1:
                return OrderHistoryPageFragment.newInstance(customerId);
            default:
                return CurrentOrderPageFragment.newInstance(customerId);
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
