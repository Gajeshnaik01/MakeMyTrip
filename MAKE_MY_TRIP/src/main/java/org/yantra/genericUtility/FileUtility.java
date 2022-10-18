package org.yantra.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @param args
 */
public class FileUtility {
	/**
	 * this method is used to intialize excel data
	 */
	Properties properties;
	public void intializePropertyFile(String propertyPath){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to get data from property file
	 * @param key
	 * @return
	 */
	public String getDataFromProperty(String key){
		String data=properties.getProperty(key);
		return data;
	}
	
	
}
