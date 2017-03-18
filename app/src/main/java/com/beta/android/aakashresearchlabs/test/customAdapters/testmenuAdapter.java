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

public class testmenuAdapter extends ArrayAdapter<wordclass> {

    public testmenuAdapter(Activity context, ArrayList<wordclass> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.index_list, parent, false);
        }

        wordclass currentWord = getItem(position);


        TextView mItem = (TextView) listItemView.findViewById(R.id.index_item);
        mItem.setText(currentWord.getmItemName());

        return listItemView;
    }

}
