package com.animate.lockscreen;

import com.animate.lockscreen.lockview.UnlockInterface;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;

public class LockConfigActivity extends Activity implements UnlockInterface{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		if(getIntent()!=null&&getIntent().hasExtra("kill")&&getIntent().getExtras().getInt("kill")==1){
  	        finish();
  	    }
		
		StateListener phoneStateListener = new StateListener();
        TelephonyManager telephonyManager =(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        telephonyManager.listen(phoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);
	}
	
	
	class StateListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            super.onCallStateChanged(state, incomingNumber);
            switch(state){
                case TelephonyManager.CALL_STATE_RINGING:
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    System.out.println("call Activity off hook");
                	finish();



                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    break;
            }
        }
    };
    
    @Override
	 public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG|WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onAttachedToWindow();
	 }
    
    @Override
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {

      	if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)||(keyCode == KeyEvent.KEYCODE_POWER)||(keyCode == KeyEvent.KEYCODE_VOLUME_UP)||(keyCode == KeyEvent.KEYCODE_CAMERA)) {
      	    //this is where I can do my stuff
      	    return true; //because I handled the event
      	}
         if((keyCode == KeyEvent.KEYCODE_HOME)){

      	   return true;
          }

         return false;

      }

      public boolean dispatchKeyEvent(KeyEvent event) {
      	if (event.getKeyCode() == KeyEvent.KEYCODE_POWER ||(event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN)||(event.getKeyCode() == KeyEvent.KEYCODE_POWER)) {
      	    //Intent i = new Intent(this, NewActivity.class);
      	    //startActivity(i);
      	    return false;
      	}
      	 if((event.getKeyCode() == KeyEvent.KEYCODE_HOME)){

             System.out.println("home button click");
        	   return true;
           }
      	 return false;
      }
      
    
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	public void onBackPressed() {
		return;
	}

	@Override
	public void unlock(int screenId) {
		finish();
	}
	
}
