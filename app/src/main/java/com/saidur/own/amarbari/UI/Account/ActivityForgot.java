package com.saidur.own.amarbari.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.saidur.own.amarbari.databinding.ActivityForgotBinding;

public class ActivityForgot extends AppCompatActivity {
ActivityForgotBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}