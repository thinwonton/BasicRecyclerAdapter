package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import com.github.thinwonton.basicrecycleradapter.HeaderFooterMultipleTypeAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.BaseFragment;
import com.github.thinwonton.basicrecycleradapter.sample.model.HeaderFooterGenerator;

/**
 * Created by HUGO on 2016/4/12.
 */
public abstract class HeaderFooterBaseFragment extends BaseFragment {

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
