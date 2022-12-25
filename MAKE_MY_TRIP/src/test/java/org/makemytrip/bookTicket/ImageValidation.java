package org.makemytrip.bookTicket;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageValidation {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("realme 9i (Prism Black, 128 GB) "+Keys.ENTER);
		Actions action=new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[.='Cart']"));
		action.moveToElement(element).perform();

		driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
		//driver.get("https://demo.automationtesting.in/Register.html");
		//driver.get("https://www.testyantra.com/");
		//WebElement logo = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
		//WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']/img"));
		
		Set<String> wins = driver.getWindowHandles();
		for (String string : wins) {
			driver.switchTo().window(string);
			if(driver.getCurrentUrl().contains("realme-9i-prism-black-128-gb")) {
				break;
			}
		}
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='_1BweB8']"));

		File img1 = logo.getScreenshotAs(OutputType.FILE);
		File img2= new File("./takesc/flipkart1.png");
		double result=compareImage(img1, img2);
		if(result>95) {
			System.out.println("Image Validated");
		}
		else {
			System.out.println("Image not Validated");
		}

	}

	public static double compareImage(File image1, File image2) throws IOException {
		System.out.println("comparing images :" + image1.getAbsolutePath() + " with image: " + image2);
		Pattern pattern1 = new Pattern(image1.getAbsolutePath());
		Pattern pattern2 = new Pattern(image2.getAbsolutePath());
		Finder finder = new Finder(pattern1.getImage());
	
		finder.find(pattern2);
		
		if (finder.hasNext()) {
			Match m = finder.next();
			System.out.println("Match found with: " + (m.getScore()) * 100 + "%");
			return m.getScore() * 100;
		} else {
			System.out.println("Image not found similar");
		}
		return 0;
	}




}
