package com.example.a31008527_springcoursework.RecyclerviewItems;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a31008527_springcoursework.R;


public class TimetableViewHolder extends RecyclerView.ViewHolder {

    TextView moduleName_txtv, location_txtv, moduleTime_txtv;
    public TimetableViewHolder(@NonNull View itemView) {
        super(itemView);

        moduleName_txtv = itemView.findViewById(R.id.module_name_txt);
        location_txtv = itemView.findViewById(R.id.module_location_txt);
        moduleTime_txtv = itemView.findViewById(R.id.module_time_txt);
    }
}
