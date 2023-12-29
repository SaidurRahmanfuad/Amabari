package com.saidur.own.amarbari.Interface;

import com.saidur.own.amarbari.Model.Account.ModelProfile;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;
import com.saidur.own.amarbari.Model.Tanent_side.ModelFlats;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;
import com.saidur.own.amarbari.Network.Response.Rp_flats;

import java.util.List;

public interface ISearchPage {
    interface Presenter{
        void get_buildings();
        void get_commercial();
        void get_sits();
        void get_shops();
        void get_flats(); //family/bachelor/sublet
        void get_flatsBy_building(String buildingId); //family/bachelor/sublet
    }
    interface View{
        void onViewBuildings(List<ModelBuildings> buildings);
        void onViewFlats(List<ModelFlats> flats);
        void onViewCommercials(Rp_Registration logindata);
        void onViewSits(String message);
        void onShops(ModelSession message);

        void onDataNotFound(String message);
    }
}
