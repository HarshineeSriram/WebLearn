package com.beta.android.aakashresearchlabs.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.TestLessons.TestBackEndActivity;
import com.beta.android.aakashresearchlabs.test.TestLessons.TestBasicActivity;
import com.beta.android.aakashresearchlabs.test.TestLessons.TestFrameworkActivity;
import com.beta.android.aakashresearchlabs.test.TestLessons.TestFrontEndActivity;
import com.beta.android.aakashresearchlabs.test.TestLessons.TestGitBasicActivity;
import com.beta.android.aakashresearchlabs.test.TestLessons.TestImportantActivity;
import com.beta.android.aakashresearchlabs.test.customAdapters.testmenuAdapter;
import com.beta.android.aakashresearchlabs.test.customClasses.wordclass;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        //changing index page heading text
        TextView hd =(TextView) findViewById(R.id.index_heading);
        hd.setText("Test Plans");

        //test plan index adapter
        final ArrayList<wordclass> list = new ArrayList<wordclass>();
        list.add(new wordclass(R.string.list1, TestBasicActivity.class));
        list.add(new wordclass(R.string.list2, TestGitBasicActivity.class));
        list.add(new wordclass(R.string.list3, TestFrontEndActivity.class));
        list.add(new wordclass(R.string.list4, TestBackEndActivity.class));
        list.add(new wordclass(R.string.list5, TestFrameworkActivity.class));
        list.add(new wordclass(R.string.list6, TestImportantActivity.class));

        testmenuAdapter adapter = new testmenuAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list_section);
        section.setAdapter(adapter);


        //opening new activity for every item on menu list
        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                wordclass w = list.get(position);

                //starting different activities respective to the item clicked
                Intent intent = new Intent(getApplicationContext(),w.getmCls());
                startActivity(intent);
            }
        });

    }

}