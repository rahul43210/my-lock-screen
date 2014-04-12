package com.animate.lockscreen.activity;

import android.os.Bundle;

import com.animate.lockscreen.fragment.UnlockScreenFactory;


public class LockScreenActivity extends LockConfigActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		switchContent(UnlockScreenFactory.getInstance().getUnlockScreen(this), false);
	}
	
}
