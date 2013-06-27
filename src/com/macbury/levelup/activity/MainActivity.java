package com.macbury.levelup.activity;

import java.util.ArrayList;

import com.macbury.levelup.AppDelegate;
import com.macbury.levelup.R;
import com.macbury.levelup.array_adapter.DrawerAdapter;
import com.macbury.levelup.array_adapter.DrawerItem;
import com.macbury.levelup.db.Category;
import com.macbury.levelup.fragments.ActionFragment;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements OnItemClickListener {
  private DrawerAdapter mCategoryAdapter;
  private DrawerLayout          mDrawerLayout;
  private ActionBarDrawerToggle mDrawerToggle;
  private ListView              mDrawerList;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_with_drawer);
    ActionBar actionBar = getActionBar();
    
    mCategoryAdapter    = new DrawerAdapter(this);
    mDrawerLayout       = (DrawerLayout) findViewById(R.id.drawer_layout);
    mDrawerList         = (ListView) findViewById(R.id.left_drawer);
    
    setupDrawerData();
    
    mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
    mDrawerList.setAdapter(mCategoryAdapter);
    mDrawerList.setOnItemClickListener(this);
    
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeButtonEnabled(true);
    
    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
        R.drawable.ic_drawer,
        R.string.drawer_open,
        R.string.drawer_close);
    
    mDrawerLayout.setDrawerListener(mDrawerToggle);
    
    selectDrawerItem(0, true);
  }
  
  private void selectDrawerItem(int position, boolean replace) {
    mDrawerList.setItemChecked(position, true);
    ActionFragment actionFragment   = new ActionFragment();
    FragmentTransaction ft          = getFragmentManager().beginTransaction();
    
    ft.replace(R.id.content_frame, actionFragment);
    ft.commit();
    mDrawerLayout.closeDrawer(mDrawerList);
  }

  private void setupDrawerData() {
    ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();
    DrawerItem allItem          = new DrawerItem();
    
    allItem.setName(getResources().getString(R.string.drawer_all));
    allItem.setId(DrawerItem.ALL_ITEM);
    items.add(allItem);
    
    for (Category category : AppDelegate.shared().getDBHelper().findAllCategories()) {
      DrawerItem item = new DrawerItem();
      item.setCategory(category);
      items.add(item);
    }
    
    mCategoryAdapter.setItems(items);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
    //menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
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
    if (item.getItemId() == R.id.action_new_add) {
      startActivity(new Intent(this, NewActionActivity.class));
      return true;
    } else {
      return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
    
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    selectDrawerItem(position, false);
  }
  
}
