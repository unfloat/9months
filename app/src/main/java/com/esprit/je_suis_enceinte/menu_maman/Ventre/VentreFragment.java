package com.esprit.je_suis_enceinte.menu_maman.Ventre;

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
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois1Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois2Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois3Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois4Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois5Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois6Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois7Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois8Fragment;
import com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments.mois9Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class VentreFragment extends Fragment {

    private View thisView;
    ViewPager viewPager;


    public VentreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        thisView = inflater.inflate(R.layout.fragment_ventre, container, false);
        return thisView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpagerventre);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new mois1Fragment(), "1 MOIS");
        adapter.addFrag(new mois2Fragment(), "2 MOIS");
        adapter.addFrag(new mois3Fragment(), "3 MOIS");
        adapter.addFrag(new mois4Fragment(), "4 MOIS");
        adapter.addFrag(new mois5Fragment(), "5 MOIS");
        adapter.addFrag(new mois6Fragment(), "6 MOIS");
        adapter.addFrag(new mois7Fragment(), "7 MOIS");
        adapter.addFrag(new mois8Fragment(), "8 MOIS");
        adapter.addFrag(new mois9Fragment(), "9 MOIS");
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
