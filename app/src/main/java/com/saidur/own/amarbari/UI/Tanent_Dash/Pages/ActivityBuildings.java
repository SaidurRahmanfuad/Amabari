package com.saidur.own.amarbari.UI.Tanent_Dash.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.saidur.own.amarbari.Adapter.Tanent_side.Adapter_Buildings;
import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;
import com.saidur.own.amarbari.databinding.ActivityBuildingsBinding;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ActivityBuildings extends AppCompatActivity {
    ActivityBuildingsBinding binding;
    List<ModelBuildings> buildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuildingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Gson gson = new Gson();
       // product = gson.fromJson(getIntent().getStringExtra("Buildings"), ModelProduct.class);
        buildings = gson.fromJson(getIntent().getStringExtra("Buildings"), new TypeToken<ArrayList<ModelBuildings>>(){}.getType());
        setupView(buildings);
    }

    private void setupView(List<ModelBuildings> datas) {
        Adapter_Buildings dapter = new Adapter_Buildings(ActivityBuildings.this, datas,"Other");
        GridLayoutManager gm = new GridLayoutManager(ActivityBuildings.this, 2, RecyclerView.VERTICAL, false);
        gm.setSpanCount(2);
        binding.rvBuildings.setLayoutManager(gm);
        binding.rvBuildings.setAdapter(dapter);
        dapter.notifyDataSetChanged();
    }
}