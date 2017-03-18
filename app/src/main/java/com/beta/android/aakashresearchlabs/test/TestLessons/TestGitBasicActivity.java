package com.beta.android.aakashresearchlabs.test.TestLessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.R;
import com.beta.android.aakashresearchlabs.test.TestSeries.GitBasic.l1GB;
import com.beta.android.aakashresearchlabs.test.TestSeries.GitBasic.l2GB;
import com.beta.android.aakashresearchlabs.test.customAdapters.indexAdapter;
import com.beta.android.aakashresearchlabs.test.customClasses.indexclass;

import java.util.ArrayList;


public class TestGitBasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        //changing index page heading text
        TextView hd =(TextView) findViewById(R.id.index_heading);
        hd.setText("Test Lessons");

        //get title to set label in lesson activity
        final String title = getTitle().toString();

        //set menu list adapter

        final ArrayList<indexclass> list = new ArrayList<indexclass>();

        list.add(new indexclass("Lesson 1",l1GB.class));
        list.add(new indexclass("Lesson 2",l2GB.class));

        indexAdapter adapter = new indexAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);

        //opening new activity for every item on menu list

        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                indexclass w = list.get(position);

                Intent intent = new Intent(getApplicationContext(),w.getmCls());
                intent.putExtra("lname",w.getmLessonName());
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
    }
}
