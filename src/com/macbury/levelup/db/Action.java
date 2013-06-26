package com.macbury.levelup.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "actions")
public class Action {
  @DatabaseField(id = true, generatedId = true)
  private int id;
}
