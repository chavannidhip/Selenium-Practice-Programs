package testPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestDropDown_BingSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.bing.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> listSuggestions = driver.findElements(By.xpath("//div[@class='sa_tm']/span"));
		
		System.out.println("Size of auto suggestions: "+ listSuggestions.size());
		Thread.sleep(2000);
		for(WebElement option:listSuggestions)
		{
			if (option.getText().contains("selenium download"))
			{
				option.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
