package com.example.a31008527_springcoursework.RecyclerviewItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a31008527_springcoursework.R;

import java.util.List;

public class MyTimetableRecyclerAdapter extends RecyclerView.Adapter<TimetableViewHolder> {

    Context context;
    List<itemTimetableModule> timetableItems;

    public MyTimetableRecyclerAdapter(Context context, List<itemTimetableModule> timetableItems) {
        this.context = context;
        this.timetableItems = timetableItems;
    }
    @NonNull
    @Override
    public TimetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimetableViewHolder(LayoutInflater.from(context).inflate(R.layout.item_timetable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TimetableViewHolder holder, int position) {
        holder.moduleName_txtv.setText(timetableItems.get(position).getModule());
        holder.location_txtv.setText(timetableItems.get(position).getLocation());
        holder.moduleTime_txtv.setText(timetableItems.get(position).getStartEndTime());
    }

    @Override
    public int getItemCount() {
        return timetableItems.size();
    }
}
