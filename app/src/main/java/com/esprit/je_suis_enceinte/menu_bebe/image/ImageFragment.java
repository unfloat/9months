package com.esprit.je_suis_enceinte.menu_bebe.image;

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
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois1bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois2bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois3bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois4bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois5bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois6bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois7bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois8bebeFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.fragments.mois9bebeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ImageFragment extends Fragment {

    private View thisview;
    ViewPager viewPager;


    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisview = inflater.inflate(R.layout.fragment_image, container, false);
        return thisview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpagerimage);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.sliding_tabsimage);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new mois1bebeFragment(), "1 MOIS");
        adapter.addFrag(new mois2bebeFragment(), "2 MOIS");
        adapter.addFrag(new mois3bebeFragment(), "3 MOIS");
        adapter.addFrag(new mois4bebeFragment(), "4 MOIS");
        adapter.addFrag(new mois5bebeFragment(), "5 MOIS");
        adapter.addFrag(new mois6bebeFragment(), "6 MOIS");
        adapter.addFrag(new mois7bebeFragment(), "7 MOIS");
        adapter.addFrag(new mois8bebeFragment(), "8 MOIS");
        adapter.addFrag(new mois9bebeFragment(), "9 MOIS");

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


