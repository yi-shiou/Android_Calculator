package com.example.user.cacular;

import android.app.FragmentManager;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.*;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.blank, CalculatorFragment.newInstance(0))
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
     @Override
   public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.action_settings:
                addMyfragment();
                break;
            case R.id.action_quit:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    //*
   public void addMyfragment(){
       FragmentManager fragmentManager = getFragmentManager();
       fragmentManager.beginTransaction()
               .replace(R.id.blank, SettingFragment.newInstance(0))
               .commit();
   }/**/
}
