package com.github.thinwonton.basicrecycleradapter.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.github.thinwonton.basicrecycleradapter.sample.headerfooteradapter.HeaderFooterAdapterActivity;
import com.github.thinwonton.basicrecycleradapter.sample.simpleadapter.SimpleAdapterActivity;
import com.github.thinwonton.basicrecycleradapter.sample.mutipletypeadapter.MultipleTypeAdapterActivity;

public class MainActivity extends ListActivity {
	private String[] demoTitles = { "SimpleAdapter", "MultipleAdapter", "HeaderFooterAdapter" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListAdapter adapter = new ArrayAdapter<>(this, R.layout.main_list_item, R.id.title,
		        demoTitles);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (0 == position) {
                    startActivity(new Intent(MainActivity.this, SimpleAdapterActivity.class));
                } else if (1 == position) {
                    startActivity(new Intent(MainActivity.this, MultipleTypeAdapterActivity.class));
                } else if (2 == position) {
                    startActivity(new Intent(MainActivity.this, HeaderFooterAdapterActivity.class));
                }

            }
		});
	}

}
