package org.yantra.genericUtility;

import java.util.Random;
/**
 * this method contains all the reusable method
 * @author gajes
 *
 */
public class JavaUtility {
	/**
	 * 
	 * @return
	 */
	public int getRandomNum(){
		return new Random().nextInt(1000);
	}
	
	/**
	 * this method is print the statement in the console
	 * @param statement
	 */
	public void printStatement(String statement) {
		System.out.println(statement);
	}
	
	/**
	 * this method is used to convert String to Long
	 * @param num
	 * @return
	 */
	public long convertStringToLong(String num) {
		return Long.parseLong(num); 
	}
	/**
	 * this method is used to convert String to Integer 
	 * @param num
	 * @return
	 */
	public long convertStringToInteger(String num) {
		return Integer.parseInt(num); 
	}
	
}
