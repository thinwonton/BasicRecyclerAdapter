package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.HeaderFooterMultipleTypeAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.LinearFragment;
import com.github.thinwonton.basicrecycleradapter.sample.model.HeaderFooterGenerator;

/**
 * Created by HUGO on 2016/4/12.
 */
public class HeaderFooterLinearFragment extends LinearFragment {

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	protected BasicAdapter createAdapter() {
		return new HeaderFooterLinearAdapter();
	}

	@Override
	public HeaderFooterMultipleTypeAdapter getAdapter() {
		return (HeaderFooterMultipleTypeAdapter) super.getAdapter();
	}

	@Override
	public void onAddFooterActionClick() {
		getAdapter().addFooterView(
		        HeaderFooterGenerator.inflateFooter(getActivity(), getRecyclerView()));
	}

	@Override
	public void onAddHeaderActionClick() {
		getAdapter().addHeaderView(
		        HeaderFooterGenerator.inflateHeader(getActivity(), getRecyclerView()));
	}

	@Override
	public void onRemoveHeaderActionClick() {
		int count = getAdapter().getHeaderViewsCount();
		if (count > 0) {
			getAdapter().removeHeader(getAdapter().getHeaderView(0));
		}
	}

	@Override
	public void onRemoveFooterActionClick() {
		HeaderFooterMultipleTypeAdapter adapter = getAdapter();
		int count = adapter.getFooterViewsCount();
		if (count > 0) {
			adapter.removeFooterView(adapter.getFooterView(0));
		}
	}
}
