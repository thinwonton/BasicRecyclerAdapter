package com.github.thinwonton.basicrecycleradapter.sample.mutipletypeadapter;

import android.support.v4.app.Fragment;

import com.github.thinwonton.basicrecycleradapter.sample.BaseDrawerActivity;
import com.github.thinwonton.basicrecycleradapter.sample.StaggeredGridFragment;

public class MultipleTypeAdapterActivity extends BaseDrawerActivity {

	@Override
	protected Fragment getLinearFragment() {
		return new MultipleTypeLinearFragment();
	}

	@Override
	protected Fragment getGridFragment() {
		return new MultipleTypeGridFragment();
	}

	@Override
	protected Fragment getStaggeredGridFragment() {
		return new StaggeredGridFragment();
	}
}
