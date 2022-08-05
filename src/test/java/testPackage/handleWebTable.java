package testPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		
		//1.  number of columns
		List <WebElement> columns= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		int colSize = columns.size();
		System.out.println("Number of columns are: "+ colSize);
		
		// 2. number of rows
		List <WebElement> rows= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowSize =  rows.size();
		System.out.println("Number of rows are: "+rowSize);
		
		//3.  get specific data
		System.out.println(driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[3]/td")).getText());
		
		// 4. get entire table data
		/*
		System.out.println("Table content: ");
		for(int c=1;c<=colSize;c++) // headers
		{
			String cellData = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr/th[" +c+ "]")).getText();
			System.out.print(cellData+ "	|	");
		}
		System.out.println();
		for(int r=2;r<=rowSize;r++) //data from 2nd row
		{
			for(int c=1;c<=colSize;c++)
			{
				String cellData = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" +r+ "]/td[" +c+ "]")).getText();
				System.out.print(cellData+ "	|	");
			}
			System.out.println();	
		} 
		*/
		// 5. get conditional data- fetch contact and country if company is 'Adobe'
		
		for(int r=2;r<=rowSize;r++) //data from 2nd row
		{
				String company = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" +r+ "]/td[1]")).getText();
			
				if(company.equals("Microsoft"))
				{
					String contact= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" +r+ "]/td[2]")).getText();
					String country= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" +r+ "]/td[3]")).getText();
					System.out.println(company + contact +  country);
					break;
				}
			}
	
		driver.quit();
	}

}
