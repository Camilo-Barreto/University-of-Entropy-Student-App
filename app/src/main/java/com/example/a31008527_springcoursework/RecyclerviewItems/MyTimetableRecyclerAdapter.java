package com.example.a31008527_springcoursework.RecyclerviewItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a31008527_springcoursework.R;

import java.util.List;

public class MyTimetableRecyclerAdapter extends RecyclerView.Adapter<TimetableViewHolder> {

    private Context context;
    private List<itemTimetableModule> timetableItems;

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
        if (timetableItems != null && position < timetableItems.size()) {
            itemTimetableModule item = timetableItems.get(position);
            holder.moduleName_txtv.setText(item.getModule());
            holder.location_txtv.setText(item.getLocation());
            holder.moduleTime_txtv.setText(item.getStartEndTime());
        }
    }

    @Override
    public int getItemCount() {
        return timetableItems != null ? timetableItems.size() : 0;
    }
}
