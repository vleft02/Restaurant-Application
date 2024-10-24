package gr.aueb.softeng.view.Customer.HomePage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomerHomePageViewPagerAdapter extends FragmentStateAdapter {
    private final FragmentListener listener;
    Fragment currFragment = null;
    public CustomerHomePageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,FragmentListener listener) {
        super(fragmentActivity);
        this.listener = listener;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {//The tab which should be next is chosen
        switch(position) {
            case 0:
                currFragment =  OrderHistoryPageFragment.newInstance(listener);
                return currFragment;
            case 1:
                currFragment = CurrentOrderPageFragment.newInstance(listener);
                return currFragment;

            default:
                 currFragment = CurrentOrderPageFragment.newInstance(listener);
                 return currFragment;
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public Fragment getCurrFragment()
    {
        return currFragment;
    }
}
