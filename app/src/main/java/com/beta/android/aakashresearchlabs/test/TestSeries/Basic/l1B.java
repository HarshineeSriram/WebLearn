package com.beta.android.aakashresearchlabs.test.TestSeries.Basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.R;
import com.beta.android.aakashresearchlabs.test.customAdapters.testAdapter;
import com.beta.android.aakashresearchlabs.test.customClasses.testclass;

import java.util.ArrayList;

public class l1B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        //retrieving intent data
        Intent gi = getIntent();
        String lname = gi.getStringExtra("lname");
        String title = gi.getStringExtra("title");

        //setting activity label
        setTitle(title);

        //setting test lesson name
        TextView textView_Lname = (TextView) findViewById(R.id.lesson_number);
        textView_Lname.setText(lname);

        //test question adapter
        ArrayList<testclass> list = new ArrayList<testclass>();
        list.add(new testclass("Question number 1","option one","option two","option three","option four"));
        list.add(new testclass("Question number 2","option one","option two","option three","option four"));
        list.add(new testclass("Question number 3","option one","option two","option three","option four"));
        list.add(new testclass("Question number 4","option one","option two","option three","option four"));

        testAdapter adapter = new testAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.test_section);
        section.setAdapter(adapter);

    }

}