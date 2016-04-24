package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import android.support.v4.app.Fragment;

import com.github.thinwonton.basicrecycleradapter.sample.BaseDrawerActivity;
import com.github.thinwonton.basicrecycleradapter.sample.StaggeredGridFragment;

public class HeaderFooterAdapterActivity extends BaseDrawerActivity {

	@Override
	protected Fragment getLinearFragment() {
		return new HeaderFooterLinearFragment();
	}

	@Override
	protected Fragment getGridFragment() {
		return new HeaderFooterGridFragment();
	}

	@Override
	protected Fragment getStaggeredGridFragment() {
		return new StaggeredGridFragment();
	}
}
