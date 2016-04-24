package com.github.thinwonton.basicrecycleradapter;

import android.view.View;

public abstract class SingleTypeViewHolder<T> extends BasicViewHolder<T> {

	public SingleTypeViewHolder(View itemView) {
		super(itemView);
	}

	@Override
	public void bindView(T item, int type) {
		bindView(item);
	}

	public abstract void bindView(T item);
}
