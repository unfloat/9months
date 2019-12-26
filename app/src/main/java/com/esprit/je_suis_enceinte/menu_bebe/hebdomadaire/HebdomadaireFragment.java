package com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo1Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo2Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo3Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo4Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo5Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo6Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo7Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo8Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments.hebdo9Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class HebdomadaireFragment extends Fragment {
    private View thisview;
    ViewPager viewPager;

    public HebdomadaireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisview = inflater.inflate(R.layout.fragment_hebdomadaire, container, false);
        return thisview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpagerhebdo);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.sliding_tabshebdo);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new hebdo1Fragment(), "1 MOIS");
        adapter.addFrag(new hebdo2Fragment(), "2 MOIS");
        adapter.addFrag(new hebdo3Fragment(), "3 MOIS");
        adapter.addFrag(new hebdo4Fragment(), "4 MOIS");
        adapter.addFrag(new hebdo5Fragment(), "5 MOIS");
        adapter.addFrag(new hebdo6Fragment(), "6 MOIS");
        adapter.addFrag(new hebdo7Fragment(), "7 MOIS");
        adapter.addFrag(new hebdo8Fragment(), "8 MOIS");
        adapter.addFrag(new hebdo9Fragment(), "9 MOIS");


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}