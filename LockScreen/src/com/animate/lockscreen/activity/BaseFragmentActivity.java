package com.animate.lockscreen.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.animate.lockscreen.R;

public class BaseFragmentActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.frame_content);
	}
	
	/**
     * add fragment
     * @param frag
     * @param isAddToBackStack
     */
    public void switchContent(Fragment frag,boolean isAddToBackStack){
        FragmentTransaction fragManager = getSupportFragmentManager().beginTransaction();
        fragManager.replace(R.id.content_frame, frag);
        if(isAddToBackStack){
            fragManager.addToBackStack(null);
        }
        fragManager.commit();
    }
    
    /**
     * add fragment with fragment name
     * @param frag
     * @param isAddToBackStack
     * @param name
     */
    public void switchContent(Fragment frag,boolean isAddToBackStack,String name){
        FragmentTransaction fragManager = getSupportFragmentManager().beginTransaction();
        fragManager.replace(R.id.content_frame, frag);
        if(isAddToBackStack){
            fragManager.addToBackStack(name);
        }
        fragManager.commit();
    }
    
    /**
     * add fragment
     * @param frag
     * @param isAddToBackStack
     */
    public void addContent(Fragment frag,boolean isAddToBackStack){
        FragmentTransaction fragManager = getSupportFragmentManager().beginTransaction();
        fragManager.add(R.id.content_frame, frag);
        if(isAddToBackStack){
            fragManager.addToBackStack(null);
        }
        fragManager.commit();
    }
    
    /**
     * add fragment with fragment name
     * @param frag
     * @param isAddToBackStack
     * @param name
     */
    public void addContent(Fragment frag,boolean isAddToBackStack,String name){
        FragmentTransaction fragManager = getSupportFragmentManager().beginTransaction();
        fragManager.add(R.id.content_frame, frag);
        if(isAddToBackStack){
            fragManager.addToBackStack(name);
        }
        fragManager.commit();
    }
}
