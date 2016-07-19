package com.lh.tutu.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {
	private static MyApplication app;
	private static RequestQueue queues;
	@Override
	public void onCreate() {
		super.onCreate();
		app=this;
		queues=Volley.newRequestQueue(this);
	}
	public static MyApplication getContext() {
		return app;
	}
	public static RequestQueue getHttpQueue() {
		return queues;
	}
	
}
