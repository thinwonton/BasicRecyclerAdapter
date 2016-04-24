package com.github.thinwonton.basicrecycleradapter.sample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/4/19.
 */
public class CatGenerator {
	public static String[] names = { "ailsa", "ailsaailsa", "alice", "cassiecatherine", "ella",
	        "frederica", "iris", "lucine", "mary", "pearl", "silvia", "zoey" };
	private static int index = 0;
	private static Random random = new Random();

	public static List<Cat> getList() {
		int count = 30;
		List<Cat> cats = new ArrayList<Cat>(count);
		for (int i = 0; i < count; i++) {
			cats.add(getItem());
		}
		return cats;
	}

	private static String getName() {
		return names[random.nextInt(names.length)];
	}

	public static Cat getItem() {
		return new Cat(index++, getName(), random.nextInt(Cat.TYPE.values().length));
	}
}
