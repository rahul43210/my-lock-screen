package com.animate.lockscreen.theme.slide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animate.lockscreen.R;
import com.animate.lockscreen.algorithm.AlgorithmListener;
import com.animate.lockscreen.algorithm.SwitchView;
import com.animate.lockscreen.fragment.LockScreenFragment;

public class SlideToUnlock extends LockScreenFragment implements AlgorithmListener{

	@Override
	protected View onCreateContentView(LayoutInflater inflater,
			ViewGroup container) {
		View v = inflater.inflate(R.layout.lock_screen, container,false);
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
