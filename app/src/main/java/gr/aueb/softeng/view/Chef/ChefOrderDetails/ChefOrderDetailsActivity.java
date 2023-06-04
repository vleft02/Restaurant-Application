package gr.aueb.softeng.view.Chef.ChefOrderDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import gr.aueb.softeng.team08.R;


public class ChefOrderDetailsActivity extends AppCompatActivity  implements ChefOrderDetailsView{

    public int OrderId;
    RecyclerView recyclerView;
    ChefOrderDetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_order_details);

        viewModel = new ViewModelProvider(this).get(ChefOrderDetailsViewModel.class);
        viewModel.getPresenter().setView(this);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            OrderId = extras.getInt("OrderId");
        }

        viewModel.getPresenter().setOrder(OrderId); // sets the orderId so the presenter which order we are referring to
        viewModel.getPresenter().setOrderLineList();
        viewModel.getPresenter().setOrderDetails();
        // ui initialization
        recyclerView = findViewById(R.id.OrderLinesRecyclerView);

        findViewById(R.id.SetCompletedButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.getPresenter().onCompleted();
            }
        });

        findViewById(R.id.GoBack3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){viewModel.getPresenter().OnBack();}
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getPresenter().setOrderLineList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChefOrderDetailsRecyclerViewAdapter(viewModel.getPresenter().getOrderLineList()));
    }

    public void setOrderId(String orderId){
        ((TextView)findViewById(R.id.OrderIdText)).setText("Id:"+orderId);
    }
    public void setOrderState(String state){
        ((TextView)findViewById(R.id.OrderStateText)).setText("State:"+state);
    }
    public void setTableNumber(String num){
        ((TextView)findViewById(R.id.TableNumberText)).setText("Table:"+num);
    }
    public void setDate(String date){
        ((TextView)findViewById(R.id.DateText)).setText(date);
    }
    public void goBack(){
        finish();
    }


}