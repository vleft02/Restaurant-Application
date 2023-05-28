package gr.aueb.softeng.view.Customer.HomePage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomerHomePageViewPagerAdapter extends FragmentStateAdapter {
    public CustomerHomePageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new CurrentOrderPageFragment();
            case 1:
                return new OrderHistoryPageFragment();
            default:
                return new CurrentOrderPageFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
