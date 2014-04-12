package com.animate.lockscreen.fragment;




public abstract class LockScreenFragment extends BaseFragment{
	
	public void unlockSuccess(){
		if(getActivity() instanceof UnlockInterface){
			((UnlockInterface)getActivity()).unlock(-1);
		}
	}
	
}
