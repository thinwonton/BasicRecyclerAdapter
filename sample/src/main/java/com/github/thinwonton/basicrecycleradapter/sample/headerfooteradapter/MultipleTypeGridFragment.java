package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.sample.GridFragment;

/**
 * Created by HUGO on 2016/4/12.
 */
public class MultipleTypeGridFragment extends GridFragment {
    //display a item with 2 span in type2
	@Override
	protected BasicAdapter createAdapter() {
		return new MultipleGridAdapter();
	}

}
