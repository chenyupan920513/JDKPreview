package com.cyp.Enum;

import java.util.HashMap;
import java.util.Map;

public class GetColor {

	public static void main(String args[]) {
//		 Color colors=new Color(100,200,300); //wrong
		Color color = Color.BLUE;
		System.out.println(color); // 调用了toString()方法
		System.out.println(Color.BLACK.ordinal());
		System.out.println(Color.BLACK.compareTo(Color.RED));
		Map  map = new HashMap();
	}
}
