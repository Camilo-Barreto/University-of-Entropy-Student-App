package com.example.a31008527_springcoursework.viewPagerAdapters;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a31008527_springcoursework.innerFragments.FridayTimetableFragment;
import com.example.a31008527_springcoursework.innerFragments.MondayTimetableFragment;
import com.example.a31008527_springcoursework.innerFragments.ThursdayTimetableFragment;
import com.example.a31008527_springcoursework.innerFragments.TuesdayTimetableFragment;
import com.example.a31008527_springcoursework.innerFragments.WednesdayTimetableFragment;
import com.example.a31008527_springcoursework.taskbarFragments.TimetablePageFragment;

public class TimetableViewAdapter extends FragmentStateAdapter {
    public TimetableViewAdapter(@NonNull TimetablePageFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // timetable fragments for 5 days
        switch (position) {
            case 0:
                return new MondayTimetableFragment();
            case 1:
                return new TuesdayTimetableFragment();
            case 2:
                return new WednesdayTimetableFragment();
            case 3:
                return new ThursdayTimetableFragment();
            case 4:
                return new FridayTimetableFragment();
            default:
                return new MondayTimetableFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
