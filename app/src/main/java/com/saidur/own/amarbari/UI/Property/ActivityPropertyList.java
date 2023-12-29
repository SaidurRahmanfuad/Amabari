package com.saidur.own.amarbari.UI.Property;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.saidur.own.amarbari.Adapter.Adapter_PropertyList;
import com.saidur.own.amarbari.Model.ModelRent;
import com.saidur.own.amarbari.Model.property.ModelProperty;
import com.saidur.own.amarbari.Network.Request.RQ_House_Save;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.databinding.ActivityPropertyListBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityPropertyList extends AppCompatActivity implements BottomSheetDialogProperty.BottomSheetListener {
ActivityPropertyListBinding binding;
    Adapter_PropertyList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPropertyListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String menu = getIntent().getStringExtra("Who");
        switch (menu) {
            case "Home":
                List<ModelProperty> data=new ArrayList<>();
                data.add(new ModelProperty(R.drawable.nn,"#Sp01","Shpner Nir","Mirpur 2","5","10", new ModelRent("12,000")));
                data.add(new ModelProperty(R.drawable.nn,"#Sp02","Ma Monjil","Dhanmondi 32","5","10", new ModelRent("25,000")));
                data.add(new ModelProperty(R.drawable.nn,"#Sp03","Mohini Manjil","Mirpur 1","4","8", new ModelRent("17,000")));

                showView(menu,data);
                break;
            case "Apartment":
                showView(menu,null);
                break;
            case "Shop":
                showView(menu,null);
                break;
            case "Flat":
                showView(menu,null);
                break;
            case "Office":
                showView(menu,null);
                break;
        }
        binding.btnAddProperty.setOnClickListener(view -> {
            BottomSheetDialogProperty bottomSheetDialog = BottomSheetDialogProperty.newInstance();
            bottomSheetDialog.show(getSupportFragmentManager(),
                    BottomSheetDialogProperty.TAG);
        });
    }
    private void showView(String name,List<ModelProperty> data) {

        binding.tvProperty.setText(name);
        if(data!=null)
        {
            binding.tvTotalProperty.setText(String.valueOf(data.size()));
        }else {
            binding.tvTotalProperty.setText("0");
        }


        adapter = new Adapter_PropertyList(ActivityPropertyList.this, data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ActivityPropertyList.this);
        binding.rvList.setLayoutManager(mLayoutManager);
        binding.rvList.setItemAnimator(new DefaultItemAnimator());
        binding.rvList.setAdapter(adapter);
        binding.rvList.setItemAnimator(null);
        binding.rvList.scrollToPosition(0);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void SaveHouseClick(RQ_House_Save data) {

    }
}