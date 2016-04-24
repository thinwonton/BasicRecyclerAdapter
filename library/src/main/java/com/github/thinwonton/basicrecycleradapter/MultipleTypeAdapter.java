package com.github.thinwonton.basicrecycleradapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.thinwonton.basicrecycleradapter.util.LayoutManagerTypeHelper;

/**
 * Created by HUGO on 2016/4/12.
 */
public abstract class MultipleTypeAdapter<T, VH extends BasicViewHolder>
        extends BasicAdapter<T, VH> {

	private RecyclerView.LayoutManager layoutManager;

	private GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
		@Override
		public int getSpanSize(int position) {
			int itemViewType = getItemViewType(position);
			return getGridSpan(itemViewType, position);
		}
	};

	protected int getGridSpan(int type, int position) {
		return 1;
	}

	protected int getMaxGridSpan() {
		if (layoutManager instanceof GridLayoutManager) {
			return ((GridLayoutManager) layoutManager).getSpanCount();
		}
		return 1;
	}

    protected RecyclerView.LayoutManager getLayoutManager(){
        return this.layoutManager;
    }

	@Override
	public int getItemViewType(int position) {
		return getItemType(position);
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);

		this.layoutManager = recyclerView.getLayoutManager();
		if (LayoutManagerTypeHelper.isGridLayout(layoutManager)) {
			((GridLayoutManager) this.layoutManager).setSpanSizeLookup(spanSizeLookup);
		}
	}

}
