package com.github.thinwonton.basicrecycleradapter.util;

import java.util.List;

/**
 * Created by HUGO on 2016/4/12.
 */
public interface Operation<T> {

	List<T> getItems();

	T getItem(int position);

	void setItems(List<? extends T> items);

	void addItem(int position, T item);

	void addItem(T item);

	void addItems(List<? extends T> items);

	void addItems(int position, List<? extends T> items);

	void updateItem(int position, T item);

	void removeItem(int position);

	void clearItems();

	int getRealItemCount();
}
