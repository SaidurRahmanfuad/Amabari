package com.saidur.own.amarbari.UI.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;


import com.saidur.own.amarbari.Database.DBCrudHelper;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Notification.FragmentNotification;
import com.saidur.own.amarbari.databinding.ActivityDashBinding;
import com.wwdablu.soumya.lottiebottomnav.FontBuilder;
import com.wwdablu.soumya.lottiebottomnav.FontItem;
import com.wwdablu.soumya.lottiebottomnav.ILottieBottomNavCallback;
import com.wwdablu.soumya.lottiebottomnav.LottieBottomNav;
import com.wwdablu.soumya.lottiebottomnav.MenuItem;
import com.wwdablu.soumya.lottiebottomnav.MenuItemBuilder;

import java.util.ArrayList;
import java.util.List;

public class ActivityDash extends AppCompatActivity implements ILottieBottomNavCallback {
    ActivityDashBinding binding;
    ArrayList<MenuItem> list;
    Typeface typeface;
    LottieBottomNav bottomNav;
    DBCrudHelper dbCrudHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbCrudHelper=new DBCrudHelper(ActivityDash.this);
        ModelSession session=dbCrudHelper.getSessionUser();
        if (savedInstanceState == null) {
            openFragment(new FragmentHome());
        }
        bottomNav   = findViewById(R.id.bottom_nav);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            typeface=getResources().getFont(R.font.gilroybold);
        }
        binding.tvUser.setText(session.getName());
        //Set font item
        FontItem fontItem = FontBuilder.create("Dashboard")
                .selectedTextColor(Color.BLACK)
                .unSelectedTextColor(Color.GRAY)
                .selectedTextSize(16) //SP
                .unSelectedTextSize(12) //SP
                //.setTypeface(Typeface.createFromAsset(getAssets(), "g_bold.ttf"))
               // .setTypeface(Typeface.create("g_bold.ttf", Typeface.BOLD))
               // .setTypeface(typeface)
                .build();
        //Menu Dashboard
        MenuItem item1 = MenuItemBuilder.create("dash.json", MenuItem.Source.Assets, fontItem, "dash")
                .pausedProgress(1f)
                .loop(false)
                .build();

        //Example Spannable String (at Menu Gifts)
        SpannableString spannableString = new SpannableString("Gifts");
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //Menu Gifts
        fontItem = FontBuilder.create(fontItem).setTitle(spannableString).build();
        MenuItem item2 = MenuItemBuilder.createFrom(item1, fontItem)
                .selectedLottieName("notifications.json")
                .unSelectedLottieName("notifications.json")
                .loop(true)
                .build();

        //Menu Mail
        fontItem = FontBuilder.create(fontItem).setTitle("Mail").build();
        MenuItem item3 = MenuItemBuilder.createFrom(item1, fontItem)
                .selectedLottieName("dash.json")
                .unSelectedLottieName("dash.json")
                .pausedProgress(0.75f)
                .build();

        //Menu Settings
        fontItem = FontBuilder.create(fontItem).setTitle("Settings").build();
        MenuItem item4 = MenuItemBuilder.createFrom(item1, fontItem)
                .selectedLottieName("notifications.json")
                .unSelectedLottieName("notifications.json")
                .build();
        //list = new ArrayList<>(4);
        list=new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        bottomNav.setCallback(this);
      //  bottomNav.setMenuItemList(list);
        bottomNav.setSelectedIndex(0); //first selected index

        //First selected fragment
        openFragment(new FragmentHome());

       // binding.bottomNavigation.setOnItemSelectedListener(navigationItemSelectedListener);
    }

    @Override
    public void onMenuSelected(int oldIndex, int newIndex, MenuItem menuItem) {
        switch (newIndex) {
            case 0: {
                openFragment(new FragmentHome());
                break;
            }
            case 1: {
                openFragment(new FragmentNotification());
                break;
            }
            case 2: {
               // setFragment(new MailFragment());
                break;
            }
           /* case 3: {
                //setFragment(new SettingsFragment());
                break;
            }*/
        }
    }

    @Override
    public void onAnimationStart(int index, MenuItem menuItem) {

    }

    @Override
    public void onAnimationEnd(int index, MenuItem menuItem) {

    }

    @Override
    public void onAnimationCancel(int index, MenuItem menuItem) {

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

 /*   BottomNavigationView.OnItemSelectedListener navigationItemSelectedListener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(new FragmentHome());
                        return true;
                    case R.id.navigation_property:

                        // startActivity(new Intent(ActivityDash.this, NotificationActivity.class));
                        return true;
                    case R.id.navigation_notifications:
                        openFragment(new FragmentNotification());
                       // startActivity(new Intent(ActivityDash.this, NotificationActivity.class));
                        return true;
                    case R.id.navigation_setting:
                       // startActivity(new Intent(ActivityDash.this, SettingActivity.class));
                        return true;
                    default:
                        break;
                }
                return false;
            };*/
}
