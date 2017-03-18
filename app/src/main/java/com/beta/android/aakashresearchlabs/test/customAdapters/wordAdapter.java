package com.beta.android.aakashresearchlabs.test.customAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.R;
import com.beta.android.aakashresearchlabs.test.customClasses.wordclass;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<wordclass> {

    public wordAdapter(Activity context, ArrayList<wordclass> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        wordclass currentWord = getItem(position);


        TextView mItem = (TextView) listItemView.findViewById(R.id.item);
        mItem.setText(currentWord.getmItemName());

        TextView bgcolor = (TextView) listItemView.findViewById(R.id.item);
        bgcolor.setBackgroundResource(currentWord.getmBg());


        return listItemView;
    }

}
