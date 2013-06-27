package com.macbury.levelup.db;


import android.content.Context;
import android.content.res.TypedArray;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.macbury.levelup.AppDelegate;
import com.macbury.levelup.R;

@DatabaseTable(tableName = "categories")
public class Category {
  private static final String TAG = "Category";
  
  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField(canBeNull=false)
  private String name;
  @DatabaseField(canBeNull=false)
  private int color;
  
  @ForeignCollectionField(eager = false)
  private ForeignCollection<Action> actions;
  
  public static void bootstrap(Context context) {
    DatabaseHelper db      = AppDelegate.shared().getDBHelper();
    String[] categoryNames = context.getResources().getStringArray(R.array.category_names);
    TypedArray colors      = context.getResources().obtainTypedArray(R.array.category_colors);
    
    for (int i = 0; i < categoryNames.length; i++) {
      Category category = new Category();
      category.name     = categoryNames[i];
      category.color    = colors.getColor(i, 0);
      db.save(category);
    }
  }
  
  @Override
  public String toString() {
    return "Category(id="+id+", name="+name+", color="+color+")";
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }
}
