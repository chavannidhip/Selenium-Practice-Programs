package testPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElementVsfindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		//1. findElement 
		WebElement searchTxt = driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]"));
		searchTxt.sendKeys("ABC");
		
		//2. findElements
		WebElement link = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(link.getText());
		
		List <WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("Number of links: " + links.size());
		
		System.out.println("***********");
		for(WebElement l : links)
		{
			System.out.println(l.getText());
		}
	
	/*	List <WebElement> serachBoxes = driver.findElements(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Number of serachBoxes: " + serachBoxes.size());*/
	
		//  no exception if no element is found for findElements... returns zero
	/*	List <WebElement> links = driver.findElements(By.xpath("//div[@class='footer-uppe']//a"));
		System.out.println("Number of links: " + links.size());*/
	
		
		driver.quit();
	}

}
