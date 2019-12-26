package com.esprit.je_suis_enceinte.menu_bebe.taille;

import android.content.Context;
import android.net.Uri;
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
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille1Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille2Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille3Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille4Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille5Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille6Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille7Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille8Fragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.fragment.taille9Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class TailleFragment extends Fragment {

    private View thisView;
    ViewPager viewPager;
    public TailleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisView = inflater.inflate(R.layout.fragment_taille, container, false);
        return thisView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpagertaille);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.sliding_tabstaille);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new taille1Fragment(), "1 MOIS");
        adapter.addFrag(new taille2Fragment(), "2 MOIS");
        adapter.addFrag(new taille3Fragment(), "3 MOIS");
        adapter.addFrag(new taille4Fragment(), "4 MOIS");
        adapter.addFrag(new taille5Fragment(), "5 MOIS");
        adapter.addFrag(new taille6Fragment(), "6 MOIS");
        adapter.addFrag(new taille7Fragment(), "7 MOIS");
        adapter.addFrag(new taille8Fragment(), "8 MOIS");
        adapter.addFrag(new taille9Fragment(), "9 MOIS");

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