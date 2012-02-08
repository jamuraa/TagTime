package bsoule.tagtime;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TagTimeStartUp extends BroadcastReceiver {

	public static final String TAG = "TagTimeStartUp";
	@Override
	public void onReceive(Context context, Intent intent) {
		if ( "android.intent.action.BOOT_COMPLETED".equals(intent.getAction()) ||
				intent.getBooleanExtra("ThisIntentIsTagTimeStartUpClass",false) ) {
			ComponentName comp = new ComponentName(context.getPackageName(), PingService.class.getName());
			ComponentName service = context.startService(new Intent().setComponent(comp));
			if (null == service){
				// something really wrong here
				Log.e(TAG, "Could not start service " + comp.toString());
			}
		} else {
			Log.e(TAG, "Received unexpected intent " + intent.getAction());   
		}
	}
}