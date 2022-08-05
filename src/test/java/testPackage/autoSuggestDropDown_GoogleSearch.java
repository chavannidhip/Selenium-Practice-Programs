package testPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestDropDown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(2000);
		List<WebElement> listSuggestions = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]/span"));
		
		System.out.println("Size of auto suggestions: "+ listSuggestions.size());
		
		for(WebElement option:listSuggestions)
		{
			if (option.getText().contains("java tutorial youtube"))
			{
				option.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
