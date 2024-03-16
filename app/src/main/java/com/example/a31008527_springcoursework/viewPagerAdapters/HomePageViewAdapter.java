package com.example.a31008527_springcoursework.viewPagerAdapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a31008527_springcoursework.AppHomePage;
import com.example.a31008527_springcoursework.taskbarFragments.ProfilePageFragment;
import com.example.a31008527_springcoursework.taskbarFragments.TimetablePageFragment;
import com.example.a31008527_springcoursework.taskbarFragments.HomePageFragment;

public class HomePageViewAdapter extends FragmentStateAdapter {
    public HomePageViewAdapter(@NonNull AppHomePage fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomePageFragment();
            case 1:
                return new TimetablePageFragment();
            case 2:
                return new HomePageFragment();
            case 3:
                return new ProfilePageFragment();
            default:
                return new HomePageFragment  ();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
