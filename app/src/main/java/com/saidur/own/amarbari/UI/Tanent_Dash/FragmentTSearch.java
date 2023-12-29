package com.saidur.own.amarbari.UI.Tanent_Dash;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.load.model.Model;
import com.google.gson.Gson;
import com.saidur.own.amarbari.Adapter.Tanent_side.Adapter_Buildings;
import com.saidur.own.amarbari.Interface.ISearchPage;
import com.saidur.own.amarbari.Model.Account.ModelProfile;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;
import com.saidur.own.amarbari.Model.Tanent_side.ModelFlats;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;
import com.saidur.own.amarbari.Presenter.PresenterSearchPage;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Tanent_Dash.Pages.ActivityBuildings;
import com.saidur.own.amarbari.UI.Tanent_Dash.Pages.ActivityProperties;
import com.saidur.own.amarbari.Utils.Consts;
import com.saidur.own.amarbari.databinding.FragmentTSearchBinding;

import java.util.ArrayList;
import java.util.List;


public class FragmentTSearch extends Fragment implements ISearchPage.View {
    FragmentTSearchBinding binding;
    PresenterSearchPage presenter;
    Dialog pd;
    public static List<ModelBuildings> dataBuildings;

    public FragmentTSearch() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTSearchBinding.inflate(getLayoutInflater());
        presenter = new PresenterSearchPage(requireActivity(), this);
        binding.layPd.pd.setVisibility(View.VISIBLE);
        presenter.get_buildings();

        //Categories
        ClickCatagories();

        binding.blockBuildings.btnViewAllBld.setOnClickListener(v -> {
            Gson gson = new Gson();
            String data = gson.toJson(dataBuildings);
            Intent ins = new Intent(requireActivity(), ActivityBuildings.class);
            ins.putExtra("Buildings", data);
            startActivity(ins);
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        return binding.getRoot();
    }

    private void ClickCatagories() {
        binding.categories.catBuilding.setOnClickListener(v -> {
            Gson gson = new Gson();
            String data = gson.toJson(dataBuildings);
            Intent ins = new Intent(requireActivity(), ActivityBuildings.class);
            ins.putExtra("Buildings", data);
            startActivity(ins);
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.categories.catFlats.setOnClickListener(v -> {
            Consts.Who = "MainSearch_flat";
            Intent ins = new Intent(requireActivity(), ActivityProperties.class);
            startActivity(ins);
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.categories.catSeat.setOnClickListener(v -> {
            Consts.Who = "MainSearch_seat";
            Intent ins = new Intent(requireActivity(), ActivityProperties.class);
            startActivity(ins);
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.categories.catOffice.setOnClickListener(v -> {
            Consts.Who = "Office";
            Intent ins = new Intent(requireActivity(), ActivityProperties.class);
            startActivity(ins);
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.categories.catShop.setOnClickListener(v -> {
            Consts.Who = "MainSearch_shop";
            Intent ins = new Intent(requireActivity(), ActivityProperties.class);
            startActivity(ins);
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

    }


    @Override
    public void onViewBuildings(List<ModelBuildings> data) {
        binding.layPd.pd.setVisibility(View.INVISIBLE);
        dataBuildings = data;
        Adapter_Buildings dapter = new Adapter_Buildings(requireActivity(), data, "Main");
        GridLayoutManager gm = new GridLayoutManager(requireActivity(), 2, RecyclerView.VERTICAL, false);
        gm.setSpanCount(2);
        /*gm.setColumn(2);
        gm.setRow(4);*/
        binding.blockBuildings.rvBuildings.setLayoutManager(gm);
        binding.blockBuildings.rvBuildings.setAdapter(dapter);
        dapter.notifyDataSetChanged();
    }

    @Override
    public void onViewFlats(List<ModelFlats> flats) {

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