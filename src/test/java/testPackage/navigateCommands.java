package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigateCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.navigate().to("https://google.com");
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		driver.quit();
	}

}
