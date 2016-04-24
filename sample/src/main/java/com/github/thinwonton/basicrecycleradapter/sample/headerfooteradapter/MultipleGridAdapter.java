package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import android.view.View;

import com.github.thinwonton.basicrecycleradapter.MultipleTypeAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.R;
import com.github.thinwonton.basicrecycleradapter.sample.model.Cat;

/**
 * Created by Administrator on 2016/4/19.
 */
public class MultipleGridAdapter extends MultipleTypeAdapter<Cat, MultipleGridViewHolder> {
	@Override
	protected MultipleGridViewHolder viewHolder(View view, int type) {
		return new MultipleGridViewHolder(view);
	}

	@Override
	protected int getGridSpan(int type, int position) {
		if (Cat.TYPE.TYPE2.ordinal() == type) {
			return getMaxGridSpan();
		}
		return super.getGridSpan(type, position);
	}

	@Override
	protected int layoutId(int type) {
		if (Cat.TYPE.TYPE1.ordinal() == type) {
			return R.layout.list_cat_type1_item;
		}
		else {
			return R.layout.list_cat_type2_item;
		}
	}

	@Override
	protected int getItemType(int position) {
		return getItem(position).getType();
	}

}
