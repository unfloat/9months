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
import android.widget.Toast;

import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.bd.SessionHandler;
import com.esprit.je_suis_enceinte.entities.User;
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

import org.joda.time.Interval;
import org.joda.time.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class HebdomadaireFragment extends Fragment {
    private View thisview;
    ViewPager viewPager;
    private SessionHandler session;
    int fragment ;

    public HebdomadaireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisview = inflater.inflate(R.layout.fragment_hebdomadaire, container, false);
        session = new SessionHandler(thisview.getContext());
        return thisview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpagerhebdo);
        setupViewPager(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.sliding_tabshebdo);
        tabLayout.setupWithViewPager(viewPager);

        User user = session.getUserDetails();
        try {
            fragment = fragment + getElapsedTime(user.getDateterme()) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tabLayout.setScrollX(tabLayout.getWidth());
        tabLayout.getTabAt(Math.abs(9-fragment)).select();



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

    public static int getElapsedTime(String d1) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date1=formatter.parse(d1);

        Interval interval =  new Interval( new Date().getTime(), date1.getTime());
        Period period = interval.toPeriod();

        return period.getMonths();
    }
    /*public static int nbMoiseEntreDeuxDate(String dateString1, String dateString2) throws Exception  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(dateString1);
        GregorianCalendar gc1 = new GregorianCalendar();
        gc1.setTime(date1);
        Date date2 = sdf.parse(dateString2);
        GregorianCalendar gc2 = new GregorianCalendar();
        gc2.setTime(date2);
        int gap = 0;
        gc1.add(GregorianCalendar.MONTH, 1);
        while(gc1.compareTo(gc2)<=0) {
            gap++;
            gc1.add(GregorianCalendar.MONTH, 1);
        }
        return gap;


    }*/


    /*public static int VotreMois(Date dateajourdhui, Date dateduterme){

        long diffference = dateduterme.getTime() - dateajourdhui.getTime();
        int c1Year = c1.get(Calendar.YEAR);
        int c1Month = c1.get(Calendar.MONTH);
        int c1Day = c1.get(Calendar.DAY_OF_MONTH);

        int c2Year = c2.get(Calendar.YEAR);
        int c2Month = c2.get(Calendar.MONTH);
        int c2Day = c2.get(Calendar.DAY_OF_MONTH);

        if(c1Year<c2Year){
            return true;
        }else if (c1Year>c2Year){
            return false;
        }else{
            if(c1Month>c2Month){
                return false;
            }else if(c1Month<c2Month){
                return true;
            }else{
                return c1Day<c2Day;
            }
        }
    }*/

}