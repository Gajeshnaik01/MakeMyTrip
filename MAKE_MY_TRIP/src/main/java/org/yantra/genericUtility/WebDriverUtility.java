package org.yantra.genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class has reuseable method
 * @author gajes
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	/**
	 * this method is used to intialize the webdriver
	 * @return
	 */
	public final WebDriver selelctWebdriver(String browser) {

		switch (browser) {
		case "chrome":WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();

		break;
		case "ie":WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();

		break;

		default:System.out.println("browser name not present in property file");
		break;	
		}
		return driver;
	}
	/**
	 * this method enyer url
	 * @param url
	 */
	public void sendUrl(String url) {
		driver.get(url);
	}
	
	

	/**
	 * this method is used to implicitly wait
	 * @param timeOut
	 */
	public void waitImplicitly( long timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public void waitExlicitly( long timeOut,WebElement element) {
		WebDriverWait wait=new  WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used maximize the browser
	 */
	public void maximizeDriver() {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * this method is used to handle popup
	 */
	public void acceptAlertPopUp() {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to handle popup
	 */
	public void dismissAlertPopUp() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to handle popup
	 * @param key
	 */
	public void sendkeysToAlertPopUp(String key) {
		driver.switchTo().alert().sendKeys(key);
	}
/**
 * this method is used to select the DropDown by Index
 * @param element
 * @param index
 */
	public void selectToDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to select the DropDown by ByValue
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used to select the DropDown by VisibleText
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method is used to deselect the DropDown by Index
	 * @param element
	 * @param index
	 */
	public void deSelectDropDown(WebElement element,int index) {
		Select s=new Select(element);
		 s.deselectByIndex(index);
	}
	/**
	 * this method is used to deselect the DropDown by ByValue
	 * @param element
	 * @param value
	 */
	public void deSelectDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	/**
	 * this method is used to deselect the DropDown by VisibleText
	 * @param text
	 * @param element
	 */
	public void deSelectDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
	/**
	 * this method is used to navigate back
	 */
	public void goBack() {
		driver.navigate().back();
	}
	/**
	 * this method is used switch to particular window or tab
	 */
	public void switchWin(String title) {
		Set<String> allTab = ThreadSafeClass.getDriver().getWindowHandles();
		for (String win : allTab) {
			ThreadSafeClass.getDriver().switchTo().window(win);
			if(ThreadSafeClass.getDriver().getTitle().contains(title)) {
				break;
			}
		}
	}
	public void switchWinUrl(String url) {
		Set<String> allTab = ThreadSafeClass.getDriver().getWindowHandles();
		for (String win : allTab) {
			ThreadSafeClass.getDriver().switchTo().window(win);
			if(ThreadSafeClass.getDriver().getCurrentUrl().contains(url)) {
				break;
			}
		}
	}
	/**
	 * this method is used take screenshot in Base64 format
	 */
	public String TakesScreenShotInBase64()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path=ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	
	public void frameSwitchById(String s) {
		driver.switchTo().frame(s);
	}
	
	public void parentFrame() {
		driver.switchTo().defaultContent();
	}
	
}
