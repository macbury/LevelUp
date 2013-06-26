package com.macbury.levelup.activity;

import com.macbury.levelup.R;

import android.app.Activity;
import android.os.Bundle;

public class LoginActivity extends Activity {

  public static final String EXTRA_AUTH_TOKEN_TYPE = null;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
  }

}
