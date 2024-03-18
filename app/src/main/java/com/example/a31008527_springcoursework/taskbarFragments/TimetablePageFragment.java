package com.example.a31008527_springcoursework.taskbarFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a31008527_springcoursework.AppHomePage;
import com.example.a31008527_springcoursework.R;
import com.example.a31008527_springcoursework.viewPagerAdapters.HomePageViewAdapter;
import com.example.a31008527_springcoursework.viewPagerAdapters.TimetableViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TimetablePageFragment extends Fragment {

    // Declaring components for the timetables 5 fragments
    TabLayout days_tablayout;
    ViewPager2 timetable_main_viewpager2;
    TimetableViewAdapter timetableViewAdapter;
    public TimetablePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_timetable_page, container, false);

        // Timetable HOME PAGE
        // Initialize TabLayout and ViewPager2
        days_tablayout = rootView.findViewById(R.id.days_tablayout);
        timetable_main_viewpager2 = rootView.findViewById(R.id.viewpager);
        timetableViewAdapter = new TimetableViewAdapter(TimetablePageFragment.this);

        // Set the adapter to the ViewPager2
        timetable_main_viewpager2.setAdapter(timetableViewAdapter);

        days_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                timetable_main_viewpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Change tab layout indicator line when tab is swiped instead of being clicked
        timetable_main_viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                days_tablayout.getTabAt(position).select();
            }
        });
        return rootView;
    }
}