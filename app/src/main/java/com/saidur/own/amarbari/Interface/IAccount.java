package com.saidur.own.amarbari.Interface;

import com.saidur.own.amarbari.Model.Account.ModelProfile;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;

public interface IAccount {
    interface Presenter{
        void hit_login(String mobile,String pass,int type);
        void hit_registration(String name,String mobile,String pass);
        void update_profile();
    }
    interface View{
        void onViewProfile(ModelProfile profile);
        void onLoginSuccess(Rp_Login logindata);
        void onRegiSuccess(Rp_Registration logindata);
        void onSuccess(String message);
        void onSession(ModelSession message);
        void onError(String message);
    }
}
