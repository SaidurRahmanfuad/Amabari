package com.saidur.own.amarbari.UI.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.saidur.own.amarbari.Adapter.Adapter_PropertyMenuList;
import com.saidur.own.amarbari.Model.ModelMenuProperty;
import com.saidur.own.amarbari.Model.ModelMonth;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Property.ActivityPropertyDashBoard;
import com.saidur.own.amarbari.UI.Property.ActivityPropertyList;
import com.saidur.own.amarbari.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {
FragmentHomeBinding binding;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        LoadMonth();
        setPropertyMenu();
        return binding.getRoot();
    }

    private void setPropertyMenu() {
        List<ModelMenuProperty> pList=new ArrayList<>();
        pList.add(new ModelMenuProperty(1,R.drawable.ic_home,"Home","You Can See Your Enlisted Home List,Tenants,Vacant Units,Rent (Paid,Due) Status,Utility Bills.","02"));
        pList.add(new ModelMenuProperty(2,R.drawable.ic_apartment,"Apartment","You Can See Enlisted Apartment List,Tenants,Vacant Units,Rent (Paid,Due) Status.","10"));
        pList.add(new ModelMenuProperty(3,R.drawable.ic_shop_store,"Shop","You Can See Your Enlisted Shop List,Tenants,Vacant,Rent (Paid,Due) Status.","00"));
        pList.add(new ModelMenuProperty(4,R.drawable.ic_setting,"Flat","You Can See Your Enlisted Flat List,Tenants,Vacant Units,Rent (Paid,Due) Status,Utility Bills.","00"));
        pList.add(new ModelMenuProperty(5,R.drawable.ic_office,"Office","You Can See Your Enlisted Shop List,Tenants,Vacant,Rent (Paid,Due) Status.","00"));

        Adapter_PropertyMenuList dapter=new Adapter_PropertyMenuList(requireContext(),pList);
        binding.gridPropertyMenu.setAdapter(dapter);
        binding.gridPropertyMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String menu=pList.get(i).getName();
                Toast.makeText(requireContext(), menu, Toast.LENGTH_SHORT).show();

                Intent is=new Intent(requireActivity(), ActivityPropertyList.class);
                is.putExtra("Who",menu);
                startActivity(is);

            }
        });

    }
    private void LoadMonth() {
        List<ModelMonth> mList=new ArrayList<>();
        mList.add(new ModelMonth(1,"Jan"));
        mList.add(new ModelMonth(2,"Feb"));
        mList.add(new ModelMonth(3,"Mar"));
        mList.add(new ModelMonth(4,"Apr"));
        mList.add(new ModelMonth(5,"May"));
        mList.add(new ModelMonth(6,"Jun"));
        mList.add(new ModelMonth(7,"July"));
        mList.add(new ModelMonth(8,"Aug"));
        mList.add(new ModelMonth(9,"Sep"));
        mList.add(new ModelMonth(10,"Oct"));
        mList.add(new ModelMonth(11,"Nov"));
        mList.add(new ModelMonth(12,"Dec"));

        ArrayAdapter<ModelMonth> dapter=new ArrayAdapter<>(requireContext(),R.layout.component_spinner_lay2,mList);
        binding.dashSummary.spinnerMonth.setAdapter(dapter);

    }
}