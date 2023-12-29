package com.saidur.own.amarbari.Network;


import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Api {
 /*   @Headers({"Accept: application/json"})*/
    @POST("Api/Login/Mobile")
    Call<Rp_Login> Login(@Body Map<String,String> body);
    //Call<Rp_Login> Login(@Query("mobile") String mobile, @Query("password") String password, @Query("type") int type);

    @POST("Api/Tenant/Create_Form_Post_Mobile")
    Call<Rp_Registration> Registration(@Body HashMap<String,String> map);

    /*   @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("api/user_login.php")
    Call<ResponseLogin> callLogin(@Body HashMap<String,String> body);

    @POST("api/attendance_api.php")
    Call<ResponseLogin> callAttendance(@Body ReqAttendance body);
    @POST("api/check_attendance_api.php")
    Call<ResponseLogin> chkAtten(@Body HashMap<String,String> body);
    @POST("api/getAttedance_by.php")
    Call<Response_Attendance_Report> getAttenReport(@Body HashMap<String,String> body);


    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("api/getAllProduct_byBooth.php")
    Call<ResponseProduct> getProduct(@Body HashMap<String,String> body);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("api/sales_api.php")
    Call<ResponseLogin> placeOrder(@Body ReqSales body);

    @POST("api/stock_api.php")
    Call<ResponseLogin> placeStock(@Body List<ModelStockPosting> body);

    @GET("api/getAllIngredient.php")
    Call<ResponseIngredient> getIngredients();


    @POST("api/getCurrentStock_byBooth.php")
    Call<ResponseCurrStock> getCurrentStock(@Body HashMap<String,String> body);
    @POST("api/getCurrentStock_byBooth.php")
    Call<ResponseCurrStock> getRCVStock(@Body HashMap<String,String> body);
*/





}
