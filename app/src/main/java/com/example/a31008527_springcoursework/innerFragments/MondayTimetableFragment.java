package com.example.a31008527_springcoursework.innerFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.a31008527_springcoursework.R;
import com.example.a31008527_springcoursework.RecyclerviewItems.MyTimetableRecyclerAdapter;
import com.example.a31008527_springcoursework.RecyclerviewItems.itemTimetableModule;

import java.util.ArrayList;
import java.util.List;


public class MondayTimetableFragment extends Fragment {

    public MondayTimetableFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_monday_timetable, container, false);

        RecyclerView recyclerView = rootview.findViewById(R.id.monday_recyclerView);
        List<itemTimetableModule> itemTimetableModules = new ArrayList<itemTimetableModule>();

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MyTimetableRecyclerAdapter(requireContext(), itemTimetableModules));

        itemTimetableModules.add(new itemTimetableModule(getString(R.string.fundamentals_of_cs),
                "JJ Thompson Slingo Theatre", "9:00", "11:00"));
        itemTimetableModules.add(new itemTimetableModule(getString(R.string.applications_of_cs),
                    "JJ Thompson Ditchburn Theatre", "12:00", "14:00"));
        itemTimetableModules.add(new itemTimetableModule(getString(R.string.programming_in_c_c),
                "Polly Vacher G56", "16:00", "18:00"));
        itemTimetableModules.add(new itemTimetableModule(getString(R.string.fundamentals_of_cs),
                "JJ Thompson Slingo Theatre", "9:00", "11:00"));
        itemTimetableModules.add(new itemTimetableModule(getString(R.string.applications_of_cs),
                "JJ Thompson Ditchburn Theatre", "12:00", "14:00"));
        itemTimetableModules.add(new itemTimetableModule(getString(R.string.programming_in_c_c),
                "Polly Vacher G56", "16:00", "18:00"));
        return rootview;
    }
}