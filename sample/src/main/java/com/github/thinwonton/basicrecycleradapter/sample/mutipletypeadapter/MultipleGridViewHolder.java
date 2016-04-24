package com.github.thinwonton.basicrecycleradapter.sample.mutipletypeadapter;

import android.view.View;
import android.widget.TextView;

import com.github.thinwonton.basicrecycleradapter.BasicViewHolder;
import com.github.thinwonton.basicrecycleradapter.sample.R;
import com.github.thinwonton.basicrecycleradapter.sample.model.Cat;

public class MultipleGridViewHolder extends BasicViewHolder<Cat> {
	private TextView index;
	private TextView name;

	public MultipleGridViewHolder(View itemView) {
		super(itemView);
		index = (TextView) itemView.findViewById(R.id.index);
		name = (TextView) itemView.findViewById(R.id.name);
	}

	@Override
	public void bindView(Cat item, int type) {
		index.setText(String.valueOf(item.getIndex()));
		name.setText(String.valueOf(item.getName()));
	}
}
