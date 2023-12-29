package com.saidur.own.amarbari.UI.Tanent_Dash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.saidur.own.amarbari.Database.DBCrudHelper;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.databinding.ActivityTdashBinding;

public class ActivityTDash extends AppCompatActivity implements View.OnClickListener {
    ActivityTdashBinding binding;
    FragmentManager fragmentManager;
    DBCrudHelper dbCrudHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTdashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbCrudHelper = new DBCrudHelper(ActivityTDash.this);
        ModelSession session = dbCrudHelper.getSessionUser();
        binding.tvUser.setText(session.getName());
        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTDash dashFragment = new FragmentTDash();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.containerT, dashFragment).commit();
            home_active();
            search_Inactive();
            profile_Inactive();
            settings_Inactive();
        }


       /* binding.ivDash.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView view = new ImageView(getApplicationContext());
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setLayoutParams(new
                        ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
                return view;
            }
        });*/
        fun_bottomClick();
    }

    private void fun_bottomClick() {
        binding.menuDashT.setOnClickListener(ActivityTDash.this);
        binding.menuSearchT.setOnClickListener(ActivityTDash.this);
        binding.menuProfileT.setOnClickListener(ActivityTDash.this);
        binding.menuSettingsT.setOnClickListener(ActivityTDash.this);
    }

/*    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_MOVE)
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    search_active();
                }
            },200);
        }
        return true;
    }*/

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.menu_dashT:

                fragment = new FragmentTDash();


                home_active();
                search_Inactive();
                profile_Inactive();
                settings_Inactive();

                break;
            case R.id.menu_searchT:
                fragment = new FragmentTSearch();
                search_active();
                home_Inactive();
                profile_Inactive();
                settings_Inactive();
                //binding.ivSearch.setImageResource(R.drawable.ic_search_active);
                // setImageDrawableWithAnimations(binding.ivSearch,getResources().getDrawable(R.drawable.ic_search_active),5000);


                break;
            case R.id.menu_profileT:
                fragment = new FragmentTProfile();
                profile_active();
                search_Inactive();
                settings_Inactive();
                home_Inactive();

                break;

            case R.id.menu_settingsT:
                fragment = new FragmentTSettings();
                settings_active();
                profile_Inactive();
                search_Inactive();
                home_Inactive();
                break;
        }
        if (fragment != null) {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.containerT, fragment).commit();
        }

    }

    //----------------- Custom menu fun--------------//
    void home_active() {
        binding.ivDash.setImageResource(R.drawable.ic_dash_active);
        binding.tvDash.setTextColor(Color.parseColor("#000000"));
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        binding.ivDash.setAnimation(in);

      /*  binding.btnReports.setBackgroundResource(0);
        binding.btnSettings.setBackgroundResource(0);

        binding.icDash.setImageResource(R.drawable.ic_dashboard);
        binding.icReports.setImageResource(R.drawable.ic_reports_unselected);
        binding.icSettings.setImageResource(R.drawable.ic_settings_unselected);

        binding.tvDash.setTextColor(Color.parseColor("#FFFFFF"));
        binding.tvReports.setTextColor(Color.parseColor("#000000"));
        binding.tvSettings.setTextColor(Color.parseColor("#000000"));*/
    }

    void home_Inactive() {
        binding.ivDash.setImageResource(R.drawable.ic_dash);
        //binding.ivDash.setColorFilter(ContextCompat.getColor(this, R.color.colorgrey_1), android.graphics.PorterDuff.Mode.SRC_IN);
        binding.tvDash.setTextColor(Color.parseColor("#868686"));
    }


    void search_active() {

       /* Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        binding.ivSearch.setInAnimation(in);*/
     /*   binding.ivSearch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView view = new ImageView(getApplicationContext());
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setLayoutParams(new
                        ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
                return view;
            }
        });*/
        RotateAnimation rotate = new RotateAnimation(0, 300, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(500);
        rotate.setInterpolator(new LinearInterpolator());
        binding.ivSearch.startAnimation(rotate);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.ivSearch.setImageResource(R.drawable.ic_search);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.ivSearch.setImageResource(R.drawable.ic_search_active);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


     /*   binding.ivSearch.animate().setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                binding.ivSearch.setImageResource(R.drawable.ic_search_active);
            }

            @Override
            public void onAnimationStart(Animator animation) {
               // binding.ivSearch.setInAnimation(rotate);
                binding.ivSearch.startAnimation(rotate);
                super.onAnimationStart(animation);
            }
        });*/

        //setImageDrawableWithAnimations(binding.ivSearch,ContextCompat.getDrawable(this,R.drawable.ic_search_active),10000);
      /*  RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setInterpolator(new LinearInterpolator());
        binding.ivSearch.startAnimation(rotate);*/
     /*   binding.ivSearch.animate().translationX(2)
              .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //view.setVisibility(View.GONE);
                    }
                });*/
        // binding.ivSearch.setColorFilter(null);
        binding.tvSearch.setTextColor(Color.parseColor("#000000"));

      /*  binding.btnReports.setBackgroundResource(0);
        binding.btnSettings.setBackgroundResource(0);

        binding.icDash.setImageResource(R.drawable.ic_dashboard);
        binding.icReports.setImageResource(R.drawable.ic_reports_unselected);
        binding.icSettings.setImageResource(R.drawable.ic_settings_unselected);

        binding.tvDash.setTextColor(Color.parseColor("#FFFFFF"));
        binding.tvReports.setTextColor(Color.parseColor("#000000"));
        binding.tvSettings.setTextColor(Color.parseColor("#000000"));*/
    }

    void search_Inactive() {
     /*   Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        binding.ivSearch.setOutAnimation(out);*/
        // setImageDrawableWithAnimations(binding.ivSearch,ContextCompat.getDrawable(this,R.drawable.ic_search),10000);
        binding.ivSearch.setImageResource(R.drawable.ic_search);
        //binding.ivSearch.setColorFilter(ContextCompat.getColor(this, R.color.colorgrey_1), android.graphics.PorterDuff.Mode.SRC_IN);
        binding.tvSearch.setTextColor(Color.parseColor("#868686"));


    }

    void profile_active() {
        binding.ivProfile.setImageResource(R.drawable.ic_profile_active);
        binding.tvProfile.setTextColor(Color.parseColor("#000000"));
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        binding.tvProfile.setAnimation(in);
    }

    void profile_Inactive() {
        binding.ivProfile.setImageResource(R.drawable.ic_profile);
        binding.ivProfile.setColorFilter(ContextCompat.getColor(this, R.color.colorgrey_1), android.graphics.PorterDuff.Mode.SRC_IN);
        binding.tvProfile.setTextColor(Color.parseColor("#868686"));
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        binding.tvProfile.setAnimation(in);
    }

    void settings_active() {
        binding.ivSettings.setImageResource(R.drawable.ic_dash_active);
        binding.tvSettings.setTextColor(Color.parseColor("#000000"));

      /*  binding.btnReports.setBackgroundResource(0);
        binding.btnSettings.setBackgroundResource(0);

        binding.icDash.setImageResource(R.drawable.ic_dashboard);
        binding.icReports.setImageResource(R.drawable.ic_reports_unselected);
        binding.icSettings.setImageResource(R.drawable.ic_settings_unselected);

        binding.tvDash.setTextColor(Color.parseColor("#FFFFFF"));
        binding.tvReports.setTextColor(Color.parseColor("#000000"));
        binding.tvSettings.setTextColor(Color.parseColor("#000000"));*/
    }

    void settings_Inactive() {
        binding.ivSettings.setImageResource(R.drawable.ic_setting);
        binding.ivSettings.setColorFilter(ContextCompat.getColor(this, R.color.colorgrey_1), android.graphics.PorterDuff.Mode.SRC_IN);
        binding.tvSettings.setTextColor(Color.parseColor("#CDCDCD"));
    }
}