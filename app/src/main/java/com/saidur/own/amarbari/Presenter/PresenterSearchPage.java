package com.saidur.own.amarbari.Presenter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.saidur.own.amarbari.Interface.ISearchPage;
import com.saidur.own.amarbari.Network.ApiSearchPage;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_buildings;
import com.saidur.own.amarbari.Network.Response.Rp_flats;
import com.saidur.own.amarbari.Network.RetrofitInstance;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterSearchPage implements ISearchPage.Presenter {
    Context context;
    ISearchPage.View view;

    public PresenterSearchPage(Context context, ISearchPage.View view) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void get_buildings() {
        try {
            ApiSearchPage service = RetrofitInstance.getRetrofitInstance().create(ApiSearchPage.class);
            Call<Rp_buildings> call = service.GetBuildings();
            call.enqueue(new Callback<Rp_buildings>() {
                @Override
                public void onResponse(@NonNull Call<Rp_buildings> call, @NonNull Response<Rp_buildings> response) {
                    if (response.body().isStatus()) {
                        view.onViewBuildings(response.body().getData());
                    } else {
                        view.onDataNotFound(response.body().getMassage());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Rp_buildings> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage().toString());
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        }
    }

    @Override
    public void get_commercial() {
       /* try{
            ApiSearchPage service = RetrofitInstance.getRetrofitInstance().create(ApiSearchPage.class);
            Call<Rp_Login> call = service.GetCommercials();
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
        }*/
    }

    @Override
    public void get_sits() {
       /* try{
            ApiSearchPage service = RetrofitInstance.getRetrofitInstance().create(ApiSearchPage.class);
            Call<Rp_Login> call = service.GetSits();
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
        }*/
    }

    @Override
    public void get_shops() {
       /* try{
            ApiSearchPage service = RetrofitInstance.getRetrofitInstance().create(ApiSearchPage.class);
            Call<Rp_Login> call = service.GetShops();
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
        }*/
    }

    @Override
    public void get_flats() {
        try{
            ApiSearchPage service = RetrofitInstance.getRetrofitInstance().create(ApiSearchPage.class);
            Call<Rp_flats> call = service.GetFlats();
            call.enqueue(new Callback<Rp_flats>() {
                @Override
                public void onResponse(@NonNull Call<Rp_flats> call, @NonNull Response<Rp_flats> response) {
                    if(response.body().isStatus())
                    {
                        if(response.body().getData()!=null)
                        {
                            view.onViewFlats(response.body().getData());
                        }

                    }

                }

                @Override
                public void onFailure(@NonNull Call<Rp_flats> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage().toString());
                }
            });
        }catch (Exception ex){
            System.out.println(ex.getMessage().toString());
        }
    }


    @Override
    public void get_flatsBy_building(String buildingId) {
   try{
            ApiSearchPage service = RetrofitInstance.getRetrofitInstance().create(ApiSearchPage.class);
            Call<Rp_flats> call = service.GetFlatByBuilding(buildingId);
            call.enqueue(new Callback<Rp_flats>() {
                @Override
                public void onResponse(@NonNull Call<Rp_flats> call, @NonNull Response<Rp_flats> response) {
                    if(response.body().isStatus())
                    {
                        if(response.body().getData()!=null)
                        {
                            view.onViewFlats(response.body().getData());
                        }

                    }

                }

                @Override
                public void onFailure(@NonNull Call<Rp_flats> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage().toString());
                }
            });
        }catch (Exception ex){
            System.out.println(ex.getMessage().toString());
        }
    }


}
