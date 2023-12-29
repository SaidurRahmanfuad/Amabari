package com.saidur.own.amarbari.UI.Property;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.saidur.own.amarbari.Network.Request.RQ_House_Save;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.databinding.BottomSheetHouseBinding;


public class BottomSheetDialogProperty extends BottomSheetDialogFragment implements View.OnClickListener {
    BottomSheetHouseBinding binding;
    String type = "";
    BottomSheetDialogProperty.BottomSheetListener mListener;
    public static final String TAG = "ActionBottomDialog";
    //ModelSession session;
    //DBCommonHelper dbCommonHelper;

    public static BottomSheetDialogProperty newInstance() {
        return new BottomSheetDialogProperty();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new BottomSheetDialog(getContext(), R.style.MyTransparentBottomSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetHouseBinding.inflate(getLayoutInflater());
        //dbCommonHelper=new DBCommonHelper(requireActivity());
        //session=dbCommonHelper.getSession();

       // binding.etReciptName.setText(session.getName());

       /* Bundle mArgs = getArguments();
        int empId = mArgs.getInt("empId");
        int monthValue = mArgs.getInt("monthValue");
        int year = mArgs.getInt("year");
        int tourCount = mArgs.getInt("visitCount");
        String monStr = mArgs.getString("monthTxt");*/

        //binding.typeHome.setOnClickListener(this);
        //binding.typeHotel.setOnClickListener(this);
        //binding.typeWork.setOnClickListener(this);
        //binding.typeOther.setOnClickListener(this);
        binding.btnSave.setOnClickListener(this);
        binding.btnClose.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
          /*  case R.id.typeHome:
                type = "1";
                binding.typeHome.setBackgroundResource(R.drawable.shape_rect_yellowdeep);

                binding.typeHotel.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeWork.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeOther.setBackgroundResource(R.drawable.shape_rect_ashborder);
                break;
            case R.id.typeHotel:
                type = "2";
                binding.typeHotel.setBackgroundResource(R.drawable.shape_rect_yellowdeep);
                binding.typeHome.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeWork.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeOther.setBackgroundResource(R.drawable.shape_rect_ashborder);
                break;
            case R.id.typeWork:
                type = "3";
                binding.typeWork.setBackgroundResource(R.drawable.shape_rect_yellowdeep);
                binding.typeHome.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeHotel.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeOther.setBackgroundResource(R.drawable.shape_rect_ashborder);
                break;
            case R.id.typeOther:
                type = "4";
                binding.typeOther.setBackgroundResource(R.drawable.shape_rect_yellowdeep);
                binding.typeHome.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeHotel.setBackgroundResource(R.drawable.shape_rect_ashborder);
                binding.typeWork.setBackgroundResource(R.drawable.shape_rect_ashborder);
                break;*/
            case R.id.btn_save:
                String hName = binding.etHouseName.getText().toString().trim();
                String houseAddress = binding.etHouseAddress.getText().toString().trim();
                String floor = binding.etFloor.getText().toString().trim();
                String unit = binding.etUnit.getText().toString().trim();
                String unit_floor = binding.etPrfix.getText().toString().trim();
                String room = binding.etRoom.getText().toString().trim();
                String toilet = binding.etToilet.getText().toString().trim();
                String belcony = binding.etBalcony.getText().toString().trim();
                String rent = binding.etRent.getText().toString().trim();
                String location = binding.etLocation.getText().toString().trim();
                //String housedetails = binding.etHouseDetails.getText().toString().trim();

                boolean isName = true;
                boolean isAddress = true;
                boolean isFloor = true;
                boolean isUnit = true;
                boolean isUnitPer = true;
                boolean isRent = true;
                if (TextUtils.isEmpty(hName)) {
                    binding.etHouseName.setError("Required");
                    isName = false;
                    return;
                }
                if (TextUtils.isEmpty(houseAddress)) {
                    binding.etHouseAddress.setError("Required");
                    isAddress = false;
                    return;
                }
                if (TextUtils.isEmpty(floor)) {
                    binding.etFloor.setError("Required");
                    isFloor = false;
                    return;
                }
                if (TextUtils.isEmpty(unit)) {
                    binding.etUnit.setError("Required");
                    isUnit = false;
                    return;
                }
                if (TextUtils.isEmpty(unit_floor)) {
                    binding.etPrfix.setError("Required");
                    isUnitPer = false;
                    return;
                }
                if (TextUtils.isEmpty(rent)) {
                    binding.etRent.setError("Required");
                    isRent = false;
                    return;
                }

                if (isName && isAddress && isFloor && isUnit && isUnitPer && isRent) {
                    RQ_House_Save rq = new RQ_House_Save();
                    rq.setName(hName);
                    rq.setAddress(houseAddress);
                    rq.setFloor(floor);
                    rq.setUnit(unit);
                    rq.setUnit_floo(unit_floor);
                    rq.setRent(rent);

                    rq.setRoom(unit_floor);
                    rq.setToilet(toilet);
                    rq.setBelcony(belcony);

                   // mListener.SaveHouseClick(rq);
                    dismiss();
                }

                break;
            case R.id.btn_close:
                dismiss();
                break;

        }
    }


    public interface BottomSheetListener {
        void SaveHouseClick(RQ_House_Save data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BottomSheetListener) {
            mListener = (BottomSheetListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }

    }
}



