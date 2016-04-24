package com.github.thinwonton.basicrecycleradapter.sample.simpleadapter;

import android.view.View;

import com.github.thinwonton.basicrecycleradapter.SingleTypeAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.R;
import com.github.thinwonton.basicrecycleradapter.sample.model.Cat;

/**
 * Created by Administrator on 2016/4/19.
 */
public class SimpleExampleAdapter extends SingleTypeAdapter<Cat, SimpleExampleViewHolder> {
	@Override
	protected SimpleExampleViewHolder viewHolder(View view) {
		return new SimpleExampleViewHolder(view);
	}

	@Override
	protected int layoutId() {
		return R.layout.list_cat_item;
	}

}
