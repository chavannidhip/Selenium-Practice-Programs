package testPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en");
	//	driver.manage().window().maximize();
		// Syntax
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript(Script, args);

		WebElement logo = driver.findElement(By.xpath("//img[@title='nopCommerce']"));
		
		String defaultColor= logo.getCssValue("backgroundColor");
		//flashing
		for(int i=0; i<10;i++)
		{
			js.executeScript("arguments[0].style.backgroundColor='red'", logo);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.backgroundColor='"+ defaultColor+ "'", logo);
		}
		
		/*//Drawing Border  & Take screenshot
		javaScriptUtility.drawBorder(driver, logo);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);

		// Getting title of the page
		System.out.println(javaScriptUtility.getDocumentTitle(driver));

		// click action
		WebElement demoLink = driver.findElement(By.xpath("//a[@class='get-started-link btn black-border-button']"));
		
		javaScriptUtility.clickOnElement(driver, demoLink);
		
		// Generate JS Alert
		js.executeScript("alert('This is my Alert...')");
		
		driver.switchTo().alert().accept();
	
		// Refresh page
		
		js.executeScript("history.go(0)");
		
		// scroll up and down page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
		// zoom in, out page
		
		js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(1000);
		
		js.executeScript("document.body.style.zoom='100%'");
		*/
		Thread.sleep(2000);
		driver.quit();
	}

}
