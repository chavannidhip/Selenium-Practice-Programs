package testPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//1. Select specific checkbox
	//	driver.findElement(By.id("monday")).click();
		
		//2. select all chekboxes of the week
		
		List<WebElement> allChkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		System.out.println("Total number of checkboxes: "+ allChkboxes.size());
/*		for(WebElement eachCheckbox: allChkboxes)
		{
			eachCheckbox.click();
		}	
		
		//3. select checkbox based on choice Monday and Sunday
		
		for(WebElement eachCheckbox: allChkboxes)
		{
			String name= eachCheckbox.getAttribute("id");
			System.out.println(name);
			if(name.equalsIgnoreCase("Monday") || name.equalsIgnoreCase("Sunday"))
			{
				eachCheckbox.click();
			}
		}*/
		
		//4. Last 2 number of checkboxes

		int totalSize = allChkboxes.size();
	 	for(int i=totalSize-3; i <totalSize;i++) // for weekend
	//	for(int i=0; i <totalSize-2;i++)	// for week days
	//	for(int i =0; i<2; i++)	 // for first 2 days
		{
			allChkboxes.get(i).click();
		}
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
