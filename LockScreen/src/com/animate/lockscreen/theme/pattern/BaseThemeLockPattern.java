package com.animate.lockscreen.theme.pattern;

import java.util.List;

import com.animate.lockscreen.fragment.LockScreenFragment;
import com.animate.lockscreen.util.lock.LockPatternUtil;
import com.animate.lockscreen.widget.lock.LockPatternView.Cell;
import com.animate.lockscreen.widget.lock.LockPatternView.OnPatternListener;

public abstract class BaseThemeLockPattern extends LockScreenFragment implements OnPatternListener{

	@Override
	public void onPatternStart() {
		
	}

	@Override
	public void onPatternCleared() {
		
	}

	@Override
	public void onPatternCellAdded(List<Cell> pattern) {
		
	}

	@Override
	public void onPatternDetected(List<Cell> pattern) {
//		LockPatternUtil.savePatternUnlock(pattern);
		if(LockPatternUtil.checkPatternUnlock(pattern))
		unlockSuccess();
	}
	
}
