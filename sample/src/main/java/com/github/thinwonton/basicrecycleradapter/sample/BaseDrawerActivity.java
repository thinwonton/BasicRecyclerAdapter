package com.github.thinwonton.basicrecycleradapter.sample;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.thinwonton.basicrecycleradapter.sample.utils.OnMenuClickListener;

public abstract class BaseDrawerActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener {
	private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	private Toolbar mToolbar;
	private ActionBarDrawerToggle mDrawerToggle;

    protected abstract Fragment getLinearFragment();
    protected abstract Fragment getGridFragment();
    protected abstract Fragment getStaggeredGridFragment();

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_adapter);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		if (mToolbar != null) {
			mToolbar.inflateMenu(R.menu.menu_main);
			mToolbar.setOnMenuItemClickListener(this);
		}

		mPlanetTitles = getResources().getStringArray(R.array.planets_array);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, R.id.title,
		        mPlanetTitles));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
		        R.string.drawer_open, R.string.drawer_close);
		mDrawerLayout.addDrawerListener(mDrawerToggle);
		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onPostCreate(savedInstanceState, persistentState);
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentById(R.id.content_frame);
		if (fragment == null || !(fragment instanceof OnMenuClickListener)) {
			return false;
		}

		OnMenuClickListener listener = (OnMenuClickListener) fragment;

		int itemId = item.getItemId();
		if (R.id.action_add == itemId) {
			listener.onAddItemActionClick();
		}
		else if (R.id.action_delete == itemId) {
			listener.onDeleteItemActionClick();
		}
		else if (R.id.action_clear == itemId) {
			listener.onClearItemsActionClick();
		}
		else if (R.id.action_set == itemId) {
			listener.onSetItemsActionClick();
		}
		else if (R.id.action_add_header == itemId) {
			listener.onAddHeaderActionClick();
		}
		else if (R.id.action_remove_header == itemId) {
			listener.onRemoveHeaderActionClick();
		}
		else if (R.id.action_add_footer == itemId) {
			listener.onAddFooterActionClick();
		}
		else if (R.id.action_remove_footer == itemId) {
			listener.onRemoveFooterActionClick();
		}
		else {
			return false;
		}

        return true;
    }

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position, long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		Fragment fragment;
		switch (position) {
			case 0:
				fragment = getLinearFragment();
				break;
			case 1:
                fragment = getGridFragment();
				break;
			case 2:
			default:
                fragment = getStaggeredGridFragment();
        }
		Bundle args = new Bundle();
		args.putInt(BaseFragment.ARG_DRAWER_MENU_INDEX, position);
		fragment.setArguments(args);
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(mPlanetTitles[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		super.setTitle(title);
		mToolbar.setTitle(title);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
