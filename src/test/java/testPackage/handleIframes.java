package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleIframes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium.devtools']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	//	driver.switchTo().frame("packageFrame");
	//	driver.findElement(By.xpath("//a[normalize-space()='AbstractAnnotations']"));

		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[contains(text(),'Help')]")).click();
		Thread.sleep(2000);
		//driver.quit();
	}

}
