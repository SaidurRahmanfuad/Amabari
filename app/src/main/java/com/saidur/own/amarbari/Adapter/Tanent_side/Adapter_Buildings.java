package com.saidur.own.amarbari.Adapter.Tanent_side;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;
import com.saidur.own.amarbari.Model.property.ModelProperty;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Property.ActivityPropertyDashBoard;
import com.saidur.own.amarbari.UI.Tanent_Dash.Pages.ActivityProperties;
import com.saidur.own.amarbari.Utils.Consts;
import com.saidur.own.amarbari.databinding.ActivityBuildingsBinding;

import java.util.List;

public class Adapter_Buildings extends RecyclerView.Adapter<Adapter_Buildings.VH> {
    private Activity context;
    private final static int FADE_DURATION = 500; //FADE_DURATION in milliseconds
    private List<ModelBuildings> aList;
    String from;

    public Adapter_Buildings(Activity context, List<ModelBuildings> aList,String from) {
        this.context = context;
        this.aList = aList;
        this.from = from;
    }


    @Override
    public Adapter_Buildings.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_buildings, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Buildings.VH holder, int position) {
        if (aList != null) {
            try {
                ModelBuildings bld = aList.get(position);
                holder.tv_bName.setText(bld.getName());
                holder.tv_bName.setSelected(true);

                holder.tv_bAddress.setText(bld.getAddress());
                holder.tv_bAddress.setSelected(true);
                if(TextUtils.isEmpty(bld.getFacilities()))
                {
                    holder.tv_facilities.setText("Nothing extras");
                }else {
                    holder.tv_facilities.setText(bld.getFacilities());
                }
                holder.tv_flats.setText("Available Flats : "+bld.getFlats_count());
                holder.tv_rentAmount.setText("৳ "+bld.getPrice_range());
             /*   Glide.with(context).load(bld.getId())
                        .into(holder.iv_pImag);*/

                holder.item.setOnClickListener(view -> {
                    Consts.Who="Building_Adapter";
                    Intent ins=new Intent(context, ActivityProperties.class);
                    ins.putExtra("Bid",bld.getBuilding_Id());
                    ins.putExtra("Id",bld.getId());
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
            if(from.equals("Main"))
            {
                return 4;
            }else {
                return aList.size();
            }

            //return aProductList.size();
        }
        return 0;
    }

    public static class VH extends RecyclerView.ViewHolder {
        public TextView tv_facilities,tv_bName, tv_bAddress, tv_floor, tv_flats, tv_rentStatus, tv_rentAmount;
        ImageView iv_pImag;
        CardView item;

        public VH(View view) {
            super(view);
            iv_pImag = view.findViewById(R.id.iv_pImag);
            tv_bName = view.findViewById(R.id.tv_bName);
            tv_bAddress = view.findViewById(R.id.tv_bAddress);
            tv_facilities = view.findViewById(R.id.tv_facilities);

            tv_floor = view.findViewById(R.id.tv_floor);
            tv_flats = view.findViewById(R.id.tv_flats);
            tv_rentAmount = view.findViewById(R.id.tv_rentAmount);
            item = view.findViewById(R.id.item);

            //tv_rentStatus = view.findViewById(R.id.tv_rentStatus);
        }

    }
}
