package com.animate.lockscreen.theme.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.animate.lockscreen.R;
import com.animate.lockscreen.algorithm.AlgorithmListener;
import com.animate.lockscreen.algorithm.SwitchView;
import com.animate.lockscreen.fragment.AbstractLockView;

public class SlideToUnlock extends AbstractLockView implements AlgorithmListener{

	public SlideToUnlock(Context context) {
		super(context);
	}

	@Override
	protected View getLayout() {
		View v = LayoutInflater.from(mContext).inflate(R.layout.lock_screen, null);
		SwitchView switchView = (SwitchView)v.findViewById(R.id.switch3);
		switchView.setOnAlgorithmListener(this);
		switchView.toggle();
		switchView.disableClick();
		switchView.fixate(true);
		return v;
	}

	@Override
	public void algorithmSuccess(int id) {
		unlockSuccess();
	}
}
