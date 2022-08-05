package testPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_jQueryDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("justAnInputBox")).click();
		//	selectChoiceValues(driver, "choice 1", "choice 4","choice 5");
		selectChoiceValues(driver, "All");
		driver.quit();
	}

	public static void selectChoiceValues(WebDriver driver, String... value)
	{
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if(!value[0].equalsIgnoreCase("all")) // if one or some choices needs to selected
		{
			for(WebElement item: choiceList)
			{
				String choice = item.getText();
				for(String eachValue:value)
				{
					if(choice.equals(eachValue))
					{
						item.click();
						break;
					}
				}
			}
		}
		else // if All options are selected
		{
			try {
				for (WebElement item: choiceList)
				{
					item.click();
				}}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}

	}
}
