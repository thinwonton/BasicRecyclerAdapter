package com.github.thinwonton.basicrecycleradapter;

import android.view.View;

/**
 * Created by HUGO on 2016/4/12.
 */
public abstract class SingleTypeAdapter<T, VH extends SingleTypeViewHolder>
        extends BasicAdapter<T, VH> {
	@Override
	final protected VH viewHolder(View view, int type) {
		return viewHolder(view);
	}

	@Override
	protected int getItemType(int position) {
		return 0;
	}

	@Override
	final protected int layoutId(int type) {
		return layoutId();
	}

	protected abstract VH viewHolder(View view);

	protected abstract int layoutId();

}
