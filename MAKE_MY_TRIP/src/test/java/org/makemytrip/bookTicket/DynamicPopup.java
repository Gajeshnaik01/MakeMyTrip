package org.makemytrip.bookTicket;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicPopup {

	public static void main(String[] args) {
		//ChromeOptions option=new ChromeOptions();
	//	option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		// option.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().setup();
		//option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//a[.='Widgets']")).click();
		driver.findElement(By.xpath("//a[.=' Accordion ']")).click();
		try {
			WebElement element1 = driver.findElement(By.xpath("//iframe[@id='aswift_2']"));
			
			try {

				driver.switchTo().frame(element1);
				driver.findElement(By.xpath("//*[name()='svg' and @fill='#5F6368']/*[name()='path' and contains(@d,'M38')]")).click();
				driver.switchTo().defaultContent();
				System.out.println("1st");
			}
			catch(Exception e) {

				WebElement element = driver.findElement(By.xpath("//iframe[@id='ad_iframe' and @title='Advertisement']"));
				driver.switchTo().frame(element);
				driver.findElement(By.xpath("//span[.='Close']")).click();
				driver.switchTo().defaultContent();
				System.out.println("2nd");
			}
		} 
		catch(Exception e) {
			System.out.println("No popup");
		}
		System.out.println("Test case passed");
		
		//driver.quit();
	}

}
