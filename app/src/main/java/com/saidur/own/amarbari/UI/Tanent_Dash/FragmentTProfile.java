package com.saidur.own.amarbari.UI.Tanent_Dash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.databinding.FragmentTProfileBinding;


public class FragmentTProfile extends Fragment {
    FragmentTProfileBinding binding;

    public FragmentTProfile() {
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
        binding=FragmentTProfileBinding.inflate(getLayoutInflater());


        return binding.getRoot();
    }
}