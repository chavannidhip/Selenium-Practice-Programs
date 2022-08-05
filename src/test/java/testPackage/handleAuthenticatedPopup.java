package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleAuthenticatedPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Some URL will ask for authentication popup after opening .. 
		// this popup can not be inspected, so we can't automate it...
		// we have to inject user name and password in the URL itself
	
		// Syntax ==> https://username:password@URL
		// https://admin:admin@the-internet.herokuapp.com/basic_auth
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}
