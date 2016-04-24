package com.github.thinwonton.basicrecycleradapter.sample.model;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.thinwonton.basicrecycleradapter.sample.R;

/**
 * Created by hugo on 2016/4/22.
 */
public class HeaderFooterGenerator {
	public static View inflateHeader(Context context, @Nullable ViewGroup root) {
		return LayoutInflater.from(context).inflate(R.layout.list_header_item, root, false);
	}

	public static View inflateFooter(Context context, @Nullable ViewGroup root) {
		return LayoutInflater.from(context).inflate(R.layout.list_footer_item, root, false);
	}

}
