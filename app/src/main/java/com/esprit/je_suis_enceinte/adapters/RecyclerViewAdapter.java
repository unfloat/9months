package com.esprit.je_suis_enceinte.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.esprit.je_suis_enceinte.models.MenuModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private MenuModel[] listdata;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewAdapter(Context context, MenuModel[] values, ItemListener itemListener) {

        listdata = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ImageView imageView;
        public LinearLayout relativeLayout;
        MenuModel item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.menu_text_item);
            imageView = (ImageView) v.findViewById(R.id.icon_menu);
            relativeLayout = (LinearLayout) v.findViewById(R.id.menu_relative_layout);

        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_menu_grid, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MenuModel myListData = listdata[position];
        holder.textView.setText(myListData.getMenuText());
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(getDrawableName(mContext, myListData.getMenuDrawable())));


    }


    @Override
    public int getItemCount() {

        return listdata.length;
    }

    public interface ItemListener {
        void onItemClick(MenuModel item);
    }
    private int getDrawableName(Context ctx, String str){
        return ctx.getResources().getIdentifier(str,"drawable",ctx.getPackageName());
    }

}

