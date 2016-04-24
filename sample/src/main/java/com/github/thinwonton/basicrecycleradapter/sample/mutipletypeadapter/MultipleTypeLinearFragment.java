package com.github.thinwonton.basicrecycleradapter.sample.mutipletypeadapter;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.LinearFragment;

/**
 * Created by HUGO on 2016/4/12.
 */
public class MultipleTypeLinearFragment extends LinearFragment {
	@Override
	protected BasicAdapter createAdapter() {
		return new MultipleLinearAdapter();
	}

}
