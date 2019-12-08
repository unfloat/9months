package com.esprit.je_suis_enceinte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.esprit.je_suis_enceinte.fragments.PrenomsFragment;

public class ContainerActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);



    }

    public void loadFragment(Fragment fragment) {
        /*FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHolder,fragment);
        fragmentTransaction.commit();*/
        Toast.makeText(context, "fuck", Toast.LENGTH_LONG).show();
    }
}
