package com.saidur.own.amarbari.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.saidur.own.amarbari.Model.ModelTenant;
import com.saidur.own.amarbari.Model.property.ModelProperty;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Property.ActivityPropertyDashBoard;

import java.util.List;

public class Adapter_PropertyList extends RecyclerView.Adapter<Adapter_PropertyList.VH> {
    private Activity context;
    private final static int FADE_DURATION = 500; //FADE_DURATION in milliseconds
    private List<ModelProperty> aList;


    public Adapter_PropertyList(Activity context, List<ModelProperty> aList) {
        this.context = context;
        this.aList = aList;
    }


    @Override
    public Adapter_PropertyList.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_property_list, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_PropertyList.VH holder, int position) {
        if (aList != null) {
            try {
                ModelProperty tnt = aList.get(position);
                holder.tv_tanent.setText("Tenant : " + tnt.getName());
                holder.tv_pName.setText(tnt.getName());
                holder.tv_pAddress.setText(tnt.getAddress());
                holder.tv_floor.setText("Floor : " + tnt.getFloor());
                holder.tv_unit.setText("Unit : " + tnt.getUnit());
                holder.tv_rentAmount.setText("৳" + tnt.getRent().getRent_amount());
                //  holder.tv_rentAmount.setText("Voliume : "+tnt.getVoliume());

                // holder.tv_rentStatus.setText(tnt.getRentInfo().getRent_status());

                Glide.with(context).load(tnt.getId())
                        .into(holder.iv_pImag);

                holder.item.setOnClickListener(view -> {
                    Intent ins=new Intent(context, ActivityPropertyDashBoard.class);
                    ins.putExtra("Who",tnt.getName());
                    context.startActivity(ins);
                    context.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                });

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        if (aList != null) {
            return aList.size();
            //return aProductList.size();
        }
        return 0;
    }

    public static class VH extends RecyclerView.ViewHolder {
        public TextView tv_pName, tv_tanent, tv_pAddress, tv_floor, tv_rentDate, tv_unit, tv_rentStatus, tv_rentAmount;
        ImageView iv_pImag;
        ConstraintLayout item;

        public VH(View view) {
            super(view);
            iv_pImag = view.findViewById(R.id.iv_pImag);
            tv_pName = view.findViewById(R.id.tv_pName);
            tv_tanent = view.findViewById(R.id.tv_tanent);
            tv_pAddress = view.findViewById(R.id.tv_pAddress);
            tv_floor = view.findViewById(R.id.tv_floor);
            tv_rentDate = view.findViewById(R.id.tv_rentDate);
            tv_unit = view.findViewById(R.id.tv_unit);
            tv_rentAmount = view.findViewById(R.id.tv_rentAmount);
            item = view.findViewById(R.id.item);

            //tv_rentStatus = view.findViewById(R.id.tv_rentStatus);
        }

    }
}
