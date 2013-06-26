package com.macbury.levelup.fragments;

import com.macbury.levelup.R;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActionFragment extends Fragment {
  private FadingActionBarHelper mFadingHelper;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = mFadingHelper.createView(inflater);
    return view;
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);

    mFadingHelper = new FadingActionBarHelper()
      .actionBarBackground(R.drawable.actionbar)
      .headerLayout(R.layout.profile_header)
      .contentLayout(R.layout.activity_actions_list)
      .lightActionBar(false)
      .parallax(false);
    mFadingHelper.initActionBar(activity);
  }
  
  
}
