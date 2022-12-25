package org.makemytrip.bookTicket;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement logo = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
		File src = logo.getScreenshotAs(OutputType.FILE);
		File desc= new File("./takesc/logo.png");
		try {
			FileUtils.copyFile(src, desc);
			System.out.println("sc Taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		Set<String> win = driver.getWindowHandles();
		System.out.println(win.size());
		String win1 = null;
		for (String string : win) {
			driver.switchTo().window(string);

			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains("flipkart")) {
				win1=string;
			}
			else {
				driver.close();
			}
		}
	

		driver.switchTo().window(win1);

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("phones"+Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<String> product = new ArrayList<String>();
		for (WebElement webElement : list) {
			product.add(webElement.getText().toUpperCase());
		}
		Collections.sort(product);
		System.out.println(product.size());
		for (String string : product) {
			System.out.println(string);
		}



	}

}
