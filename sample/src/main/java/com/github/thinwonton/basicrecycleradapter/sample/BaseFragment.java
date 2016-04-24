package com.github.thinwonton.basicrecycleradapter.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.model.CatGenerator;
import com.github.thinwonton.basicrecycleradapter.sample.utils.OnMenuClickListener;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Administrator on 2016/4/18.
 */
public abstract class BaseFragment<A extends BasicAdapter> extends Fragment
        implements OnMenuClickListener {
	public static final String ARG_DRAWER_MENU_INDEX = "arg_drawer_menu_index";

	private int index = -1;

	private A mAdapter;
	private RecyclerView mRecyclerView;

	protected abstract A createAdapter();

	protected abstract void configRecyclerView(RecyclerView recyclerView);

	public A getAdapter() {
		return mAdapter;
	}

	public RecyclerView getRecyclerView() {
		return mRecyclerView;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
	        @Nullable Bundle savedInstanceState) {
		Bundle arguments = getArguments();
		index = arguments.getInt(ARG_DRAWER_MENU_INDEX, -1);
		return inflater.inflate(R.layout.recycler_base, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
		configRecyclerView(mRecyclerView);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mAdapter = createAdapter();
		mRecyclerView.setAdapter(mAdapter);

		view.postDelayed(new Runnable() {
			@Override
			public void run() {
				mAdapter.setItems(CatGenerator.getList());
			}
		}, 500);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
		refWatcher.watch(this);
	}

	@Override
	public void onAddItemActionClick() {
		mAdapter.addItem(CatGenerator.getItem());
	}

	@Override
	public void onDeleteItemActionClick() {
		int size = mAdapter.getRealItemCount();
		if (size > 0) {
			mAdapter.removeItem(size - 1);
		}
	}

	@Override
	public void onClearItemsActionClick() {
		mAdapter.clearItems();
	}

	@Override
	public void onSetItemsActionClick() {
		mAdapter.setItems(CatGenerator.getList());
	}

	@Override
	public void onAddHeaderActionClick() {

	}

	@Override
	public void onRemoveHeaderActionClick() {

	}

	@Override
	public void onAddFooterActionClick() {

	}

	@Override
	public void onRemoveFooterActionClick() {

	}
}
