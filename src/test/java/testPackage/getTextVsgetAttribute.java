package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttribute {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement txtEmail = driver.findElement(By.id("Email"));
		System.out.println("Default value: " + txtEmail.getAttribute("Value"));
		txtEmail.clear();
		txtEmail.sendKeys("abc@gmail.com");
		Thread.sleep(1000);
		System.out.println("New Entered value: " + txtEmail.getText());
		System.out.println("Default value: " + txtEmail.getAttribute("Value"));
		
		WebElement label = driver.findElement(By.xpath("//label[@for='Email']"));
		System.out.println("Label getText: " + label.getText());
		System.out.println("Label getAttribute: "+ label.getAttribute("For"));
		driver.quit();
	}

}
