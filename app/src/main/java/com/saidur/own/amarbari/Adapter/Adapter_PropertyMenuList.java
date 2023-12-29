package com.saidur.own.amarbari.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.saidur.own.amarbari.Model.ModelMenuProperty;
import com.saidur.own.amarbari.Model.ModelTenant;
import com.saidur.own.amarbari.R;

import java.util.List;

public class Adapter_PropertyMenuList extends BaseAdapter {
    private Context context;
    private final static int FADE_DURATION = 500; //FADE_DURATION in milliseconds
    private List<ModelMenuProperty> aList;
    LayoutInflater inflater;

    public Adapter_PropertyMenuList(Context context, List<ModelMenuProperty> aList) {
        this.context = context;
        this.aList = aList;
    }


    @Override
    public int getCount() {
        if (aList != null) {
            return aList.size();
            //return aProductList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.component_property_menu, parent, false);
        }
        ModelMenuProperty menu = aList.get(pos);

        ImageView icon = view.findViewById(R.id.iv_icon);
        TextView name = view.findViewById(R.id.tv_menuName);
        TextView count = view.findViewById(R.id.tv_house_count);
        TextView tv_desc = view.findViewById(R.id.tv_desc);


        Glide.with(context).load(menu.getIcon())
                .into(icon);

        name.setText(menu.getName());
        count.setText(menu.getCount());
        tv_desc.setText(menu.getDesc());
        return view;
    }

}
