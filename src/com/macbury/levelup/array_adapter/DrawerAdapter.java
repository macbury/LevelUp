package com.macbury.levelup.array_adapter;

import java.util.ArrayList;

import com.androidquery.AQuery;
import com.macbury.levelup.R;
import com.macbury.levelup.db.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DrawerAdapter extends BaseAdapter {
  private ArrayList<DrawerItem> items;
  private Context context;
  private AQuery query;
  
  public DrawerAdapter(Context mContext) {
    this.context = mContext;
    this.query   = new AQuery(context);
  }
  
  @Override
  public int getCount() {
    return items.size();
  }

  @Override
  public DrawerItem getItem(int position) {
    return items.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
      convertView             = inflater.inflate(R.layout.drawer_list_item, parent, false);
    }
    AQuery aq           = query.recycle(convertView);
    DrawerItem category = getItem(position);
    
    if (category.getColor() == 0) {
      aq.id(R.id.drawer_color_view).visibility(View.GONE);
    } else {
      aq.id(R.id.drawer_color_view).backgroundColor(category.getColor()).visibility(View.VISIBLE);
    }
    
    aq.id(R.id.drawerItemView).text(category.getName());
    
    return convertView;
  }

  public ArrayList<DrawerItem> getItems() {
    return items;
  }

  public void setItems(ArrayList<DrawerItem> items) {
    this.items = items;
    this.notifyDataSetChanged();
  }

}
