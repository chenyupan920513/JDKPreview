package cycle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**  
 * @author     pierre  
 * @Date       2017-2-27  
 * @version    v1.0
 *
 */
public class ForCircleTest {
	
	  static List<String> list = new ArrayList<>();
	static void  for1(){
		
		for (int i = 0; i <list.size(); i++)
			System.out.println(list.get(i));
	}
	static void  for2(){
		for (int i = 0,  length = list.size(); i < length; i++)
			System.out.println(list.get(i));
	}
	
	public static void main(String[] args) {
	  	for(int i=0;i<100;i++){
	  		list.add("hah");
	  	}
		System.out.println(new Date().getTime());
		for1();
		System.out.println(new Date().getTime());
		for2();
		System.out.println(new Date().getTime());
		
	}
	
}