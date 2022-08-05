package testPackage;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ststusOFWebElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		try {
			WebElement txtSearch= driver.findElement(By.name("q"));
			WebElement radioMale = driver.findElement(By.id("gender-male"));
			WebElement radioFemale = driver.findElement(By.id("gender-female"));
			//driver.findElement(By.linkText("Register")).click();
			System.out.println(txtSearch.isDisplayed());
			System.out.println(txtSearch.isEnabled());
			System.out.println("Radio Male: " + radioMale.isSelected());
			radioMale.click();
			System.out.println("Radio Male: " + radioMale.isSelected());
			radioFemale.click();
			System.out.println("Radio Female: " + radioFemale.isSelected());
		}catch (Exception e)
		{
			System.out.println(Time.valueOf(LocalTime.now())+ "  --- Element does not find by automation. ---- " + e);
		}
		finally {
			driver.manage().window().minimize();
			driver.quit();
		}
	}
}

