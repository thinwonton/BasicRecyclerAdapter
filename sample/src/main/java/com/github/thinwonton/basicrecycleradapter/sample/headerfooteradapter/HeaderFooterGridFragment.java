package com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.thinwonton.basicrecycleradapter.BasicAdapter;
import com.github.thinwonton.basicrecycleradapter.action.OnItemClickListener;
import com.github.thinwonton.basicrecycleradapter.sample.model.Cat;

/**
 * Created by HUGO on 2016/4/12.
 */
public class HeaderFooterGridFragment extends HeaderFooterBaseFragment {
	// display a item with 2 span in type2
	@Override
	protected BasicAdapter createAdapter() {
		return new HeaderFooterGridAdapter();
	}

	@Override
	protected void configRecyclerView(RecyclerView recyclerView) {
		RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
		recyclerView.setLayoutManager(layoutManager);
	}


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAdapter().setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Cat cat = (Cat) getAdapter().getItem(position);
                Toast.makeText(getActivity(), "cat name = " + cat.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
