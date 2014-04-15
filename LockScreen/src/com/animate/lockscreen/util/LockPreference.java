package com.animate.lockscreen.util;

import com.animate.lockscreen.LockScreenApp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LockPreference {

	private static LockPreference INSTANCE = null;
	
	private SharedPreferences mSharedPreference;
	private Editor mEditor;
	
	private LockPreference(){
		mSharedPreference = LockScreenApp.getAppContext().getSharedPreferences("lockscreen", 0);
		mEditor = mSharedPreference.edit();
	}
	
	public static LockPreference getInstance(){
		if(INSTANCE == null){
			INSTANCE = new LockPreference();
		}
		return INSTANCE;
	}
	
	public SharedPreferences getSharePreference(){
		if(mSharedPreference == null){
			mSharedPreference = LockScreenApp.getAppContext().getSharedPreferences("lockscreen", 0);
		}
		return mSharedPreference;
	}
	
	public Editor getEditor(){
		if(mEditor == null){
			mEditor = getSharePreference().edit();
		}
		return mEditor;
	}
	
	public void putInt(String key,int value){
		getEditor().putInt(key, value);
		getEditor().commit();
	}
	
	public void putString(String key,String value){
		getEditor().putString(key, value);
		getEditor().commit();
	}
	
	public int getIntValue(String key,int defValue){
		return getSharePreference().getInt(key, defValue);
	}
	
	public String getStringValue(String key,String defValue){
		return getSharePreference().getString(key, defValue);
	}
}
