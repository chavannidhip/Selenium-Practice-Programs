package testPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleLinks {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
/*		driver.get("https://www.amazon.com");
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		// print all links with text and link
		for(WebElement link : links)
			System.out.println(link.getText() + " ==> " + link.getAttribute("href"));
*/
		
		driver.get("http://www.deadlinkcity.com/");
		List <WebElement> links = driver.findElements(By.tagName("a"));
	
		int brokenLinks =0;
		for(WebElement element : links)
		{
			String url = element.getAttribute("href");
			
			if(url == null || url.isEmpty())
			{
				System.out.println("URL is empty.");
				continue;
			}
			
			URL link =new URL(url);
			try {
				HttpURLConnection conn = (HttpURLConnection)link.openConnection();
				conn.connect();
				if(conn.getResponseCode()>=400)
				{
					System.out.println("Bad link... "+  url + " ===>  "+ conn.getResponseCode());
					brokenLinks ++;
				}
				else
					System.out.println(" Valid link ... "+ url + " ===>  "+  conn.getResponseCode());
			} catch (Exception e) {}
		}
		System.out.println("Total Broken Links are: "+ brokenLinks);
		
		driver.quit();
	}
}
