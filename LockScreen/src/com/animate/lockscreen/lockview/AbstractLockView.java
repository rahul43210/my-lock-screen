package com.animate.lockscreen.lockview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public abstract class AbstractLockView extends RelativeLayout{

	protected Context mContext;
	
	public AbstractLockView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		init();
	}

	public AbstractLockView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	public AbstractLockView(Context context) {
		super(context);
		mContext = context;
		init();
	}
	
	public void init(){
		addView(getLayout(), new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}
	
	protected abstract View getLayout();
	
	public void unlockSuccess(){
		if(mContext instanceof UnlockInterface){
			((UnlockInterface)mContext).unlock(-1);
		}
	}

}
