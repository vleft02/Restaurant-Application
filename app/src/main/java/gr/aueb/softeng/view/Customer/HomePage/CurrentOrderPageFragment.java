package gr.aueb.softeng.view.Customer.HomePage;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;

import gr.aueb.softeng.memoryDao.ChefDAOmemory;
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
    private static final String LISTENER = "Listener";

    // TODO: Rename and change types of parameters
    private FragmentListener listener;

    public ImageButton plusButton;
    public ImageButton cancelButton;
    public TextView noOrderText;
    public ConstraintLayout orderDetailsLayout;
    public TextView orderDetails;



    public CurrentOrderPageFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param listener Parameter 1.
     * @return A new instance of fragment CurrentOrderPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentOrderPageFragment newInstance(FragmentListener listener) {
        CurrentOrderPageFragment fragment = new CurrentOrderPageFragment();
        Bundle args = new Bundle();
        args.putSerializable(LISTENER, (Serializable) listener);
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

        View rootView = inflater.inflate(R.layout.fragment_current_order,container,false);
        listener.getViewModel().getPresenter().setFragment(this);


        plusButton = (ImageButton) rootView.findViewById(R.id.PlaceOrderButton);
        cancelButton =(ImageButton) rootView.findViewById(R.id.CancelOrderButton);
        noOrderText = (TextView) rootView.findViewById(R.id.NoOrderText);
        orderDetailsLayout = (ConstraintLayout) rootView.findViewById(R.id.CurrentOrderConstraintLayout);
        orderDetails = (TextView) rootView.findViewById(R.id.OrderDetails);


        listener.changeLayout();


        rootView.findViewById(R.id.CancelOrderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCancel();
            }
        });
        rootView.findViewById(R.id.PlaceOrderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPlaceOrder();
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
    }
}