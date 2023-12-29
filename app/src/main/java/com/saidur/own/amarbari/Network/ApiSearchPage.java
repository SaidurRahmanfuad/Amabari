package com.saidur.own.amarbari.Network;


import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;
import com.saidur.own.amarbari.Network.Response.Rp_buildings;
import com.saidur.own.amarbari.Network.Response.Rp_flats;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiSearchPage {
 /*   @Headers({"Accept: application/json"})*/
    @GET("Api/Building/TableWithFlat")
    Call<Rp_buildings> GetBuildings();
    @GET("Api/Flat/TableByBuildingID")
    Call<Rp_flats> GetFlatByBuilding(@Query("building_Id") String id);

   @GET("Api/Flat/Table")
   Call<Rp_flats> GetFlats();

    @POST("Api/Building/Table")
    Call<Rp_Login> GetShops();
    @POST("Api/Building/Table")
    Call<Rp_Login> GetCommercials();
    @POST("Api/Building/Table")
    Call<Rp_Login> GetSits();

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
