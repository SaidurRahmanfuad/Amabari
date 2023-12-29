package com.saidur.own.amarbari.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.saidur.own.amarbari.UI.Home.ActivityDash;
import com.saidur.own.amarbari.databinding.ActivityProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityProfile extends AppCompatActivity {
ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCountinue.setOnClickListener(view -> {
            startActivity(new Intent(ActivityProfile.this, ActivityDash.class));
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        });

        List<String> role=new ArrayList<>();
        role.add("Property Owner");
        role.add("Tenant");
        ArrayAdapter dapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,role);
        //binding.ivRoleDropdown.setS
        binding.ivRoleDropdown.setOnClickListener(v -> {


        });
    }
}