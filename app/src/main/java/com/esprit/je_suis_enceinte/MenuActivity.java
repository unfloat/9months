package com.esprit.je_suis_enceinte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.esprit.je_suis_enceinte.adapters.RecyclerViewAdapter;
import com.esprit.je_suis_enceinte.display.EqualSpacingItemDecoration;
import com.esprit.je_suis_enceinte.models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity  implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    //List<MenuModel> arrayList = new ArrayList<>();

    Context context = MenuActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new EqualSpacingItemDecoration(6,  EqualSpacingItemDecoration.GRID)); // 16px. In practice, you'll want to use getDimensionPixelSize

        MenuModel[] data = new MenuModel[6];
        data[0] = new MenuModel("Calendrier","calendar");
        data[1] = new MenuModel("Echographie","ultrasound");
        data[2] = new MenuModel("Maman","mother1");
        data[3] = new MenuModel("Prenoms","diaper");
        data[4] = new MenuModel("Food","feedingbottle");
        data[5] = new MenuModel("Achats Bébé","crib");


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, data, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onItemClick(MenuModel item) {

        Toast.makeText(getApplicationContext(), item.getMenuText() +"clicked", Toast.LENGTH_SHORT).show();


    }
}
