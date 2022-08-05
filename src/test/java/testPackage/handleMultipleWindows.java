package testPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//a[contains(text(), 'OrangeHRM')]")).click();
		
		Set<String> handles= driver.getWindowHandles();
	
		// print all current window handles normal for loop
/*		for(String h: handles)
			System.out.println(h); */
		
		// 1. Iterator 
/*		Iterator<String> it = handles.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		System.out.println("Parent: " + parentId);
		System.out.println("Child: "+ childId); */
		
		
		// 2. List /ArrayList
		List <String> windowHandleList= new ArrayList(handles);
		String parentId = windowHandleList.get(0);
		String childId = windowHandleList.get(1);
		System.out.println("Parent: " + parentId);
		System.out.println("Child: "+ childId); 

		System.out.println("Current Window: "+ driver.getWindowHandle());
		driver.switchTo().window(childId);
		System.out.println("Changed to : "+ driver.getWindowHandle());
		driver.findElement(By.id("myText")).sendKeys("test");
		Thread.sleep(2000);
		driver.switchTo().window(parentId);
		driver.close();
	}

}
