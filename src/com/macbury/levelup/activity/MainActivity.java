package com.macbury.levelup.activity;

import com.macbury.levelup.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
  private DrawerLayout          mDrawerLayout;
  private ActionBarDrawerToggle mDrawerToggle;
  private ListView              mDrawerList;
  
  private String[] mCityNames;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_with_drawer);
    
    mCityNames    = getResources().getStringArray(R.array.drawer_items);
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mDrawerList   = (ListView) findViewById(R.id.left_drawer);
    
    mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
    mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mCityNames));
    
    ActionBar actionBar = getActionBar();
    
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeButtonEnabled(true);
    
    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
        R.drawable.ic_drawer,
        R.string.drawer_open,
        R.string.drawer_close) {
      public void onDrawerClosed(View view) {
        //getActionBar().setTitle(mTitle);
      }

      public void onDrawerOpened(View drawerView) {
        //getActionBar().setTitle(mDrawerTitle);
      }
    };
    
    mDrawerLayout.setDrawerListener(mDrawerToggle);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
    //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
    return super.onPrepareOptionsMenu(menu);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
  }
}
