package com.saidur.own.amarbari.UI.Tanent_Dash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.databinding.FragmentTSettingsBinding;


public class FragmentTSettings extends Fragment {
    FragmentTSettingsBinding binding;

    public FragmentTSettings() {
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
        binding = FragmentTSettingsBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }
}