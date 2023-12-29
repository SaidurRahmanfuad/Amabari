package com.saidur.own.amarbari.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.saidur.own.amarbari.databinding.ActivityVerifyPhoneBinding;

public class ActivityVerifyPhone extends AppCompatActivity {
ActivityVerifyPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVerifyPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSend.setOnClickListener(view -> {
            startActivity(new Intent(ActivityVerifyPhone.this, ActivityProfile.class));
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        });
    }
}