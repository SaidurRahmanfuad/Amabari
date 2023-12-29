package com.saidur.own.amarbari.UI.Property;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.saidur.own.amarbari.Adapter.Adapter_PropertyList;
import com.saidur.own.amarbari.Model.ModelRent;
import com.saidur.own.amarbari.Model.property.ModelProperty;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Home.FragmentHome;
import com.saidur.own.amarbari.UI.Notification.FragmentNotification;
import com.saidur.own.amarbari.UI.Tenant.FragmentTenant;
import com.saidur.own.amarbari.databinding.ActivityPropertyDashBoardBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityPropertyDashBoard extends AppCompatActivity {
    ActivityPropertyDashBoardBinding binding;
    Adapter_PropertyList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPropertyDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            openFragment(new FragmentHome());
        }

        String menu = getIntent().getStringExtra("Who");
        binding.dashSummary.tvPName.setText(menu+"'s");

        binding.btnHInfo.setOnClickListener(view -> {
            binding.btnHInfo.setBackgroundResource(R.color.color_green_shade);
            binding.btnBInfo.setBackgroundResource(0);
            binding.btnTInfo.setBackgroundResource(0);
            openFragment(new FragmentTenant());
        });
        binding.btnBInfo.setOnClickListener(view -> {
            binding.btnBInfo.setBackgroundResource(R.color.color_green_shade);
            binding.btnHInfo.setBackgroundResource(0);
            binding.btnTInfo.setBackgroundResource(0);
            openFragment(new FragmentNotification());
        });
        binding.btnTInfo.setOnClickListener(view -> {
            binding.btnTInfo.setBackgroundResource(R.color.color_green_shade);
            binding.btnBInfo.setBackgroundResource(0);
            binding.btnHInfo.setBackgroundResource(0);
            openFragment(new FragmentTenant());
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.container_property, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}