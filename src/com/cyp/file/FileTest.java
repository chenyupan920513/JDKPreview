package com.cyp.file;

import java.io.File;


/**  
 * @author     pierre  
 * @Date       2017-3-6  
 * @version    v1.0
 *
 */
public class FileTest {
	public static void main(String[] args) {
		
		String filePath = "F://tttt/t/";
		File file = new File(filePath);
		if(!file.exists())
			file.mkdirs();
	}

}
