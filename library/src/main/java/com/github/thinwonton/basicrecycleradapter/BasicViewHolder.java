package com.github.thinwonton.basicrecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.thinwonton.basicrecycleradapter.action.OnItemClickListener;

/**
 * Created by hugo on 2016/4/19.
 */
public abstract class BasicViewHolder<T> extends RecyclerView.ViewHolder {

	private OnItemClickListener onItemClickListener;

	private int realPosition;

	private final View.OnClickListener innerItemViewClickListener = new InnerOnItemViewClickListener();

	public abstract void bindView(T item, int type);

	public void bindView(int position, T item, int type){
        setRealPosition(position);
        bindView(item, type);
    }

	public BasicViewHolder(View itemView) {
		super(itemView);
		itemView.setOnClickListener(this.innerItemViewClickListener);
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		this.onItemClickListener = listener;
	}

	public int getRealPosition() {
		return realPosition;
	}

	public void setRealPosition(int position) {
		this.realPosition = position;
	}

	private final class InnerOnItemViewClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (onItemClickListener != null) {
				onItemClickListener.onItemClick(itemView, getRealPosition());
			}
		}
	}

}
