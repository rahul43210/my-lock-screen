package com.animate.lockscreen.lockview;

import android.content.Context;
import android.view.View;

import com.animate.lockscreen.lockview.tap.TapToUnlockView;

public class UnlockScreenFactory {

	public static UnlockScreenFactory INSTANCE = null;
	
	private UnlockScreenFactory() {
		INSTANCE = this;
	}
	
	/**
	 * get Instance of DatabaseController to work with data
	 * @author HuanND
	 * @return
	 */
	public static UnlockScreenFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UnlockScreenFactory();
		}
		return INSTANCE;
	}
	
	public View getUnlockScreen(Context context){
		return new TapToUnlockView(context);
	}
}
