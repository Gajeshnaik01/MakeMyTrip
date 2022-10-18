package org.yantra.genericUtility;

import org.openqa.selenium.WebDriver;

public class ThreadSafeClass {
	
	
private static	ThreadLocal<WebDriver> driver=new ThreadLocal<>();
private static	ThreadLocal<JavaUtility> javaUtility=new ThreadLocal<>();
private static	ThreadLocal<ExcelUtility> excelUtility=new ThreadLocal<>();
private static	ThreadLocal<WebDriverUtility> webDriverUtility=new ThreadLocal<>();

public static JavaUtility getJavaUtility() {
	return javaUtility.get();
}

public static void setJavaUtility(JavaUtility javaUtility1) {
	javaUtility.set(javaUtility1);
}

public static ExcelUtility getExcelUtility() {
	return excelUtility.get();
}

public static void setExcelUtility(ExcelUtility excelUtility1) {
	excelUtility.set(excelUtility1);
}

public static WebDriver getDriver() {
	return driver.get();
}

public static void setDriver(WebDriver actdriver) {
	driver.set(actdriver);
}

public static WebDriverUtility getWebDriverUtility() {
	return webDriverUtility.get();
}

public static void setWebDriverUtility(WebDriverUtility actwebDriverUtility) {
	webDriverUtility.set(actwebDriverUtility);
}
	

}
