package com.beta.android.aakashresearchlabs.test;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.customAdapters.wordAdapter;
import com.beta.android.aakashresearchlabs.test.customClasses.wordclass;
import com.beta.android.aakashresearchlabs.test.lessons.BackEndActivity;
import com.beta.android.aakashresearchlabs.test.lessons.BasicActivity;
import com.beta.android.aakashresearchlabs.test.lessons.FrameworkActivity;
import com.beta.android.aakashresearchlabs.test.lessons.FrontEndActivity;
import com.beta.android.aakashresearchlabs.test.lessons.GitBasicActivity;
import com.beta.android.aakashresearchlabs.test.lessons.ImportantActivity;

import java.util.ArrayList;

import static com.beta.android.aakashresearchlabs.test.R.layout.activity_main;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //set font for app name in menu

        TextView tx = (TextView)findViewById(R.id.heading_appname);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/WOX-Striped_Triple.otf");
        tx.setTypeface(custom_font);


        //set menu list adapter

        final ArrayList<wordclass> list = new ArrayList<wordclass>();

        list.add(new wordclass(R.string.list1,R.color.list1,BasicActivity.class));
        list.add(new wordclass(R.string.list2,R.color.list2,GitBasicActivity.class));
        list.add(new wordclass(R.string.list3,R.color.list3,FrontEndActivity.class));
        list.add(new wordclass(R.string.list4,R.color.list4,BackEndActivity.class));
        list.add(new wordclass(R.string.list5,R.color.list5,FrameworkActivity.class));
        list.add(new wordclass(R.string.list6,R.color.list6,ImportantActivity.class));

        wordAdapter adapter = new wordAdapter(this,list);
        ListView section = (ListView) findViewById(R.id.menu_list);
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent;

        if (id == R.id.test)
        {
            intent = new Intent(getApplicationContext(),TestActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.nav_camera) {
            // Handle the camera action
        }

        else if (id == R.id.nav_gallery) {

        }

        else if (id == R.id.nav_slideshow) {

        }

        else if (id == R.id.nav_share) {

            Intent share=new Intent(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TITLE,"Sharing my progress");
            share.putExtra(Intent.EXTRA_SUBJECT,"Puns :p");
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT,"How do functions break up? They stop calling each other");
            startActivity(share);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
