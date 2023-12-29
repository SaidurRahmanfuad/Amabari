package com.saidur.own.amarbari.UI.Tanent_Dash.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.saidur.own.amarbari.Adapter.Tanent_side.Adapter_Buildings;
import com.saidur.own.amarbari.Adapter.Tanent_side.Adapter_Flats;
import com.saidur.own.amarbari.Interface.ISearchPage;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;
import com.saidur.own.amarbari.Model.Tanent_side.ModelFlats;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;
import com.saidur.own.amarbari.Network.Response.Rp_flats;
import com.saidur.own.amarbari.Presenter.PresenterSearchPage;
import com.saidur.own.amarbari.Utils.Consts;
import com.saidur.own.amarbari.databinding.ActivityPropertiesBinding;

import java.util.List;

public class ActivityProperties extends AppCompatActivity implements ISearchPage.View {
    ActivityPropertiesBinding binding;
    PresenterSearchPage presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPropertiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new PresenterSearchPage(ActivityProperties.this, this);
        String building_Id = getIntent().getStringExtra("Bid");
        switch (Consts.Who) {
            case "Building_Adapter":
                presenter.get_flatsBy_building(building_Id);
                break;
            case "MainSearch_flat":
                presenter.get_flats();
                break;
            case "MainSearch_seat":
                presenter.get_sits();
                break;
            case "MainSearch_shop":
                presenter.get_shops();
                break;
        }

    }

    @Override
    public void onViewBuildings(List<ModelBuildings> buildings) {

    }

    @Override
    public void onViewFlats(List<ModelFlats> flats) {
        Adapter_Flats dapter = new Adapter_Flats(ActivityProperties.this, flats, "Other");
        /*GridLayoutManager gm = new GridLayoutManager(ActivityProperties.this, 2, RecyclerView.VERTICAL, false);
        gm.setSpanCount(2);*/
        binding.rvProperties.setLayoutManager(new LinearLayoutManager(this));
        binding.rvProperties.setAdapter(dapter);
        dapter.notifyDataSetChanged();
    }

    @Override
    public void onViewCommercials(Rp_Registration logindata) {

    }

    @Override
    public void onViewSits(String message) {

    }

    @Override
    public void onShops(ModelSession message) {

    }

    @Override
    public void onDataNotFound(String message) {

    }
}