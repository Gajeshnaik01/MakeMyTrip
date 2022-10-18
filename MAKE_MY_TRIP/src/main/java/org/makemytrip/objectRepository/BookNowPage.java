package org.makemytrip.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.ThreadSafeClass;

public class BookNowPage {

	
	public BookNowPage() {
		PageFactory.initElements(ThreadSafeClass.getDriver(),this);
	}
	
	@FindBy(xpath = "//p[text()='Popular Filters']/following-sibling::div/descendant::span[@title='IndiGo']")
	private WebElement indigo;
	
	@FindBy(xpath = "//button[text()='Book Now']")
	private WebElement bookNow;
	
	@FindBy(xpath = "//span[text()='RETURN']/ancestor::div[@class='multifareContentLeft']/following-sibling::div/descendant::p[.='Saver']")
	private WebElement clickOnSaverradioBtn;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continuebtn;
	
	public BookNowPage clickOnIndigoCheckBox() {
		ThreadSafeClass.getWebDriverUtility().waitExlicitly(10, bookNow);
		
		indigo.click();
		
		return this;
	}
	public BookNowPage clickOnBookNow() {
		bookNow.click();
		return this;
	}
	public BookNowPage clickOnSaver() {
		clickOnSaverradioBtn.click();
		return this;
	}
	public void clickOnContinue() {
		continuebtn.click();
	}
	
	
}
