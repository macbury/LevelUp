package com.macbury.levelup.db;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "categories")
public class Category extends BaseDaoEnabled<Category, Integer> {
  @DatabaseField(id = true, generatedId = true)
  private int id;
  @DatabaseField(canBeNull=false)
  private String name;
  @DatabaseField(canBeNull=false)
  private int color;
  
  @ForeignCollectionField(eager = false)
  private ForeignCollection<Action> actions;
}
