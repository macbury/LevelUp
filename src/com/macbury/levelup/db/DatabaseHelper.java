package com.macbury.levelup.db;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
  private static final String DATABASE_NAME   = "level.db";
  private static final int DATABASE_VERSION   = 3;
  private static final String TAG             = "DatabaseHelper";
  
  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
    try {
      Log.d(TAG, "onCreate");
      TableUtils.createTable(connectionSource, User.class);
      TableUtils.createTable(connectionSource, Category.class);
      TableUtils.createTable(connectionSource, Action.class);
    } catch (SQLException e) {
      Log.e(TAG, "Can't create database", e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    try {
      Log.d(TAG, "onUpgrade");
      TableUtils.dropTable(connectionSource, User.class, true);
      TableUtils.dropTable(connectionSource, Category.class, true);
      TableUtils.dropTable(connectionSource, Action.class, true);
      onCreate(db, connectionSource);
    } catch (SQLException e) {
      Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
      throw new RuntimeException(e);
    }
  }
}
