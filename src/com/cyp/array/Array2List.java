package com.cyp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pierre
 * @Date 2017-3-8
 * @version v1.0
 * 
 */
public class Array2List {

	public static void main(String[] args) {
		testOne();
		testTwo();
		testThree();
	}

	/**
	 * asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList体现的是适配器模式
	 * ，只是转换接口，后台的数据仍是数组。
	 * 
	 */
	public static void testOne() {
		String[] str = new String[] { "a", "b" };
		List<String> list = Arrays.asList(str);
		// list.add("c"); 抛出异常
		str[0] = "c";
		System.out.println(list.get(0));

	}

	public static void testTwo() {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if ("1".equals(temp)) {
				a.remove(temp);
			}
		}

	}

	public static void testThree() {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if ("2".equals(temp)) {
				a.remove(temp);
			}
		}

	}

}
