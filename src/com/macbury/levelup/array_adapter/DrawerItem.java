package com.macbury.levelup.array_adapter;

import com.macbury.levelup.db.Category;

public class DrawerItem {
  public static final int ALL_ITEM = -1;
  private Category category;
  private String name;
  private int color;
  private int id;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
    this.name     = category.getName();
    this.color    = category.getColor();
    this.id       = category.getId();
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
