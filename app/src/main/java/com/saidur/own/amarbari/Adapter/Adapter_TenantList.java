package com.saidur.own.amarbari.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.saidur.own.amarbari.Model.ModelTenant;
import com.saidur.own.amarbari.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_TenantList extends RecyclerView.Adapter<Adapter_TenantList.VH> {
    private Context context;
    private final static int FADE_DURATION = 500; //FADE_DURATION in milliseconds
    private List<ModelTenant> aList;


    public Adapter_TenantList(Context context, List<ModelTenant> aList) {
        this.context = context;
        this.aList = aList;
    }


    @Override
    public Adapter_TenantList.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_tanent, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_TenantList.VH holder, int position) {
        if (aList != null) {
            try {
                ModelTenant tnt = aList.get(position);
                holder.tv_tanent.setText(tnt.getName());
                holder.tv_house.setText(tnt.getRentInfo().getRent_house());
                holder.tv_houseAddress.setText(tnt.getRentInfo().getRent_houseAddress());
                holder.tv_rentDate.setText(tnt.getRentInfo().getRent_date());
                holder.tv_rentAmount.setText("৳" + tnt.getRentInfo().getRent_amount());
                holder.tv_rentStatus.setText(tnt.getRentInfo().getRent_status());

               /* Glide.with(context).load(tnt.getImage())
                        .into(holder.iv_img);*/
                Glide.with(context).load(tnt.getId())
                        .into(holder.iv_img);

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
        public TextView tv_tanent, tv_house, tv_houseAddress, tv_rentDate, tv_rentAmount, tv_rentStatus;
        ImageView iv_call;
        CircleImageView iv_img;

        public VH(View view) {
            super(view);
            iv_img =(CircleImageView) view.findViewById(R.id.iv_img);
            iv_call = view.findViewById(R.id.iv_call);
            tv_tanent = view.findViewById(R.id.tv_tanent);
            tv_house = view.findViewById(R.id.tv_house);
            tv_houseAddress = view.findViewById(R.id.tv_houseAddress);
            tv_rentDate = view.findViewById(R.id.tv_rentDate);
            tv_rentAmount = view.findViewById(R.id.tv_rentAmount);
            tv_rentStatus = view.findViewById(R.id.tv_rentStatus);
        }

    }
}
