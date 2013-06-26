package com.macbury.levelup.account;
import java.io.IOException;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class MyAccount implements AccountManagerCallback<Bundle> {
  private static final String TAG = "MyAccount";
  private Context context;

  public MyAccount(Context context) {
    this.context = context;
  }
  
  @Override
  public void run(AccountManagerFuture<Bundle> future) {
    try {
      String token = future.getResult().getString(AccountManager.KEY_AUTHTOKEN);
      if (token != null) {
        Log.i(TAG, "Token is: "+ token);
      } else {
        Log.i(TAG, "Token is null!");
      }
    } catch (OperationCanceledException e) {
      Log.i(TAG, "Account have been canceled!");
    } catch (AuthenticatorException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
