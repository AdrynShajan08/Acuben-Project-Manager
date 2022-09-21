package com.example.projectmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class project_adapter extends ArrayAdapter<project> {

    public project_adapter(Context context, List<project> projects){
        super(context, 0, projects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        project proj = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.project_cell, parent, false);

        TextView title = convertView.findViewById(R.id.celltitle);
        TextView desc = convertView.findViewById(R.id.celldesc);
        TextView subj = convertView.findViewById(R.id.cellsub);
        TextView ddate = convertView.findViewById(R.id.cellddate);

        title.setText(proj.getTitle());
        desc.setText(proj.getDescription());
        subj.setText(proj.getSubject());
        ddate.setText(proj.getDuedate());

        return convertView;
    }
}
