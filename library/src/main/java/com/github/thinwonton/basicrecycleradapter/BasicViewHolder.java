package com.github.thinwonton.basicrecycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/4/19.
 */
public abstract class BasicViewHolder<T> extends RecyclerView.ViewHolder {
	private Context context;

    public abstract void bindView(T item, int type);

	public BasicViewHolder(View itemView) {
        super(itemView);
		this.context = itemView.getContext();
	}

    public Context getContext() {
        return context;
    }
}
