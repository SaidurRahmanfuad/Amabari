package com.saidur.own.amarbari.Adapter.Tanent_side;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;
import com.saidur.own.amarbari.Model.Tanent_side.ModelFlats;
import com.saidur.own.amarbari.R;
import com.saidur.own.amarbari.UI.Tanent_Dash.Pages.ActivityProperties;
import com.saidur.own.amarbari.Utils.Consts;

import java.util.List;

public class Adapter_Flats extends RecyclerView.Adapter<Adapter_Flats.VH> {
    private Activity context;
    private final static int FADE_DURATION = 500; //FADE_DURATION in milliseconds
    private List<ModelFlats> aList;
    String from;

    public Adapter_Flats(Activity context, List<ModelFlats> aList, String from) {
        this.context = context;
        this.aList = aList;
        this.from = from;
    }


    @Override
    public Adapter_Flats.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_property, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Flats.VH holder, int position) {
        if (aList != null) {
            try {
                ModelFlats bld = aList.get(position);
                holder.tv_rentAmount.setText(bld.getRent_value());
                holder.tv_unit.setText("Unit: "+bld.getUnit_name());
                holder.tv_rentType.setText(bld.getRent_type());
                holder.tv_rentPackag.setText("/"+bld.getRent_package());


                if(TextUtils.isEmpty(bld.getArea()))
                {
                    holder.ll_sqr.setVisibility(View.GONE);
                }else {
                    holder.ll_sqr.setVisibility(View.VISIBLE);
                    holder.tv_sqrft.setText(bld.getArea()+"sqr.ft");
                }
                if(TextUtils.isEmpty(bld.getWashroom()) && bld.getWashroom().equals("0"))
                {
                    holder.ll_bath.setVisibility(View.GONE);
                }else {
                    holder.ll_bath.setVisibility(View.VISIBLE);
                    holder.tv_bath.setText(bld.getWashroom());
                }
                if(TextUtils.isEmpty(bld.getBalconi()) && bld.getBalconi().equals("0"))
                {
                    holder.ll_balcony.setVisibility(View.GONE);
                }else {
                    holder.ll_balcony.setVisibility(View.VISIBLE);
                    holder.tv_balcony.setText(bld.getBalconi());
                }
                if(TextUtils.isEmpty(bld.getFloor()) && bld.getFloor().equals("0"))
                {
                    holder.ll_stair.setVisibility(View.GONE);
                }else {
                    holder.ll_stair.setVisibility(View.VISIBLE);
                    holder.tv_stairs.setText(bld.getFloor());
                }


             /*   Glide.with(context).load(bld.getId())
                        .into(holder.iv_pImag);*/

              /*  holder.item.setOnClickListener(view -> {
                    Consts.Who="Building_Adapter";
                    Intent ins=new Intent(context, ActivityProperties.class);
                    ins.putExtra("Who",bld.getBuilding_Id());
                    ins.putExtra("Id",bld.getId());
                    context.startActivity(ins);
                    context.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                });*/

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
        public TextView tv_unit,tv_rentAmount,tv_rentPackag, tv_bed, tv_sqrft, tv_bath, tv_balcony, tv_stairs,tv_rentType,tv_address;
        ImageView iv_pImag;
        CardView item;
        LinearLayout ll_bed,ll_sqr,ll_bath,ll_balcony,ll_stair;

        public VH(View view) {
            super(view);
            tv_unit = view.findViewById(R.id.tv_units);
            tv_rentAmount = view.findViewById(R.id.tv_rentAmount);
            tv_rentPackag = view.findViewById(R.id.tv_rentPackag);
            tv_bed = view.findViewById(R.id.tv_bed);
            tv_sqrft = view.findViewById(R.id.tv_sqrft);

            tv_bath = view.findViewById(R.id.tv_bath);
            tv_balcony = view.findViewById(R.id.tv_balcony);
            tv_stairs = view.findViewById(R.id.tv_stairs);
            tv_rentType = view.findViewById(R.id.tv_rentType);
            tv_address = view.findViewById(R.id.tv_address);

            ll_bed = view.findViewById(R.id.ll_bed);
            ll_sqr = view.findViewById(R.id.ll_sqr);
            ll_bath = view.findViewById(R.id.ll_bath);
            ll_balcony = view.findViewById(R.id.ll_balcony);
            ll_stair = view.findViewById(R.id.ll_stair);

            //tv_rentStatus = view.findViewById(R.id.tv_rentStatus);
        }

    }
}
