package com.github.thinwonton.basicrecycleradapter.sample;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.simpleadapter.SimpleExampleAdapter;

/**
 * Created by HUGO on 2016/4/12.
 */
public class StaggeredGridFragment extends BaseFragment {
	@Override
	protected BasicAdapter createAdapter() {
		return new SimpleExampleAdapter();
	}

	@Override
	protected void configRecyclerView(RecyclerView recyclerView) {
		RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,
		        StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(layoutManager);
	}
}
