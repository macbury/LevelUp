package com.macbury.levelup;

import com.macbury.levelup.db.DatabaseHelper;

import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

public class AppDelegate extends Application {
  private static final String TAG = "AppDelegate";
  private static AppDelegate  _shared;
  private DatabaseHelper      databaseHelper;
  
  @Override
  public void onCreate() {
    super.onCreate();
    _shared = this;
    Log.i(TAG, "Starting app");
    
  }
  
  public DatabaseHelper getDBHelper() {
    if (databaseHelper == null) {
      databaseHelper = new DatabaseHelper(this);
    }
    return databaseHelper;
  }
  
  @Override
  public void onLowMemory() {
    Log.i(TAG, "Freeing memory");
    databaseHelper  = null;
    super.onLowMemory();
  }

  public static AppDelegate shared() {
    return _shared;
  }
}
