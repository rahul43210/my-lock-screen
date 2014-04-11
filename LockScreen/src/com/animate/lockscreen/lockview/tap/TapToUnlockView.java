package com.animate.lockscreen.lockview.tap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.animate.lockscreen.R;
import com.animate.lockscreen.lockview.AbstractLockView;

public class TapToUnlockView extends AbstractLockView{

	public TapToUnlockView(Context context) {
		super(context);
	}

	@Override
	protected View getLayout() {
		View v = LayoutInflater.from(mContext).inflate(R.layout.lock_screen, null);
		v.findViewById(R.id.btnUnlock).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unlockSuccess();
			}
		});
		return v;
	}

}
