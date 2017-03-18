package com.beta.android.aakashresearchlabs.test.customAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.R;
import com.beta.android.aakashresearchlabs.test.customClasses.testclass;

import java.util.ArrayList;

public class testAdapter extends ArrayAdapter<testclass> {

    public testAdapter(Activity context, ArrayList<testclass> index) {
        super(context, 0, index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.test_list, parent, false);
        }

        testclass currentQues = getItem(position);


        TextView mq = (TextView) listItemView.findViewById(R.id.question);
        mq.setText(currentQues.getmq());

        RadioButton mc1 = (RadioButton) listItemView.findViewById(R.id.radio1);
        mc1.setText(currentQues.getmc1());

        RadioButton mc2 = (RadioButton) listItemView.findViewById(R.id.radio2);
        mc2.setText(currentQues.getmc2());

        RadioButton mc3 = (RadioButton) listItemView.findViewById(R.id.radio3);
        mc3.setText(currentQues.getmc3());

        RadioButton mc4 = (RadioButton) listItemView.findViewById(R.id.radio4);
        mc4.setText(currentQues.getmc4());

        return listItemView;
    }

}
