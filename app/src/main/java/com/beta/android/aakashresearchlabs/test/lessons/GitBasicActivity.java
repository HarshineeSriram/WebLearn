package com.beta.android.aakashresearchlabs.test.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.beta.android.aakashresearchlabs.test.R;
import com.beta.android.aakashresearchlabs.test.customAdapters.indexAdapter;
import com.beta.android.aakashresearchlabs.test.customClasses.indexclass;
import com.beta.android.aakashresearchlabs.test.lessonActivity;

import java.util.ArrayList;


public class GitBasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        //get title to set label in lesson activity
        final String title = getTitle().toString();

        //set menu list adapter

        final ArrayList<indexclass> list = new ArrayList<indexclass>();

        list.add(new indexclass("Lesson 1",1));
        list.add(new indexclass("Lesson 2",2));
        list.add(new indexclass("Lesson 3",3));
        list.add(new indexclass("Lesson 4",4));
        list.add(new indexclass("Lesson 5",5));
        list.add(new indexclass("Lesson 6",6));
        list.add(new indexclass("Lesson 7",7));
        list.add(new indexclass("Lesson 8",8));
        list.add(new indexclass("Lesson 9",9));
        list.add(new indexclass("Lesson 10",10));

        indexAdapter adapter = new indexAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);

        //opening new activity for every item on menu list

        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                indexclass w = list.get(position);

                Intent intent = new Intent(getApplicationContext(),lessonActivity.class);
                intent.putExtra("lname",w.getmLessonName());
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
    }
}
