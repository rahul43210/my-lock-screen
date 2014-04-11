package com.animate.lockscreen.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.animate.lockscreen.LockScreenActivity;

public class LockScreenReceiver extends BroadcastReceiver{

	public static boolean wasScreenOn = true;

	@Override
	public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

        	wasScreenOn=false;
        	Intent intent11 = new Intent(context,LockScreenActivity.class);
        	intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	context.startActivity(intent11);

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {

        	wasScreenOn=true;
        	Intent intent11 = new Intent(context,LockScreenActivity.class);
        	intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
       else if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
//    	   ManageKeyguard.disableKeyguard(context);
        	Intent intent11 = new Intent(context, LockScreenActivity.class);

        	intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(intent11);

        	//  Intent intent = new Intent(context, LockPage.class);
	        //  context.startActivity(intent);
	        //  Intent serviceLauncher = new Intent(context, UpdateService.class);
	        //  context.startService(serviceLauncher);
	        //  Log.v("TEST", "Service loaded at start");
       }

    }

}
