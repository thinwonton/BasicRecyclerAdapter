package com.github.thinwonton.basicrecycleradapter.sample;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by HUGO on 2016/4/24.
 */
public class MyApplication extends Application {
	private RefWatcher mRefWatcher;

	@Override
	public void onCreate() {
		super.onCreate();

		// leak
		mRefWatcher = LeakCanary.install(this);
	}

	public static RefWatcher getRefWatcher(Context context) {
		MyApplication application = (MyApplication) context.getApplicationContext();
		return application.mRefWatcher;
	}
}
