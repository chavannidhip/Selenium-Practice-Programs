package testPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");

		WebElement ddCountry = driver.findElement(By.id("input-country"));
		
		Select drpdCountry = new Select(ddCountry);
		
		// Select inbuilt methods
	/* drpdCountry.selectByVisibleText("India");
		Thread.sleep(1000);
		drpdCountry.selectByValue("98");
		Thread.sleep(1000);
		drpdCountry.selectByIndex(13);
		*/
		
		// select option without using inbuilt methods
		List <WebElement> options = drpdCountry.getOptions();
		for (WebElement ele : options)
		{
			if(ele.getText().equals("Cuba"))
			{
					ele.click();
					break;
			}
		}
			
		Thread.sleep(1000);
		driver.quit();
	}

}
