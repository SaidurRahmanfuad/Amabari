package com.saidur.own.amarbari.UI.Tenant;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saidur.own.amarbari.Adapter.Adapter_TenantList;
import com.saidur.own.amarbari.Model.ModelRent;
import com.saidur.own.amarbari.Model.ModelTenant;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.databinding.FragmentHomeBinding;
import com.saidur.own.amarbari.databinding.FragmentTenantBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentTenant extends Fragment {
FragmentTenantBinding binding;

    public FragmentTenant() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTenantBinding.inflate(inflater,container,false);

        LoadTenant();
        return binding.getRoot();
    }

    private void LoadTenant() {
        List<ModelTenant> tList=new ArrayList<>();
        tList.add(new ModelTenant(R.drawable.ic_user,"Saidur Rahman","1234","Madaripur",
                new ModelRent("100","Mayer doa","dhaka","12/2/2022","Pending")));
        tList.add(new ModelTenant(R.drawable.nn,"Saidur Rahman","1234","Madaripur",
                new ModelRent("100","Mayer doa","dhaka","12/2/2022","Pending")));
        tList.add(new ModelTenant(R.drawable.nn,"Saidur Rahman","1234","Madaripur",
                new ModelRent("100","Mayer doa","dhaka","12/2/2022","Pending")));
        tList.add(new ModelTenant(R.drawable.nn,"Saidur Rahman","1234","Madaripur",
                new ModelRent("100","Mayer doa","dhaka","12/2/2022","Pending")));

        Adapter_TenantList adapter=new Adapter_TenantList(requireContext(),tList);
        binding.rvTenants.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvTenants.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}