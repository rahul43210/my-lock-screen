package com.animate.lockscreen.theme.tap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.animate.lockscreen.R;
import com.animate.lockscreen.fragment.LockScreenFragment;

public class TapToUnlockView extends LockScreenFragment{


	@Override
	protected View onCreateContentView(LayoutInflater inflater,
			ViewGroup container) {
		View v = inflater.inflate(R.layout.lock_screen, null);
		v.findViewById(R.id.btnUnlock).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unlockSuccess();
			}
		});
		return v;
	}

}
