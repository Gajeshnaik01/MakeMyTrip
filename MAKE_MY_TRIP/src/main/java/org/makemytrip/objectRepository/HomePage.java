package org.makemytrip.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.ThreadSafeClass;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(ThreadSafeClass.getDriver(),this);
	}

	@FindBy(xpath = "//i[@class='wewidgeticon we_close']")
	private WebElement closePopUp;

	private String id="webklipper-publisher-widget-container-notification-frame";

	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closeBottomPopUp;

	@FindBy(xpath = "//input[@id='fromCity']")
	private WebElement fromcity;

	private String selectCity="//p[.='%s']";

	private WebElement convertStringToWeblement(String xpath,String replace) {

		xpath=String.format(xpath, replace);

		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//input[@id='toCity']")
	private WebElement tocity;


	@FindBy(xpath = "//span[text()='DEPARTURE']")
	private WebElement departure;

	@FindBy(xpath = "//span[text()='RETURN']")
	private WebElement returnn;

	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	private WebElement next;

	private String selectDate="//div[contains(@aria-label,'%s')]/div";

	@FindBy(xpath = "//a[.='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='DayPicker-Caption' ]/div/span")
	private WebElement year;
	
	
	


	public HomePage closePopUp() {
		ThreadSafeClass.getWebDriverUtility().frameSwitchById(id);
		closePopUp.click();
		ThreadSafeClass.getWebDriverUtility().parentFrame();
		closeBottomPopUp.click();
		return this;
	}

	public HomePage fromCity(String city) {
		fromcity.click();
		convertStringToWeblement(selectCity,city).click();
		return this;
	}
	public HomePage toCity(String city) {
		tocity.click();
		convertStringToWeblement(selectCity,city).click();
		return this;
	}

	public HomePage selectDepatureDate(String date) {
		departure.click();
		while(true) {
			try {
				convertStringToWeblement(selectDate,date).click();
				break;
			}
			catch(Exception e) {
				next.click();
			}
		}

		return this;
	}
	public HomePage selectReturnDate(String date) {
		returnn.click();
		while(true) {
			try {
				convertStringToWeblement(selectDate,date).click();
				break;
			}
			catch(Exception e) {
				next.click();
			}
		}
		return this;
	}

	public BookNowPage clickSearch() {
		searchBtn.click();
		return new BookNowPage();
	}







}
