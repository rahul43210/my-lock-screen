package com.animate.lockscreen;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class LockScreenActivity extends LockConfigActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lock_screen);
		init();
	}
	
	public void init(){
		findViewById(R.id.btnUnlock).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
