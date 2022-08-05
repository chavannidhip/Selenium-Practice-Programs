package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/maps");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("searchboxinput")).sendKeys("6462");
		
		Thread.sleep(1000);
		driver.quit();
	}

}
