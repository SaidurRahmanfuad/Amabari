package com.saidur.own.amarbari.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBMain extends SQLiteOpenHelper {
    private  static  final  String DATABASE_NAME = "amarbariDB.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    public DBMain(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String tblSession = "Create Table if not exists tblSession" +
                "(empid Integer,name varchar(500),mobile varchar(500),ide varchar(500),role Integer,created_at varchar(500),updated_at varchar(500))";

        String tblProfile = "Create Table if not exists tblProfile" +
                "(empid Integer,name varchar(500),mobile varchar(500),address varchar(500),ide varchar(500),nid varchar(500),image varchar(500),created_at varchar(500),updated_at varchar(500))";

        //Table Main Structure
        String tblDivision = "Create Table if not exists tblDivision (pk Integer primary key, " +
                "DivisionId Integer,DivisionName varchar(500))";
        String tblDistrict = "Create Table if not exists tblDistrict (pk Integer primary key, " +
                "DistrictId Integer,DistrictName varchar(500),DivisionId Integer)";
        String tblThana = "Create Table if not exists tblThana (pk Integer primary key, " +
                "ThanaId Integer,ThanaName varchar(500),DistrictId Integer)";
        String tblArea = "Create Table if not exists tblArea (pk Integer primary key, " +
                "AreaId Integer,AreaName varchar(500),ThanaId Integer)";


        try {
            //Market Structure Main
            sqLiteDatabase.execSQL(tblSession);
            sqLiteDatabase.execSQL(tblProfile);
            sqLiteDatabase.execSQL(tblDivision);
            sqLiteDatabase.execSQL(tblDistrict);
            sqLiteDatabase.execSQL(tblThana);
            sqLiteDatabase.execSQL(tblArea);

        } catch (Exception e) {
            Log.e("SQLiteDBHelper", e.toString());
        }


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //version 1
        try {
            db.execSQL("ALTER TABLE tblOrderMaster ADD COLUMN Remarks varchar(500)");
        } catch (Exception e) {
            e.printStackTrace();
        }
       // Toast.makeText(context, "OnUpdate", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
