package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;

/**
 * Created by HUGO on 2016/4/12.
 */
public class HeaderFooterGridFragment extends HeaderFooterBaseFragment {
	// display a item with 2 span in type2
	@Override
	protected BasicAdapter createAdapter() {
		return new HeaderFooterGridAdapter();
	}

	@Override
	protected void configRecyclerView(RecyclerView recyclerView) {
		RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
		recyclerView.setLayoutManager(layoutManager);
	}

}
