package com.esprit.je_suis_enceinte.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.models.PrenomsModel;

public class RecyclerViewListPrenomsAdapter extends RecyclerView.Adapter<RecyclerViewListPrenomsAdapter.ViewHolder>{
    private PrenomsModel[] listdata;
    private Context context;
    //private AppDataBase database;


    // RecyclerView recyclerView;
    public RecyclerViewListPrenomsAdapter(PrenomsModel[] listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_list_prenoms, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        //database = AppDataBase.getAppDatabase(context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final PrenomsModel myListData = listdata[position];
        holder.prenom_text.setText(listdata[position].getPrenom());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               /* Intent i = new Intent(context, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("match", listdata[position]);
                i.putExtras(bundle);
                context.startActivity(i);*/
            }
        });

    }

    private int getDrawableName(Context ctx, String str){
        return ctx.getResources().getIdentifier(str,"drawable",ctx.getPackageName());
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView prenom_text;
        public Button prenom_favoris_button;

        public RelativeLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            prenom_text = (TextView) itemView.findViewById(R.id.prenom_text);
            prenom_favoris_button = (Button) itemView.findViewById(R.id.prenom_favoris_button);
            layout = (RelativeLayout)itemView.findViewById(R.id.item_prenom_layout);

        }
    }


}