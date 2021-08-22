package com.gunaeats.myecommerce.UAtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class store persistence data of applicaton.
 */
public class UserSession {

	private static UserSession _instance = null;
	private static SharedPreferences _sPrefs,_sPrefs2 = null;
	private static SharedPreferences.Editor _editor = null;

	private static final String OMAN_APP_PREFS = "rinkudatabase";
	private static final String OMAN_APP_PREFS_2 = "rinkudatabase";

	public static final String PREFS_USER_ID = "user_id";
	public static final String PREFS_COMPANY_NAME= "companyNAme";
	public static final String PREFS_COMPANY_NUMBER= "companynumber";
	public static final String PREFS_IDENTIFICATIONNO= "identificationno";
	public static final String PREFS_CLIENTTYPE= "clienttype";

	public static final String TASK_ID = "task_id";
	public static final String PREFS_USER_NAME = "username";
	public static final String PREFS_CURRENTDATE = "currentdate";

    public static final String PREFS_COMPANYLIST = "companylist";


	public static final String PREFS_USER_MOBILE = "user_mobile";
	public static final String PREFS_USER_IMAGE = "user_image";
	public static final String PREFS_FIRSTNAME = "firstname";
	public static final String PREFS_LASTNAME = "lastname";
	public static final String PUNCH_IN = "IN";
	public static final String START_STATUS_TYPE = "START_STATUS_TYPE";
	public static final String ONLINE_OFFLINE_STATUS = "onlineofflinestatus";
	public static final String TASKIDFORTASKSTATUS = "taskstatustaskid";




	public UserSession() {
	}

	public UserSession(Context context) {
		_sPrefs = context.getSharedPreferences(OMAN_APP_PREFS,
				Context.MODE_PRIVATE);
		
		_sPrefs2 = context.getSharedPreferences(OMAN_APP_PREFS_2,
				Context.MODE_PRIVATE);
	}




	public static UserSession getInstance(Context context) {
		if (_instance == null) {
			_instance = new UserSession(context);
		}
		return _instance;
	}

	public String readPrefs(String pref_name) {
		return _sPrefs.getString(pref_name, "");
	}

	public void writePrefs(String pref_name, String pref_val) {
		_editor = _sPrefs.edit();
		_editor.putString(pref_name, pref_val);
		_editor.commit();
	}

	public void clearPrefs() {
		_editor = _sPrefs.edit();
		_editor.clear();
		_editor.commit();
	}

	public boolean readBooleanPrefs(String pref_name) {
		return _sPrefs.getBoolean(pref_name, false);
	}

	public void writeBooleanPrefs(String pref_name, boolean pref_val) {
		_editor = _sPrefs.edit();
		_editor.putBoolean(pref_name, pref_val);
		_editor.commit();
	}

	public String readDefaultLangPrefs(String pref_name) {
		return _sPrefs.getString(pref_name, "");
	}

	public void writeDefaultLangPrefs(String pref_name) {
		_editor = _sPrefs.edit();
		_editor.putString(pref_name, pref_name);
		_editor.commit();
	}

	public String readLatLngPrefs(String pref_name) {
		return _sPrefs.getString(pref_name, "0.0");
	}

	public void writeLatLngPrefs(String pref_name, String pref_val) {
		_editor = _sPrefs.edit();
		_editor.putString(pref_name, pref_val);
		_editor.commit();
	}
	
	public String readBackupPrefs(String pref_name) {
		return _sPrefs2.getString(pref_name, "");
	}

	public void writeBackupPrefs(String pref_name, String pref_val) {
		SharedPreferences.Editor _editor = _sPrefs2.edit();
		_editor.putString(pref_name, pref_val);
		_editor.commit();
	}

}
