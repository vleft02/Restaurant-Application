package gr.aueb.softeng.view.Customer.HomePage;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import gr.aueb.softeng.memoryDao.CustomerDAOmemory;
import gr.aueb.softeng.memoryDao.OrderDAOmemory;
import gr.aueb.softeng.team08.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentOrderPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentOrderPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CUSTOMER_ID = "CustomerId";

    // TODO: Rename and change types of parameters
    private int customerId;

    public CurrentOrderPageFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id Parameter 1.
     * @return A new instance of fragment CurrentOrderPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentOrderPageFragment newInstance(int id) {
        CurrentOrderPageFragment fragment = new CurrentOrderPageFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_current_order,container,false);


        ImageButton plusButton = (ImageButton) rootView.findViewById(R.id.PlaceOrderButton);
        ImageButton cancelButton =(ImageButton) rootView.findViewById(R.id.CancelOrderButton);
        TextView noOrderText = (TextView) rootView.findViewById(R.id.NoOrderText);
        ConstraintLayout orderDetailsLayout = (ConstraintLayout) rootView.findViewById(R.id.CurrentOrderConstraintLayout);
        TextView orderDetails = (TextView) rootView.findViewById(R.id.OrderDetails);

        CustomerHomepagePresenter presenter = new CustomerHomepagePresenter(new CustomerDAOmemory(),new OrderDAOmemory());


        if (presenter.getCurrentOrder(customerId)!=null)
        {
            plusButton.setVisibility(View.GONE);
            noOrderText.setVisibility(View.GONE);
            orderDetails.setText(presenter.getCurrentOrderDetails(customerId));

        }
        else{
            cancelButton.setVisibility(View.GONE);
            orderDetailsLayout.setVisibility(View.GONE);
        }

        return rootView;
    }
}