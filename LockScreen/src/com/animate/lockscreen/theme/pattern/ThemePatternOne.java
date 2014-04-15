package com.animate.lockscreen.theme.pattern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animate.lockscreen.R;
import com.animate.lockscreen.widget.lock.LockPatternView;

public class ThemePatternOne extends BaseThemeLockPattern{

	private LockPatternView mLockPatternView;
	
	@Override
	protected View onCreateContentView(LayoutInflater inflater,
			ViewGroup container) {
		View v = inflater.inflate(R.layout.theme_pattern1, container,false);
		mLockPatternView = (LockPatternView) v.findViewById(R.id.pattern);
		mLockPatternView.setOnPatternListener(this);
		return v;
	}


}
