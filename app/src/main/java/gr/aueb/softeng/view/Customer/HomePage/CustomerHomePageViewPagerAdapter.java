package gr.aueb.softeng.view.Customer.HomePage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomerHomePageViewPagerAdapter extends FragmentStateAdapter {
    private final FragmentListener listener;
    public CustomerHomePageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,FragmentListener listener) {
        super(fragmentActivity);
        this.listener = listener;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {//The tab which should be next is chosen
        switch(position) {
            case 0:
                return CurrentOrderPageFragment.newInstance(listener);
            case 1:
                return OrderHistoryPageFragment.newInstance(listener);
            default:
                return CurrentOrderPageFragment.newInstance(listener);
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
