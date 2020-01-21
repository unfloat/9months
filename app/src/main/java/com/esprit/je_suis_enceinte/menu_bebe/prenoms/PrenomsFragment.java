package com.esprit.je_suis_enceinte.menu_bebe.prenoms;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.je_suis_enceinte.R;

import com.esprit.je_suis_enceinte.menu_bebe.prenoms.adapters.RecyclerViewListPrenomsAdapter;
import com.esprit.je_suis_enceinte.menu_bebe.prenoms.models.PrenomsModel;

public class PrenomsFragment extends Fragment {

    private View view;
    private Context appContext;


    public PrenomsFragment() {
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_list_prenoms, container, false);
        RecyclerView recyclerView =  view.findViewById(R.id.recyclerViewFav);

        PrenomsModel[] data = new PrenomsModel[6];
        data[0] = new PrenomsModel(R.drawable.logomale,"Ramzi",true, true);
        data[1] = new PrenomsModel(R.drawable.logofemale,"ghofrane",true, true);
        data[2] = new PrenomsModel(R.drawable.logomale,"hamd",true, true);
        data[3] = new PrenomsModel(R.drawable.logofemale,"sonia",true, true);
        data[4] = new PrenomsModel(R.drawable.logofemale,"emna",true, true);
        data[5] = new PrenomsModel(R.drawable.logomale,"ahmed",true, true);
        RecyclerViewListPrenomsAdapter recyclerViewListPrenomsAdapter = new
                RecyclerViewListPrenomsAdapter(data,appContext);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(appContext));
        recyclerView.setAdapter(recyclerViewListPrenomsAdapter);

        return view;


    }
}
