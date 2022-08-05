package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver", "<path of the chrome driver saved on your system>");
		
//	 	to avoid downloading correct version of chrome driver and mentioning the path here..
//		 instead use WebDriverManager dependency in pom.xml 	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://frontend.nopcommerce.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getPageSource());
		driver.quit();
	
	}

}
