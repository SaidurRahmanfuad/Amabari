package com.saidur.own.amarbari;

import static com.saidur.own.amarbari.Utils.SessionManager.languages;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.saidur.own.amarbari.Utils.SessionManager;

import java.util.Locale;

public class RootActivity extends AppCompatActivity {
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(this);
        if (sessionManager.getStringData(languages) == null) {
            sessionManager.setStringData(languages, "en");
        }
        setApplicationlanguage(sessionManager.getStringData(languages));
    }





    @Override
    protected void onStart() {
        super.onStart();


    }

    public void setApplicationlanguage(String language) {
        try {
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                conf.setLocale(new Locale(language)); // API 17+ only.
            } else {
                conf.locale = new Locale(language);
            }
            res.updateConfiguration(conf, dm);
        } catch (Exception e) {
            Log.e("Error for RTL ", "-->" + e.getMessage());
        }

    }
}