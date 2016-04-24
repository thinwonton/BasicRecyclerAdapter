package com.github.thinwonton.basicrecycleradapter;

import android.view.View;

/**
 * Created by hugo on 2016/4/19.
 */
public class EmptyViewHolder extends BasicViewHolder {

	@Override
	public void bindView(Object item, int type) {

	}

	public EmptyViewHolder(View itemView) {
		super(itemView);
	}
}
