package com.saidur.own.amarbari.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.saidur.own.amarbari.Database.DBCrudHelper;
import com.saidur.own.amarbari.Interface.IAccount;
import com.saidur.own.amarbari.Model.Account.ModelProfile;
import com.saidur.own.amarbari.Model.Account.ModelSession;
import com.saidur.own.amarbari.Model.ModelCountryCode;
import com.saidur.own.amarbari.Network.Response.Rp_Login;
import com.saidur.own.amarbari.Network.Response.Rp_Registration;
import com.saidur.own.amarbari.Presenter.PresenterAccount;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Home.ActivityDash;
import com.saidur.own.amarbari.UI.Tanent_Dash.ActivityTDash;
import com.saidur.own.amarbari.databinding.ActivityAccountBinding;


import java.util.ArrayList;
import java.util.List;

public class ActivityAccount extends AppCompatActivity implements IAccount.View {
    ActivityAccountBinding binding;
    List<ModelCountryCode> cCodes = new ArrayList<>();
    String codeSelect;
    boolean isNewuser = false;
    PresenterAccount presenter;
    ProgressDialog pd;


    ModelSession session;
    DBCrudHelper dbCrudHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbCrudHelper=new DBCrudHelper(ActivityAccount.this);
        session=dbCrudHelper.getSessionUser();
        boolean islogin=dbCrudHelper.CheckDataInTable("tblSession");
        if(islogin && session.getRole()==0)
        {
            gotoDashBoard();
        }
        if(islogin && session.getRole()==1)
        {
            gotoTDashBoard();
        }


        pd=new ProgressDialog(ActivityAccount.this);
        presenter = new PresenterAccount(ActivityAccount.this, this);
        getContryCode();
        binding.spinnerCcode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                codeSelect = cCodes.get(position).getCcode();
                if (codeSelect.equals("+880") || codeSelect.equals("+91") || codeSelect.equals("+92")) {
                    binding.loginMobile.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      /*  String sourceString = getString(R.string.haveemailpassword);
        String sourceCreate = getString(R.string.singupb);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtNewuser.setText(Html.fromHtml(sourceCreate, Html.FROM_HTML_MODE_LEGACY));
            binding.txtOlduser.setText(Html.fromHtml(sourceString, Html.FROM_HTML_MODE_LEGACY));
        } else {
            binding.txtNewuser.setText(Html.fromHtml(sourceCreate));
            binding.txtOlduser.setText(Html.fromHtml(sourceString));
        }

        binding.txtOlduser.setText(HtmlCompat.fromHtml(sourceString, HtmlCompat.FROM_HTML_MODE_LEGACY));
        binding.txtNewuser.setText(Html.fromHtml(sourceCreate));*/

        fun_clicks();
    }

    private void gotoTDashBoard() {
        startActivity(new Intent(ActivityAccount.this, ActivityTDash.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    private void fun_clicks() {

   /*     binding.txtOwner.setOnClickListener(v -> {
            binding.llAll.setVisibility(View.VISIBLE);
        });

        binding.txtTenent.setOnClickListener(v -> {
            binding.llAll.setVisibility(View.GONE);
        });*/

        binding.txtOldUser.setOnClickListener(view -> {
            binding.txtOldUser.setVisibility(View.GONE);
            binding.llSignup.setVisibility(View.GONE);
            binding.llLogin.setVisibility(View.VISIBLE);
            binding.tagLogin.setVisibility(View.VISIBLE);
            binding.txtNewUser.setText("New?Create account");
            binding.txtNewUser.setGravity(Gravity.CENTER);
            binding.btnProceed.setText("Log In");
            isNewuser = false;
        });
        binding.txtNewUser.setOnClickListener(view -> {
            isNewuser = true;
            binding.txtNewUser.setVisibility(View.VISIBLE);
            binding.txtOldUser.setVisibility(View.VISIBLE);
            binding.txtNewUser.setText("Register");
            binding.txtNewUser.setGravity(Gravity.CENTER);
            binding.tagLogin.setVisibility(View.GONE);
            binding.llSignup.setVisibility(View.VISIBLE);
            binding.llLogin.setVisibility(View.GONE);
            binding.btnProceed.setText("Sign Up");

        });
        binding.btnProceed.setOnClickListener(view -> {
            if (isNewuser) {

                if (TextUtils.isEmpty(binding.regiName.getText().toString())) {
                    binding.regiName.setError("Enter Name");
                } else if (TextUtils.isEmpty(binding.regiMobile.getText().toString())) {
                    binding.regiMobile.setError("Enter Mobile Number");
                } else if (TextUtils.isEmpty(binding.regiPassword.getText().toString())) {
                    binding.regiPassword.setError("Enter Password");
                } else {
                    pd.setTitle("Creating Account");
                    pd.setMessage("Please wait..");
                    pd.show();
                    register(binding.regiName.getText().toString(),binding.regiMobile.getText().toString(),binding.regiPassword.getText().toString().trim());
                }
            } else {
                if (TextUtils.isEmpty(binding.loginMobile.getText().toString())) {
                    binding.loginMobile.setError("Enter Mobile");
                } else if (TextUtils.isEmpty(binding.loginPassword.getText().toString())) {
                    binding.loginPassword.setError("Enter Password");
                } else {
                    int type;
                    boolean isOwner = binding.checkOwner.isChecked();
                    boolean isTenant = binding.checkTenent.isChecked();
                    if (isOwner) {
                        type = 0;
                    } else if (isTenant) {
                        type = 1;
                    } else {
                        Toast.makeText(this, "Check Who you are", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String number = codeSelect+binding.loginMobile.getText().toString().trim();
                    String pass = binding.loginPassword.getText().toString().trim();
                    pd.setTitle("Login");
                    pd.setMessage("Please wait..");
                    pd.show();
                    presenter.hit_login(number,pass,type);
                }
            }
        });
        binding.txtForgotclick.setOnClickListener(view -> {
            startActivity(new Intent(ActivityAccount.this, ActivityForgot.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    private void register(String name,String mobile,String pass) {
        presenter.hit_registration(name,mobile,pass);
    }

    private void loginUser() {
       // startActivity(new Intent(ActivityAccount.this, ActivityVerifyPhone.class));
        startActivity(new Intent(ActivityAccount.this, ActivityDash.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    private void checkUser() {
        startActivity(new Intent(ActivityAccount.this, ActivityVerifyPhone.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void getContryCode() {
        cCodes.add(new ModelCountryCode("+880", "1", "BD"));
        cCodes.add(new ModelCountryCode("+91", "2", "IND"));
        cCodes.add(new ModelCountryCode("+92", "3", "PK"));
        cCodes.add(new ModelCountryCode("+27", "4", "SA"));
        cCodes.add(new ModelCountryCode("+39", "5", "IT"));

        ArrayAdapter<ModelCountryCode> cdapter = new ArrayAdapter<>(this, R.layout.component_spinner_lay, cCodes);
        binding.spinnerCcode.setAdapter(cdapter);
      /*  try {
            BaseService service = RetrofitInstance.getInterface().get(BaseService.class);
            Call<ResponseLogin> call = service.callLogin(data);
            call.enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(@NonNull Call<ResponseLogin> call, @NonNull Rp_Login<ResponseLogin> response) {
                    if (response.body().isStatus() && response.body() != null) {
                        boolean isExist=dbCrudHelper.CheckDataInTable("tblSession");
                        if(isExist)
                        {
                            boolean isDeleted=dbCrudHelper.DeleteRecordsFromTable("tblSession");
                            boolean isOk=dbCrudHelper.InsertInit();
                            if(isDeleted && isOk)
                            {
                                dbCrudHelper.InsertSessionInfo(response.body().getData());
                                view.rcv_success(response.body().getMessage(), true);
                            }
                        }else {
                            boolean isDone =dbCrudHelper.InsertInit();
                            if(isDone)
                            {
                                dbCrudHelper.InsertSessionInfo(response.body().getData());
                                view.rcv_success(response.body().getMessage(),true);
                            }

                        }

                    } else {
                        view.rcv_Error(response.body().getMessage());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<ResponseLogin> call, @NonNull Throwable t) {
                    if (t instanceof SocketTimeoutException) {
                    } else {
                    }
                }
            });

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getLocalizedMessage());
        }*/
    }

    @Override
    public void onViewProfile(ModelProfile pr) {

    }

    private void gotoDashBoard() {
        startActivity(new Intent(ActivityAccount.this, ActivityDash.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    public void onLoginSuccess(Rp_Login lo) {
        if(pd!=null || pd.isShowing())
        {
            pd.dismiss();
        }
        if(lo.isStatus())
        {
            //String name, String mobile, String ide, String updated_at, String created_at, int empid, int role

            ModelSession ss= new ModelSession(lo.getName(),lo.getMobile(),lo.getIde(),
                    lo.getUpdated_at(),lo.getCreated_at(),lo.getEmpid(),lo.getRole());
            boolean isDone=dbCrudHelper.SaveSession(ss);
            if(isDone && session.getRole()==0)
            {
                    gotoDashBoard();
            }
            if(isDone && session.getRole()==1)
            {
                gotoTDashBoard();
            }

        }else {
            new androidx.appcompat.app.AlertDialog.Builder(ActivityAccount.this)
                    .setTitle("Error")
                    .setMessage(lo.getMassage())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            //finish();
                        }

                    }).setCancelable(false).show();
        }
    }

    @Override
    public void onRegiSuccess(Rp_Registration re) {
        if(pd!=null || pd.isShowing())
        {
            pd.dismiss();
        }

        ModelSession ss= new ModelSession(re.getData().getName(),re.getData().getMobile(),re.getData().getTenant_Id(),
                re.getData().getUpdated_at(), re.getData().getCreated_at(),re.getData().getId(),re.getRole());
        boolean isDone=dbCrudHelper.SaveSession(ss);
        if(isDone)
        {
            boolean isProfile=dbCrudHelper.SaveProfile(re.getData());
            if(isProfile)
            {
                gotoTDashBoard();
            }
        }
    }

    @Override
    public void onSuccess(String message) {
    /*    if(pd!=null || pd.isShowing())
        {
            pd.dismiss();
        }
        if(status)
        {
            loginUser();
        }else {
            new androidx.appcompat.app.AlertDialog.Builder(ActivityAccount.this)
                    .setTitle("Error")
                    .setMessage(message)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            //finish();
                        }

                    }).setCancelable(false).show();
        }*/

    }

    @Override
    public void onSession(ModelSession message) {

    }

    @Override
    public void onError(String message) {
        if(pd!=null || pd.isShowing())
        {
            pd.dismiss();
        }
        new androidx.appcompat.app.AlertDialog.Builder(ActivityAccount.this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                       // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        //finish();
                    }

                }).setCancelable(false).show();
    }

 /*   private void chackUser() {
        custPrograssbar.prograssCreate(ActivityAccount.this);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", edMobile.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();

        }
        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<JsonObject> call = APIClient.getInterface().getCheckMobile(bodyRequest);
        GetResult getResult = new GetResult();
        getResult.setMyListener(this);
        getResult.callForLogin(call, "2");

    }

    private void loginUser() {
        custPrograssbar.prograssCreate(ActivityAccount.this);
        RQ_Login rq = new RQ_Login();
        try {
            rq.setMobile(binding.edMobile.getText().toString());
            rq.setPassword(binding.edPassword.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();

        }
        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<JsonObject> call = APIClient.getInterface().login(bodyRequest);
        GetResult getResult = new GetResult();
        getResult.setMyListener(this);
        getResult.callForLogin(call, "3");

    }*/
}