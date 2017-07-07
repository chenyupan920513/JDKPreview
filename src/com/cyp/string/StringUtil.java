package com.cyp.string;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author pierre
 * @Date 2017-2-24
 * @version v1.0
 * 
 */
public class StringUtil {
	public static void main(String[] args) {
		int youNumber = 100;
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		String str = String.format("%04d", youNumber);
		System.out.println(str); // 0001
		
		System.out.println(haoAddOne_2("50"));
	}
	
	private static final String STR_FORMAT = "0000"; 

	public static String haoAddOne_2(String liuShuiHao){
	    Integer intHao = Integer.parseInt(liuShuiHao);
	    intHao++;
	    DecimalFormat df = new DecimalFormat(STR_FORMAT);
		LinkedList list = new LinkedList();
		ArrayList list2 = new ArrayList();
		list.add(1);
		list.add(2);
		return df.format(intHao);

	}
}
