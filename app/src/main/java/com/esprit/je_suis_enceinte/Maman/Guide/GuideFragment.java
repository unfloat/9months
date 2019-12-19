package com.esprit.je_suis_enceinte.Maman.Guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.esprit.je_suis_enceinte.Maman.Guide.GuideAdapter;
import com.esprit.je_suis_enceinte.R;
import com.google.android.material.tabs.TabLayout;

public class GuideFragment extends Fragment  {

    private View thisView;
    ViewPager viewPager;
    com.esprit.je_suis_enceinte.Maman.Guide.GuideAdapter GuideAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragement_guide, container, false);
        return thisView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpager);
        GuideAdapter = new GuideAdapter(getChildFragmentManager());
        viewPager.setAdapter(GuideAdapter);
        TabLayout tabLayout = view.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
