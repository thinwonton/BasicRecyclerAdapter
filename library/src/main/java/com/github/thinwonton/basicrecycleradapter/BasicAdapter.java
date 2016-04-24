package com.github.thinwonton.basicrecycleradapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.thinwonton.basicrecycleradapter.util.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUGO on 2016/4/12.
 */
public abstract class BasicAdapter<T, VH extends BasicViewHolder/*, AL extends ActionListener*/>
        extends RecyclerView.Adapter<VH> implements Operation<T> {

	private List<T> items = new ArrayList<>();

	private LayoutInflater inflater;

//	private AL listener;

	protected abstract VH viewHolder(View view, int type);

	protected abstract @LayoutRes int layoutId(int type);

    protected abstract int getItemType(int position);

//	public void setActionListener(AL listener) {
//		this.listener = listener;
//	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
		if (this.inflater == null) {
			this.inflater = LayoutInflater.from(recyclerView.getContext());
		}
	}

    @Override
	public VH onCreateViewHolder(ViewGroup parent, int viewType) {
		return onCreateItemViewHolder(parent, viewType);
	}

	@Override
	public void onBindViewHolder(VH holder, int position) {
		holder.bindView(getItem(position), getItemType(position));
	}

	@Override
	public int getItemCount() {
		return getRealItemCount();
	}

	@Override
	public List<T> getItems() {
		return this.items;
	}

	@Override
	public T getItem(int position) {
		return this.items.get(position);
	}

	@Override
	public void setItems(List<? extends T> items) {
		this.items.clear();
		this.items.addAll(items);
		notifyDataSetChanged();
	}

	@Override
	public void addItem(int position, T item) {
		this.items.add(position, item);
		notifyItemInserted(position);
	}

	@Override
	public void addItem(T item) {
		this.items.add(item);
		notifyItemInserted(this.items.size() - 1);
	}

	@Override
	public void addItems(List<? extends T> items) {
		final int size = this.items.size();
		this.items.addAll(items);
		notifyItemRangeInserted(size, items.size());
	}

	@Override
	public void addItems(int position, List<? extends T> items) {
		this.items.addAll(position, items);
		notifyItemRangeInserted(position, items.size());
	}

	@Override
	public void updateItem(int position, T item) {
		this.items.set(position, item);
		notifyItemChanged(position);
	}

	@Override
	public void removeItem(int position) {
		this.items.remove(position);
		notifyItemRemoved(position);
	}

	@Override
	public void clearItems() {
		items.clear();
		notifyDataSetChanged();
	}

    @Override
    public int getRealItemCount() {
        return this.items != null ? this.items.size() : 0;
    }

    protected VH onCreateItemViewHolder(ViewGroup parent, int type) {
		return viewHolder(this.inflater.inflate(layoutId(type), parent, false), type);
	}

}
