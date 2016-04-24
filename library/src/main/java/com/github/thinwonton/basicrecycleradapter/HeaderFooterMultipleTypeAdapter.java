package com.github.thinwonton.basicrecycleradapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.github.thinwonton.basicrecycleradapter.util.LayoutManagerTypeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUGO on 2016/4/12.
 */
public abstract class HeaderFooterMultipleTypeAdapter<T, VH extends BasicViewHolder>
        extends MultipleTypeAdapter<T, VH> {
	public static final int TYPE_HEADER = 7898;
	public static final int TYPE_FOOTER = 7899;

	private List<View> headers = new ArrayList<>();
	private List<View> footers = new ArrayList<>();

	public View getHeaderView(int position) {
		return headers.get(position);
	}

	public void addHeaderView(View header) {
		if (!headers.contains(header)) {
			headers.add(header);
			notifyItemInserted(headers.size() - 1);
		}
	}

	public void removeHeader(View header) {
		if (headers.contains(header)) {
			notifyItemRemoved(headers.indexOf(header));
			headers.remove(header);
		}
	}

	public int getHeaderViewsCount() {
		return headers.size();
	}

	public View getFooterView(int position) {
		return footers.get(position);
	}

	public void addFooterView(View footer) {
		if (!footers.contains(footer)) {
			footers.add(footer);
			notifyItemInserted(headers.size() + getItems().size() + footers.size() - 1);
		}
	}

	public void removeFooterView(View footer) {
		if (footers.contains(footer)) {
			// animate
			notifyItemRemoved(headers.size() + getItems().size() + footers.indexOf(footer));
			footers.remove(footer);
		}
	}

	public int getFooterViewsCount() {
		return footers.size();
	}

	@Override
	public void addItem(int position, T item) {
		getItems().add(position, item);
		notifyItemInserted(position);
		int positionStart = position + getHeaderViewsCount();
		int itemCount = getItems().size() - position;
		notifyItemRangeChanged(positionStart, itemCount);
	}

	@Override
	public void addItem(T item) {
		getItems().add(item);
		notifyItemInserted(getItems().size() - 1 + getHeaderViewsCount());
	}

	@Override
	public void addItems(List<? extends T> items) {
		final int size = getItems().size();
		getItems().addAll(items);
		notifyItemRangeInserted(size + getItems().size(), items.size());
	}

	@Override
	public void addItems(int position, List<? extends T> items) {
		getItems().addAll(position, items);
		notifyItemRangeInserted(position + getHeaderViewsCount(), items.size());
	}

	@Override
	public void updateItem(int position, T item) {
		getItems().set(position, item);
		notifyItemChanged(position + getHeaderViewsCount());
	}

	@Override
	public void removeItem(int position) {
		getItems().remove(position);
		notifyItemRemoved(position + getHeaderViewsCount());
		int positionStart = position + getHeaderViewsCount();
		int itemCount = getItems().size() - position;
		notifyItemRangeChanged(positionStart, itemCount);
	}

	@Override
	public void clearItems() {
		final int size = getItems().size();
		getItems().clear();
		notifyItemRangeRemoved(getHeaderViewsCount(), size);
	}

	@Override
	public int getItemCount() {
		return this.headers.size() + getRealItemCount() + this.footers.size();
	}

	@Override
	final public int getItemViewType(int position) {
		if (isHeader(position)) {
			return TYPE_HEADER;
		}
		else if (isFooter(position)) {
			return TYPE_FOOTER;
		}
		int type = getItemType(getRealItemPosition(position));
		if (type == TYPE_HEADER || type == TYPE_FOOTER) {
			throw new IllegalArgumentException(
			        "Item type cannot equal " + TYPE_HEADER + " or " + TYPE_FOOTER);
		}
		return type;
	}

	@Override
	public VH onCreateViewHolder(ViewGroup viewGroup, int type) {
		// if our position is one of our items (this comes from
		// getItemViewType(int position) below)
		if (type != TYPE_HEADER && type != TYPE_FOOTER) {
			return onCreateItemViewHolder(viewGroup, type);

		}
		// else we have a header/footer
		else {
			// create a new framelayout, or inflate from a resource
			FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
			// make sure it fills the space
			setHeaderFooterLayoutParams(frameLayout);
			return (VH) new HeaderFooterViewHolder(frameLayout);
		}
	}

	@Override
	public void onBindViewHolder(VH holder, int position) {
		if (isHeader(position)) {
			View v = headers.get(position);
			// add our view to a header view and display it
			prepareHeaderFooter((HeaderFooterViewHolder) holder, v);
		}
		else if (isFooter(position)) {
			View v = footers.get(position - getRealItemCount() - getHeaderViewsCount());
			// add our view to a footer view and display it
			prepareHeaderFooter((HeaderFooterViewHolder) holder, v);
		}
		else {
			super.onBindViewHolder(holder, getRealItemPosition(position));
		}
	}

	protected void setHeaderFooterLayoutParams(ViewGroup viewGroup) {
		ViewGroup.LayoutParams layoutParams;
		if (LayoutManagerTypeHelper.isLinearLayout(getLayoutManager())) {
			int orientation = ((LinearLayoutManager) getLayoutManager()).getOrientation();
			if (orientation == LinearLayoutManager.VERTICAL) {
				layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);
			}
			else {
				layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.MATCH_PARENT);
			}
		}
		else {
			layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
			        ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		viewGroup.setLayoutParams(layoutParams);
	}

	@Override
	protected int getGridSpan(int type, int position) {
		if (isHeader(position) || isFooter(position)) {
			return getMaxGridSpan();
		}
		return super.getGridSpan(type, getRealItemPosition(position));
	}

	private void prepareHeaderFooter(HeaderFooterViewHolder vh, View view) {
		if (LayoutManagerTypeHelper.isStaggeredGridLayout(getLayoutManager())) {
			StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(
			        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			layoutParams.setFullSpan(true);
			vh.itemView.setLayoutParams(layoutParams);
		}

		ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
		layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
		vh.itemView.setLayoutParams(layoutParams);

		// if the view already belongs to another layout, remove it
		if (view.getParent() != null) {
			((ViewGroup) view.getParent()).removeView(view);
		}
		// empty out our FrameLayout and replace with our header/footer
		((ViewGroup) vh.itemView).removeAllViews();
		((ViewGroup) vh.itemView).addView(view);
	}

	private boolean isHeader(int position) {
		return (position < headers.size());
	}

	private boolean isFooter(int position) {
		return footers.size() > 0 && (position >= getHeaderViewsCount() + getRealItemCount());
	}

	protected int getRealItemPosition(int position) {
		return position - headers.size();
	}

	public static class HeaderFooterViewHolder extends EmptyViewHolder {
		public HeaderFooterViewHolder(View itemView) {
			super(itemView);
		}
	}
}
