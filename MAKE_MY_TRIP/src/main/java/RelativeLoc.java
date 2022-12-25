import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLoc {

	public static void main(String[] args) {
		WebDriver driver=WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement right = driver.findElement(By.xpath("//span[text()='Clothing']"));
		WebElement up = driver.findElement(By.xpath("//span[text()='Bags & luggage']"));
		
		

	}

}
