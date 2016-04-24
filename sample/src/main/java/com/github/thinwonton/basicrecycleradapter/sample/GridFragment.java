package com.github.thinwonton.basicrecycleradapter.sample;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.simpleadapter.SimpleExampleAdapter;

/**
 * Created by HUGO on 2016/4/12.
 */
public class GridFragment extends BaseFragment {

    @Override
    protected BasicAdapter createAdapter() {
        return new SimpleExampleAdapter();
    }

    @Override
    protected void configRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
    }

}
