package com.example.a31008527_springcoursework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.a31008527_springcoursework.viewPagerAdapters.HomePageViewAdapter;
import com.google.android.material.tabs.TabLayout;

public class AppHomePage extends AppCompatActivity {

    // Declaring components for the taskbarFragments main home page fragment
    TabLayout taskbar_main_tablayout;
    ViewPager2 homepage_main_viewpager2;
    HomePageViewAdapter homePageViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home_page);

        // MAIN HOME PAGE
        // Initialising components for main home page
        taskbar_main_tablayout = findViewById(R.id.taskbar_tablayout);
        homepage_main_viewpager2 = findViewById(R.id.viewpager);

        homePageViewAdapter = new HomePageViewAdapter(AppHomePage.this);
        homepage_main_viewpager2.setAdapter(homePageViewAdapter);
        taskbar_main_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homepage_main_viewpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Change tab layout indicator line when tab is swiped instead of being clicked
        homepage_main_viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                taskbar_main_tablayout.getTabAt(position).select();
            }
        });

    }
}