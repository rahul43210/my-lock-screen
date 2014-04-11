package com.animate.lockscreen;

import android.os.Bundle;

import com.animate.lockscreen.lockview.UnlockScreenFactory;


public class LockScreenActivity extends LockConfigActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(UnlockScreenFactory.getInstance().getUnlockScreen(this));
	}
	
}
