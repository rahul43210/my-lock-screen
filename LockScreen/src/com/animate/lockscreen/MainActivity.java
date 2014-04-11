package com.animate.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.animate.lockscreen.service.LockScreenService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	public void init(){
		findViewById(R.id.btnStartLockScreen).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startService(new Intent(MainActivity.this,LockScreenService.class));
				Intent intent = new Intent(MainActivity.this,LockScreenActivity.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

	        	startActivity(intent);
			}
		});
	}

}
