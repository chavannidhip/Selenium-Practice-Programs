package testPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// Alert with Ok
	/*	driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		driver.switchTo().alert().accept(); 
		
		//Alert with cancel
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss();*/
		
		// Alert with prompt
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.sendKeys("test");
		al.accept();
	//	al.dismiss();
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
