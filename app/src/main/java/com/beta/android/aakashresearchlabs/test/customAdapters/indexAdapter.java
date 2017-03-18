package com.beta.android.aakashresearchlabs.test.customAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.R;
import com.beta.android.aakashresearchlabs.test.customClasses.indexclass;

import java.util.ArrayList;

public class indexAdapter extends ArrayAdapter<indexclass> {

    public indexAdapter(Activity context, ArrayList<indexclass> index) {
        super(context, 0, index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.index_list, parent, false);
        }

        indexclass currentWord = getItem(position);


        TextView mtxt = (TextView) listItemView.findViewById(R.id.index_item);
        mtxt.setText(currentWord.getmLessonName());

        return listItemView;
    }

}
