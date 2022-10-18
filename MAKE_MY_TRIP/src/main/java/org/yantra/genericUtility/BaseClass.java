package org.yantra.genericUtility;


import org.makemytrip.objectRepository.BookNowPage;
import org.makemytrip.objectRepository.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseClass extends InstanceClass {


	@BeforeSuite
	public void suiteSetup() {


	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void classSetup() {
		//creating object for Utility class
		WebDriverUtility=new WebDriverUtility();
		excelUtility=new ExcelUtility();
		fileUtility=new FileUtility();
		javaUtility=new JavaUtility();
		js=new JavaScriptExeUtility();
		soft=new SoftAssert();

		ThreadSafeClass.setWebDriverUtility(WebDriverUtility);
		ThreadSafeClass.setExcelUtility(excelUtility);
		ThreadSafeClass.setJavaUtility(javaUtility);

		//Fetching data from excel
		excelUtility.intializeExcel(IConstants.EXCELFILEPATH);
		fileUtility.intializePropertyFile(IConstants.PROPERTYFILEPATH);
		url=fileUtility.getDataFromProperty("url");
		userusername=fileUtility.getDataFromProperty("userusername");
		userpassword=fileUtility.getDataFromProperty("userpassword");
		browser=fileUtility.getDataFromProperty("browser");
		to=fileUtility.getDataFromProperty("timeout");
		currentUrl=fileUtility.getDataFromProperty("currentUrl");
		timeouts = javaUtility.convertStringToLong(to);
		//fetching data from excel



		driver=WebDriverUtility.selelctWebdriver(browser);
		ListenerImpClass.testLog.info("Browser Opened");
		//driver=WebDriverUtility.selelctWebdriver(BROWSER);

		ThreadSafeClass.setDriver(driver);
		WebDriverUtility.maximizeDriver();
		WebDriverUtility.waitImplicitly(timeouts);
		WebDriverUtility.sendUrl(url);
	
		//pom class object creation 
	    homePage=new HomePage();
	    bookNowPage=new BookNowPage();
	
		js.webDriverToJavaScriptEx(driver);

	}
	@BeforeMethod
	public void methodSetup() {

	}
	@AfterMethod
	public void methodTearDown() {
	
		WebDriverUtility.closeBrowser();
	}
	@AfterClass
	public void classTearDown() {
		
		
		ListenerImpClass.testLog.info("Browser closed");
	}

	@AfterSuite
	public void suiteTearDown() {

		excelUtility.closeWorkbook();

	}


}
