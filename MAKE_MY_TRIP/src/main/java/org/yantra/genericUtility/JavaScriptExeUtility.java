package org.yantra.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExeUtility {
	private JavascriptExecutor js;
	/**
	 * @return 
	 * this method is used to intialize javascript executot
	 */
		public JavascriptExecutor webDriverToJavaScriptEx(WebDriver driver){
			 js=(JavascriptExecutor)driver;
			return js;
		}
		/**
		 * this method is used to get URL
		 * @param url
		 */
		public void getUrl(String url){
			js.executeScript("window.location='"+url+"'");
		}
		/**
		 * 
		 * @param 
		 */
		
		public void sendkeyToElement(WebElement element, String keys){
			js.executeScript("arguments[0].value=arguments[1]",element,keys);
		}
		
		/**
		 * this method is used click element
		 * @param url
		 */
		public void clickToElement(WebElement element){
			js.executeScript("arguments[0].click()",element);
		}
		/**
		 * this method is used to scroll
		 */
		public void scrollTo(int x,int y){
			js.executeScript("window.scrollBy("+x+","+y+")");
		}
		/**
		 * this method is used to scroll
		 * @param x
		 */
		public void scrollToHeight(int x){
			js.executeScript("window.scrollBy("+x+",document.body.scrollHeight)");
		}
		/**
		 * this method is used to scroll
		 */
		public void scrollToWidth(int y){
			js.executeScript("window.scrollBy(document.body.scrollWidth,"+y+")");
		}
		/**
		 * this method is used to scroll by element
		 */
		public void scrollToElement(WebElement element){
			js.executeScript("arguments[0].scrollIntoView()", element);
		}
}
