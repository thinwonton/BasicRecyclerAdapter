package com.github.thinwonton.basicrecycleradapter.sample.simpleadapter;

import android.support.v4.app.Fragment;

import com.github.thinwonton.basicrecycleradapter.sample.BaseDrawerActivity;
import com.github.thinwonton.basicrecycleradapter.sample.GridFragment;
import com.github.thinwonton.basicrecycleradapter.sample.LinearFragment;
import com.github.thinwonton.basicrecycleradapter.sample.StaggeredGridFragment;

public class SimpleAdapterActivity extends BaseDrawerActivity {

	@Override
	protected Fragment getLinearFragment() {
		return new LinearFragment();
	}

	@Override
	protected Fragment getGridFragment() {
		return new GridFragment();
	}

	@Override
	protected Fragment getStaggeredGridFragment() {
		return new StaggeredGridFragment();
	}

}
