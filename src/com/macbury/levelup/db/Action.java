package com.macbury.levelup.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "actions")
public class Action extends BaseDaoEnabled<Action, Integer> {
  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private boolean active;
  @DatabaseField
  private int heardness;
  @DatabaseField
  private boolean repeatable;
  @DatabaseField
  private int levelLearning;
  @DatabaseField
  private int currentSkill;
  @DatabaseField
  private int startSkill;
  
  @DatabaseField(canBeNull = false, foreign = true)
  private User user;
  @DatabaseField(canBeNull = false, foreign = true)
  private Category category;
}
