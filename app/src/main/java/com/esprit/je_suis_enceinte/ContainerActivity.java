package com.esprit.je_suis_enceinte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.esprit.je_suis_enceinte.fragments.PrenomsFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        //String fragment = bundle.get("activity").toString();
        loadFragment(new PrenomsFragment(ContainerActivity.this));

    }

    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHolder,fragment);
        fragmentTransaction.commit();
    }
}
