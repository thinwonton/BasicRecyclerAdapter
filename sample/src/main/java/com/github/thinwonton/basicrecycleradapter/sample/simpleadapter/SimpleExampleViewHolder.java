package com.github.thinwonton.basicrecycleradapter.sample.simpleadapter;

import android.view.View;
import android.widget.TextView;

import com.github.thinwonton.basicrecycleradapter.SingleTypeViewHolder;
import com.github.thinwonton.basicrecycleradapter.sample.R;
import com.github.thinwonton.basicrecycleradapter.sample.model.Cat;

public class SimpleExampleViewHolder extends SingleTypeViewHolder<Cat> {
	private TextView index;
	private TextView name;

	public SimpleExampleViewHolder(View itemView) {
		super(itemView);
		index = (TextView) itemView.findViewById(R.id.index);
		name = (TextView) itemView.findViewById(R.id.name);
	}

	@Override
	public void bindView(Cat item) {
		index.setText(String.valueOf(item.getIndex()));
		name.setText(String.valueOf(item.getName()));
	}
}
