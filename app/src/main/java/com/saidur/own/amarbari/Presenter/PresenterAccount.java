package com.saidur.own.amarbari.Presenter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.saidur.own.amarbari.Interface.IAccount;
import com.saidur.own.amarbari.Network.Api;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;
import com.saidur.own.amarbari.Network.RetrofitInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterAccount implements IAccount.Presenter{
Context context;
IAccount.View view;

    public PresenterAccount(Context context, IAccount.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void hit_login(String mobile, String pass, int type) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",pass);
        map.put("type",String.valueOf(type));
        try{
            Api service = RetrofitInstance.getRetrofitInstance().create(Api.class);
            Call<Rp_Login> call = service.Login(map);
            call.enqueue(new Callback<Rp_Login>() {
                @Override
                public void onResponse(@NonNull Call<Rp_Login> call, @NonNull Response<Rp_Login> response) {
                    assert response.body() != null;
                    if(response.body().isStatus())
                    {
                       view.onLoginSuccess(response.body());
                    }else {
                        view.onError(response.body().getMassage());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Rp_Login> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage().toString());
                    view.onError("Api call Failed");
                }
            });
        }catch (Exception ex){
            System.out.println(ex.getMessage().toString());
        }
    }

    @Override
    public void hit_registration(String name,String mobile,String pass) {
        HashMap<String,String> map=new HashMap<>();
        map.put("name",name);
        map.put("mobile",mobile);
        map.put("password",pass);
        try{
            Api service = RetrofitInstance.getRetrofitInstance().create(Api.class);
            Call<Rp_Registration> call = service.Registration(map);
            call.enqueue(new Callback<Rp_Registration>() {
                @Override
                public void onResponse(@NonNull Call<Rp_Registration> call, @NonNull Response<Rp_Registration> response) {
                    if(response.body().isStatus())
                    {
                        view.onRegiSuccess(response.body());
                    }else {
                        view.onError(response.body().getMassage());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Rp_Registration> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage().toString());
                    view.onError("Api call Failed");
                }
            });
        }catch (Exception ex){
            System.out.println(ex.getMessage().toString());
        }
    }

    @Override
    public void update_profile() {
      /*  try{
            Api service = RetrofitInstance.getInterface();
            Call<Rp_Login> call = service.Login(mobile,pass,type);
            call.enqueue(new Callback<Rp_Login>() {
                @Override
                public void onResponse(@NonNull Call<Rp_Login> call, @NonNull Response<Rp_Login> response) {
                    if(response.body().isStatus())
                    {
                        view.onSuccess(response.body().getMassage());
                        view.onViewProfile(response.body().getData());
                    }else {
                        view.onError(response.body().getMassage());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Rp_Login> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage().toString());
                    view.onError("Api call Failed");
                }
            });
        }catch (Exception ex){
            System.out.println(ex.getMessage().toString());
        }*/
    }
}
