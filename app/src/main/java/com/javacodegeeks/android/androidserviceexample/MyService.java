package com.javacodegeeks.android.androidserviceexample;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

	public MyService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "The new Service was Created", Toast.LENGTH_LONG)
				.show();

	}

	// Preferisco usare onStartCommand() perchè posso ritornare START_STICKY che
	// rendere il processo interminabile anche quando killato da android
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, " Service Started", Toast.LENGTH_LONG).show();
		return START_STICKY;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void startForeground() {
		startForeground(17, null); // Because it can't be zero...
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();

	}
}
