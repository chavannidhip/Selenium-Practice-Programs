package testPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortDropDownValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		WebElement drpDownElement = driver.findElement(By.id("searchDropdownBox"));
		
		Select drpDown=new Select(drpDownElement);
		List<WebElement> options=drpDown.getOptions();
		
		ArrayList origList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for(WebElement option:options)
		{
			origList.add(option.getText());
			tempList.add(option.getText());
		}
	
		System.out.println("Original List                :" + origList );
		System.out.println("Temparary List Before Sorting:" + tempList);
		Collections.sort(tempList); // sorting of 2nd List
		
		System.out.println("Temparary List After Sorting :" + tempList);
		if(origList.equals(tempList))
			System.out.println("dropdown is sorted.");
		else
			System.out.println("Dropdown is Unsorted.");
		driver.quit();
	}

}
