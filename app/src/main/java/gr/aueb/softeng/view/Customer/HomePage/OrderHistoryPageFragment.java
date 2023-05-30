package gr.aueb.softeng.view.Customer.HomePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gr.aueb.softeng.team08.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderHistoryPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderHistoryPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CUSTOMER_ID = "CustomerId";

    // TODO: Rename and change types of parameters
    private int customerId;

    public OrderHistoryPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id Parameter 1.
     * @return A new instance of fragment OrderHistoryPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderHistoryPageFragment newInstance(int id) {
        OrderHistoryPageFragment fragment = new OrderHistoryPageFragment();
        Bundle args = new Bundle();
        args.putInt(CUSTOMER_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            customerId = getArguments().getInt(CUSTOMER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_history_page, container, false);
    }
}