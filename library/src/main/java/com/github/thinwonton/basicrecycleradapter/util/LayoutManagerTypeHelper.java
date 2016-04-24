package com.github.thinwonton.basicrecycleradapter.util;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by hugo on 2015/9/30.
 */
public class LayoutManagerTypeHelper {
	public enum LAYOUT_MANAGER_TYPE {
		LINEAR, GRID, STAGGERED_GRID
	}

	public static boolean isLinearLayout(RecyclerView.LayoutManager layoutManager) {
		return LAYOUT_MANAGER_TYPE.LINEAR == getLayoutManagerType(layoutManager);
	}

	public static boolean isGridLayout(RecyclerView.LayoutManager layoutManager) {
		return LAYOUT_MANAGER_TYPE.GRID == getLayoutManagerType(layoutManager);
	}

	public static boolean isStaggeredGridLayout(RecyclerView.LayoutManager layoutManager) {
		return LAYOUT_MANAGER_TYPE.STAGGERED_GRID == getLayoutManagerType(layoutManager);
	}

	public static LAYOUT_MANAGER_TYPE getLayoutManagerType(
	        RecyclerView.LayoutManager layoutManager) {
		LAYOUT_MANAGER_TYPE layoutManagerType = null;
		if (null != layoutManager) {
			if (layoutManager instanceof GridLayoutManager) {
				layoutManagerType = LAYOUT_MANAGER_TYPE.GRID;
			}
			else if (layoutManager instanceof LinearLayoutManager) {
				layoutManagerType = LAYOUT_MANAGER_TYPE.LINEAR;
			}
			else if (layoutManager instanceof StaggeredGridLayoutManager) {
				layoutManagerType = LAYOUT_MANAGER_TYPE.STAGGERED_GRID;
			}
			else {
				throw new ClassCastException(
				        "Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
			}
		}

		return layoutManagerType;
	}

}
