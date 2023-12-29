package com.saidur.own.amarbari.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;


import com.saidur.own.amarbari.Model.Account.ModelProfile;
import com.saidur.own.amarbari.Model.Account.ModelSession;

import java.util.ArrayList;
import java.util.List;

public class DBCrudHelper {
    DBMain dbHelperMain;
    Context context;

    public DBCrudHelper(Context context) {
        this.context = context;
        dbHelperMain = new DBMain(context);
    }


    @SuppressLint("Range")
    public boolean DeleteOrderMasterDetail(int orderId) {
        boolean isSuc = true;
        try {
            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            String query = "delete from tblOrderMaster where OrderIdLocal=" + orderId + "";
            String query2 = "delete from tblOrderDetails where OrderIdLocal=" + orderId + "";
            database.execSQL(query);
            database.execSQL(query2);
            isSuc = true;
        } catch (Exception ex) {
            isSuc = false;
            Log.e("Delete", ex.toString());
        }
        return isSuc;
    }

    public boolean UpdateOrderSynchInfo(int orderId) {
        boolean isSuc = true;
        try {
            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            String query = "update tblOrderMaster set Status='synced' where OrderIdLocal=" + orderId + "";
            database.execSQL(query);
            isSuc = true;
        } catch (Exception ex) {
            isSuc = false;
            Log.e("sync", ex.toString());
        }
        return isSuc;
    }

    public void _deleteAllRecordsFromaTable(String tableName) {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        try {
            String query = "delete from '" + tableName + "';";
            database.execSQL(query);

        } catch (Exception ex) {
            Log.e("recordDelError", ex.toString());
        }
    }

    public boolean _deleteAllRecordsFromaTableBolean(String tableName) {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        try {
            String query = "delete from '" + tableName + "';";
            database.execSQL(query);

        } catch (Exception ex) {
            Log.e("recordDelError", ex.toString());
        }
        return true;
    }




    @SuppressLint("Range")
    public boolean SaveSession(ModelSession se) {
        try {
            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            String insertpQuery = "Insert into tblSession(empid,name,mobile,ide,role,created_at,updated_at) " +
                    "values('" + se.getEmpid() + "','" + se.getName() + "','" + se.getMobile() + "','" + se.getIde() + "','" + se.getRole() + "','" + se.getCreated_at() + "','" + se.getUpdated_at() + "')";
            database.execSQL(insertpQuery);
            database.close();
            return true;
        } catch (Exception exception) {
            Log.e("EX", exception.toString());
            return false;
        }

    }
    @SuppressLint("Range")
    public boolean SaveProfile(ModelProfile se) {
        try {

            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            String insertpQuery = "Insert into tblProfile(empid,name,mobile,address,ide,nid,image,created_at,updated_at) " +
                    "values('" + se.getId() + "','" + se.getName() + "','" + se.getMobile() + "','" + "" + "','" + se.getTenant_Id() + "','" + "" + "','" + "" + "','" + se.getCreated_at() + "','" + se.getUpdated_at() + "')";
            database.execSQL(insertpQuery);
            database.close();
            return true;
        } catch (Exception exception) {
            Log.e("EX", exception.toString());
            return false;
        }

    }
    @SuppressLint("Range")
    public boolean UpdateProfile(ModelProfile aPres) {
        try {
            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            Cursor c1 = database.rawQuery("SELECT * FROM tblProfile", null);
            if (c1.getCount() > 0) {
                while (c1.moveToNext()) {
                    ContentValues cv = new ContentValues();
                    if (!aPres.getNid().isEmpty()) {
                        cv.put("nid", aPres.getNid());
                        cv.put("name", aPres.getName());
                        cv.put("created_at", aPres.getCreated_at());
                        cv.put("updated_at", aPres.getUpdated_at());
                        database.update("tblProfile", cv, "id = " + aPres.getId(), null);
                    }

                }
            }
            database.close();
            return true;
        } catch (Exception exception) {
            Log.e("EX", exception.toString());
            return false;
        }
    }

  /*  @SuppressLint("Range")
    public boolean UpdateProfile(ModelProfile se) {
        try {
            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            int dcrId = 0;
            Cursor c1 = database.rawQuery("SELECT * FROM tblDcrInfo where DcrId order by  DcrId desc LIMIT 1", null);
            if (c1.getCount() > 0) {
                while (c1.moveToNext()) {
                    dcrId = c1.getInt(c1.getColumnIndex("DcrId"));
                }
            }

            int ProductId = 0;
            for (int i = 0; i < aPres.getSampleList().size(); i++) {
                ProductSample aInfo = aPres.getSampleList().get(i);
                ProductId = aInfo.getProductId();
                String ProductName = aInfo.getProductName();
                int Quantity = aInfo.getQuantity();

                String insertDetal = "Insert into tblDcrSample(DcrId,ProductId,ProductName,Quantity,DoctorId) " +
                        "values('" + dcrId + "','" + ProductId + "','" + ProductName.replace("'", "''") + "','" + Quantity + "','" + aPres.getDoctorId() + "')";
                database.execSQL(insertDetal);


            }

            int BrandId = 0;
            for (int i = 0; i < aPres.getDoctorBrand().size(); i++) {
                DoctorBrand aInfo = aPres.getDoctorBrand().get(i);
                BrandId = aInfo.getBrandId();
                String BrandName = aInfo.getBrandName();

                String insertBDetal = "Insert into tblDcrBrand(DcrId,BrandId,BrandName,DoctorId) " +
                        "values('" + dcrId + "','" + BrandId + "','" + BrandName.replace("'", "''") + "','" + aPres.getDoctorId() + "')";
                database.execSQL(insertBDetal);


            }

            int GiftId = 0;
            for (int i = 0; i < aPres.getGiftList().size(); i++) {
                Gift aInfo = aPres.getGiftList().get(i);
                GiftId = aInfo.getProductId();
                String ProductName = aInfo.getProductName();
                int Quantity = aInfo.getQuantity();

                String insertGDetal = "Insert into tblDcrGift(DcrId,ProductId,ProductName,Quantity,Position,DoctorId) " +
                        "values('" + dcrId + "','" + GiftId + "','" + ProductName.replace("'", "''") + "','" + Quantity + "','" + aInfo.getPosition() + "','" + aPres.getDoctorId() + "')";
                database.execSQL(insertGDetal);


            }

            int VisitedwithId = 0;
            for (int i = 0; i < aPres.getAempList().size(); i++) {
                UserByRole aInfo = aPres.getAempList().get(i);
                VisitedwithId = aInfo.getEmpInfoId();
                String EmpName = aInfo.getEmpName();
                String EmpMasterCode = aInfo.getEmpMasterCode();
                String insertVDetal = "Insert into tblDcrVisitedwith(DcrId,EmpInfoId,EmpName,EmpMasterCode,DoctorId) " +
                        "values('" + dcrId + "','" + VisitedwithId + "','" + EmpName + "','" + EmpMasterCode + "','" + aPres.getDoctorId() + "')";
                database.execSQL(insertVDetal);
            }
            database.close();
            return true;
        } catch (Exception exception) {
            Log.e("EX", exception.toString());
            return false;
        }

    }*/

    public boolean CheckDataInTable(String tableName) {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM '" + tableName + "'", null);
        int count = cursor.getCount();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }


    @SuppressLint("Range")
    public void InsertSessionz(int userId, String userName, String EmpMasterCode, String loginName, int empId, String userCo, String EmpRole, int RoleTypeId, String RoleType, int IsApprove, int IsForward, String DesigName) {
        try {
            if (CheckIfDifferentUser(loginName)) {
                _deleteAllRecordsFromaTable("tblAttendance");
            }

            String tableName = "tblLoginProfile";
            _deleteAllRecordsFromaTable(tableName);
            SQLiteDatabase database = dbHelperMain.getWritableDatabase();
            String insertQuery = "Insert into tblLoginProfile(UserId,UserName,EmpMasterCode,LoginName,empId,UserCo,EmpRole,RoleTypeId,RoleType,IsApprove,IsForward,DesigName) " +
                    "values('" + userId + "','" + userName + "','" + EmpMasterCode + "','" + loginName + "'," +
                    "'" + empId + "','" + userCo + "','" + EmpRole + "','" + RoleTypeId + "','" + RoleType + "','" + IsApprove + "','" + IsForward + "','" + DesigName.replace("'", "''") + "')";
            database.execSQL(insertQuery);

        } catch (Exception exception) {
            Log.e("DBEX", exception.toString());
        }
    }

    @SuppressLint("Range")
    public boolean checkLoginProfileUserExist(String loginName, String password) {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM  tblLoginProfile where LoginName ='" + loginName + "' and UserCo ='" + password + "'", null);
        int count = cursor.getCount();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressLint("Range")
    public boolean CheckIfDifferentUser(String loginName) {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM  tblLoginProfile where LoginName ='" + loginName + "' ", null);
        int count = cursor.getCount();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Get Datas
    @SuppressLint("Range")
    public ModelSession getSessionUser() {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        String Query = "Select * from tblSession";
        ModelSession session=new ModelSession();


        try {
            Cursor cursor;
            cursor = database.rawQuery(Query, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    session.setEmpid(cursor.getInt(cursor.getColumnIndex("empid")));
                    session.setName(cursor.getString(cursor.getColumnIndex("name")));
                    session.setMobile(cursor.getString(cursor.getColumnIndex("mobile")));
                    session.setIde(cursor.getString(cursor.getColumnIndex("ide")));
                    session.setRole(cursor.getInt(cursor.getColumnIndex("role")));
                }
            }
            cursor.close();
        } catch (Exception exception) {
            Log.e("session", exception.toString());
            exception.printStackTrace();
        }
        return session;
    }
    @SuppressLint("Range")
    public ModelProfile getUserProfile() {
        SQLiteDatabase database = dbHelperMain.getWritableDatabase();
        String Query = "Select * from tblSession";
        ModelProfile profile=new ModelProfile();
        try {
            Cursor cursor;
            cursor = database.rawQuery(Query, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    profile.setMobile(cursor.getString(cursor.getColumnIndex("mobile")));
                    profile.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                    profile.setTenant_Id(cursor.getString(cursor.getColumnIndex("tenant_Id")));
                    profile.setNid(cursor.getString(cursor.getColumnIndex("nid")));
                    profile.setImage(cursor.getString(cursor.getColumnIndex("image")));
                    profile.setCreated_at(cursor.getString(cursor.getColumnIndex("created_at")));
                    profile.setUpdated_at(cursor.getString(cursor.getColumnIndex("updated_at")));

                }
            }
            cursor.close();
        } catch (Exception exception) {
            Log.e("session", exception.toString());
            exception.printStackTrace();
        }
        return profile;
    }


}
