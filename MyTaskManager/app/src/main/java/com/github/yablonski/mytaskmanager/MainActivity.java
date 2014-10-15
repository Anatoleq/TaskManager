package com.github.yablonski.mytaskmanager;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.app.Activity;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    TextView name_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String value = getIntent().getStringExtra("extra_key");
        setContentView(R.layout.activity_main);
        name_t = (TextView) findViewById(R.id.name_t);

        Button listv_btn = (Button) findViewById(R.id.listv_bnt);
        Button spinner_btn = (Button) findViewById(R.id.spinner_bnt);
        Button grid_btn = (Button) findViewById(R.id.grid_bnt);
        Button fragment_btn = (Button) findViewById(R.id.fragment_bnt);
        Button swipe_btn = (Button) findViewById(R.id.swipe_bnt);

        listv_btn.setOnClickListener(this);
        spinner_btn.setOnClickListener(this);
        grid_btn.setOnClickListener(this);
        fragment_btn.setOnClickListener(this);
        swipe_btn.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.listv_bnt:
                intent = new Intent("android.intent.action.showlist");
                startActivity(intent);
                break;
            case R.id.spinner_bnt:
                intent = new Intent("android.intent.action.showspinner");
                startActivity(intent);
                break;
            case R.id.grid_bnt:
                intent = new Intent("android.intent.action.showgrid");
                startActivity(intent);
                break;
            case R.id.fragment_bnt:
                intent = new Intent("android.intent.action.showfragment");
                startActivity(intent);
                break;
            case R.id.swipe_bnt:
                intent = new Intent("android.intent.action.showswipe");
                startActivity(intent);
                break;
        }
    }

    /*public void onStartSampleClick(View view) {
        startActivity(new Intent(this, SampleActivity.class));
    }*/

    public void onStartSampleClick(View view) {
        startActivity(new Intent(this, LvActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
