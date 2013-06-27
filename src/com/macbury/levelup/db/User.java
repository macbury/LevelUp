package com.macbury.levelup.db;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User extends BaseDaoEnabled<User, Long>  {
  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField(canBeNull=false, defaultValue = "0")
  private long points;
  @DatabaseField(canBeNull=false, defaultValue = "0")
  private int level;
  
  @ForeignCollectionField(eager = false)
  private ForeignCollection<Action> actions;
}
