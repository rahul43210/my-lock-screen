package com.animate.lockscreen.service;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.animate.lockscreen.receiver.LockScreenReceiver;

public class LockScreenService extends Service{

	private BroadcastReceiver mReceiver;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		 //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

//		 ManageKeyguard.disableKeyguard(this);

		KeyguardManager.KeyguardLock k1;

		 //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

		 KeyguardManager km =(KeyguardManager)getSystemService(KEYGUARD_SERVICE);
	     k1= km.newKeyguardLock("IN");
	     k1.disableKeyguard();
	     
	     /*try{
	     StateListener phoneStateListener = new StateListener();
	     TelephonyManager telephonyManager =(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
	     telephonyManager.listen(phoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);
	     }catch(Exception e){
	    	 System.out.println(e);
	     }*/

	    /* myIntent = new Intent(MyService.this,LockScreenAppActivity.class);
	     myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	     Bundle myKillerBundle = new Bundle();
	     myKillerBundle.putInt("kill",1);
	     myIntent.putExtras(myKillerBundle);*/

	     IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
	     filter.addAction(Intent.ACTION_SCREEN_OFF);
	     mReceiver = new LockScreenReceiver();
	     registerReceiver(mReceiver, filter);
	     
		super.onCreate();
	}
	
	/*class StateListener extends PhoneStateListener{
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        super.onCallStateChanged(state, incomingNumber);
        switch(state){
            case TelephonyManager.CALL_STATE_RINGING:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                System.out.println("call Activity off hook");
            	getApplication().startActivity(myIntent);



                break;
            case TelephonyManager.CALL_STATE_IDLE:
                break;
        }
    }
	};*/


	@Override
	public void onDestroy() {
		unregisterReceiver(mReceiver);
		super.onDestroy();
	}
}
