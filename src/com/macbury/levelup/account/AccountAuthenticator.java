package com.macbury.levelup.account;

import com.macbury.levelup.activity.LoginActivity;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class AccountAuthenticator extends AbstractAccountAuthenticator {
  public static final String ACCOUNT_TYPE = "com.macbury.levelup";
  private static final String TAG = "AccountAuthenticator";
  Context mContext;
  
  public AccountAuthenticator(Context context) {
    super(context);
    this.mContext = context;
  }

  @Override
  public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
    Log.d(TAG, "addAccount");
    Intent intent = new Intent(this.mContext, LoginActivity.class);
    intent.putExtra(LoginActivity.EXTRA_AUTH_TOKEN_TYPE, authTokenType);
    intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, authTokenType);
    
    Bundle result = new Bundle();
    result.putParcelable(AccountManager.KEY_INTENT, intent);
    
    return result;
  }

  @Override
  public Bundle confirmCredentials(AccountAuthenticatorResponse response,
      Account account, Bundle options) throws NetworkErrorException {
    Log.d(TAG, "confirmCredentials");
    return null;
  }

  @Override
  public Bundle editProperties(AccountAuthenticatorResponse response,
      String accountType) {
    Log.d(TAG, "editProperties");
    return null;
  }

  @Override
  public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
    Bundle result = new Bundle();
    
    AccountManager am = AccountManager.get(mContext);
    String username = account.name;
    String password = am.getPassword(account);
    Log.d("Auth5000", password);
    
    result.putString(AccountManager.KEY_AUTHTOKEN, "ABCD");
    result.putString(AccountManager.KEY_ACCOUNT_NAME, username);
    result.putString(AccountManager.KEY_ACCOUNT_TYPE, authTokenType);
    
    return result;
  }

  @Override
  public String getAuthTokenLabel(String authTokenType) {
    Log.d(TAG, "getAuthTokenLabel");
    return null;
  }

  @Override
  public Bundle hasFeatures(AccountAuthenticatorResponse response,
      Account account, String[] features) throws NetworkErrorException {
    Log.d(TAG, "hasFeatures");
    return null;
  }

  @Override
  public Bundle updateCredentials(AccountAuthenticatorResponse response,
      Account account, String authTokenType, Bundle options)
      throws NetworkErrorException {
    Log.d(TAG, "updateCredentials");
    return null;
  }

}
