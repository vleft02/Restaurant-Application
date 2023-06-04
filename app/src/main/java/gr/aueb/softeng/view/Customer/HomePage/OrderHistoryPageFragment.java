package gr.aueb.softeng.view.Customer.HomePage;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;


import gr.aueb.softeng.domain.Order;

import gr.aueb.softeng.team08.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderHistoryPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderHistoryPageFragment extends Fragment implements OrderSelectionListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String LISTENER = "Listener";

    // TODO: Rename and change types of parameters
    private FragmentListener listener;
    RecyclerView recyclerView;
    public OrderHistoryPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param listener Parameter 1.
     * @return A new instance of fragment OrderHistoryPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderHistoryPageFragment newInstance(FragmentListener listener) {
        OrderHistoryPageFragment fragment = new OrderHistoryPageFragment();
        Bundle args = new Bundle();
        args.putSerializable(LISTENER,(Serializable) listener);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listener = (FragmentListener) getArguments().getSerializable(LISTENER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listener.getViewModel().getPresenter().setOrderHistory();
        View rootView = inflater.inflate(R.layout.fragment_order_history_page, container, false);
        recyclerView = rootView.findViewById(R.id.OrderHistoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new OrderHistoryRecyclerViewAdapter(listener.getViewModel().getPresenter().getOrderHistory(),this));


        return rootView;
    }

    @Override
    public void selectOrder(Order order) {
        //intent to order details page
    }
}